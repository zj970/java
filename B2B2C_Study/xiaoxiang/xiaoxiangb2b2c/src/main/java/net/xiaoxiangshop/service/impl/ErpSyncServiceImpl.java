package net.xiaoxiangshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.xiaoxiangshop.ErpInterfaceMethod;
import net.xiaoxiangshop.Setting;
import net.xiaoxiangshop.dao.OrderPaymentDao;
import net.xiaoxiangshop.entity.*;
import net.xiaoxiangshop.entity.api.order.*;
import net.xiaoxiangshop.entity.api.orderUpload.*;
import net.xiaoxiangshop.service.*;
import net.xiaoxiangshop.util.SystemUtils;
import net.xiaoxiangshop.util.WebUtils;
import net.xiaoxiangshop.util.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service - ERP接口同步
 */
@Service
public class ErpSyncServiceImpl implements ErpSyncService {

    private static final Logger _logger = LoggerFactory.getLogger(ErpSyncServiceImpl.class);
    /**
     * ERP中台接口URL
     */
    @Value("${erp_basic_url}")
    private String erp_basic_url;
    //商城电子卷
    public  static String E_COUPONS="0217";
    /**
     * 订单key
     */
    public static final String BILLKEY = "0";
    /**
     * 会员卡号
     */
    public static final String HYKH = "";
    /**
     * 单品折扣金额
     */
    public static final String COUNTERED_DISCOUNT = "0";
    /**
     * 单品折扣厂商分摊比例
     */
    public static final String CSUPPLY_RATE = "0";
    /**
     * 会员折扣金额
     */
    public static final String VIP_DISCOUNT = "0";

    /**
     * 总价折扣金额
     */
    public static final String TOTAL_DISCOUNT = "0";
    /**
     * 总价折扣厂商分摊比例
     */
    public static final String TCSUPPLY_RATE = "0";

    /**
     * 促销折扣金额
     */
    public static final String POPZK = "0";

    /**
     * 整单折扣金额
     */
    public static final String RULEZK = "0";
    /**
     * 会员折扣分摊金额
     */
    public static final String CUSTZKFD = "0";
    /**
     * 促销折扣分摊金额
     */
    public static final String POPZKFD = "0";
    /**
     * 促销活动编号
     */
    public static final String POPDJBH = "";
    /**
     * 整单折扣编号
     */
    public static final String RULEDJBH = "";
    /**
     * 整单折扣分摊金额
     */
    public static final String RULEDZKFD = "0";

    /**
     * 卡券支付时，填写支付前的余额
     */
    public static final String AVALUES = "0";
    /**
     * 卡券支付时，填写支付后的余额
     */
    public static final String BALANCE = "0";
    /**
     * 银联卡号或卡券号或请求号或商户订单号
     */
    public static final String REQCODE = "";
    /**
     * 交易号或参考号
     */
    public static final String TRADE_CODE = "";
    /**
     * 流水号或凭证号
     */
    public static final String LSH = "";

    /**
     * 资金类型
     */
    public static final String BANKTYPE = "";
    /**
     * 交易渠道
     */
    public static final String TRADE_CHANNEL = "";
    /**
     * 冷冻店专柜号
     */
    public static final String STORE_NO = "202011271";

    @Inject
    private OrderService orderService;
    @Inject
    private OrderPaymentDao orderPaymentDao;
    @Inject
    private MemberService memberService;
    @Inject
    private ProductService  productService;

    //获取单品信息
    public List<SkusRequestOrderUpload> findErpSkus(String store_no,String barcode,String vipid,String erpRank)  {
        //调用单品接口查询数据
        Map map=new HashMap();
        map.put("method",ErpInterfaceMethod.GET_GOODS_INFO);
        map.put("orgid",store_no);
        map.put("code",barcode);
        map.put("vipid",vipid);
        map.put("viptypeid",erpRank);
        map.put("stime","");
        String send = JSONObject.toJSONString(map);
        String retV = null;
        try {
            retV = WebUtils.sendPost(erp_basic_url, send);
        } catch (IOException e) {
            _logger.info("获取单品信息失败.");
            e.printStackTrace();
        }
        JSONObject obj = JSONObject.parseObject(retV);
        String subcode = obj.getString("sub_code");
        List<SkusRequestOrderUpload> skusRequestOrderUploads = new ArrayList<>();
        if("0".equals(subcode)){
            skusRequestOrderUploads = JSON.parseArray(obj.getJSONObject("data").getString("lists"), SkusRequestOrderUpload.class);
        }
        return skusRequestOrderUploads;
    }


    //获取优惠信息
    public List<ProductsRequestOrderUpload> searchDiscount(String orderSn)  {

        Setting setting = SystemUtils.getSetting();
        Order order = orderService.findBySn(orderSn);
        String store_no = order.getStore().getStoreNo();
        List<ProductsRequestOrderUpload> lstProductsRequestOrderUpload = new ArrayList<>();
        //会员卡号
        String vipid= order.getMember().getAttributeValue0()==null?"":order.getMember().getAttributeValue0();
        //会员ERP对应的等级
        String erpRank=order.getMember().getMemberRank().getErpRank();
        List<OrderItem> lstOrderItem = order.getOrderItems();
        for (OrderItem item : lstOrderItem) {
            Sku sku = item.getSku();
            BigDecimal csupplyrate = item.getProportion();
            String barcode =sku.getInternalNumber() == null ? "" : sku.getInternalNumber();
            String zgdm =sku.getCounterNo() == null ? "" : sku.getCounterNo();
            ProductsRequestOrderUpload productsRequestOrderUpload = new ProductsRequestOrderUpload();
            //商品条码
            try {
                productsRequestOrderUpload.setProductbarcode(URLEncoder.encode(barcode, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //专柜号
            productsRequestOrderUpload.setZgdm(zgdm);
            //输入的售价
            productsRequestOrderUpload.setIprice(String.valueOf(sku.getPrice()));
            //数量
            productsRequestOrderUpload.setQuantity(String.valueOf(item.getQuantity()));
            //合计金额
            productsRequestOrderUpload.setTotalamount(String.valueOf(sku.getPrice().multiply(new BigDecimal(item.getQuantity()))));
            //会员折扣金额
            productsRequestOrderUpload.setVipdiscount(VIP_DISCOUNT);
            //单品折扣金额
            productsRequestOrderUpload.setCounterdiscount(COUNTERED_DISCOUNT);
            //厂商分摊比例
            productsRequestOrderUpload.setCsupplyrate(CSUPPLY_RATE);
            //总价折扣金额
            productsRequestOrderUpload.setTotaldiscount(TOTAL_DISCOUNT);
            //总价折扣厂商分摊比例
            productsRequestOrderUpload.setTcsupplyrate(TCSUPPLY_RATE);
            //促销折扣金额
            productsRequestOrderUpload.setPopzk(POPZK);
            //会员折扣分摊金额
            productsRequestOrderUpload.setCustzkfd(CUSTZKFD);
            //整单折扣金额
//            productsRequestOrderUpload.setRulezk(RULEZK);
            //促销折扣分摊金额
//            productsRequestOrderUpload.setPopzkfd(POPZKFD);
            //促销活动编号
            productsRequestOrderUpload.setPopdjbh("POPDJBH");
            //整单折扣编号hykh
            productsRequestOrderUpload.setRuledjbh(RULEDJBH);
            //整单折扣分摊金额
            productsRequestOrderUpload.setRulezkfd(RULEDZKFD);

            //商品是否关联了促销


                Product  product=productService.find(sku.getProduct().getId());
                if(product.getErpFlag()){
                    List<SkusRequestOrderUpload> orderUploadList=findErpSkus(store_no,barcode,vipid,erpRank);
                    if(orderUploadList.size()>0){
                        SkusRequestOrderUpload skusRequestOrderUpload=orderUploadList.get(0);
                        //非定价商品
                        if("0".equals(skusRequestOrderUpload.getPrice())){
                            //会员折扣
                            //                        BigDecimal rcustzk=sku.getPrice().subtract(sku.getPrice().multiply(new BigDecimal(skusRequestOrderUpload.getRhyzkl()))).multiply(new BigDecimal(item.getQuantity())) ;
                            //会员折扣
                            BigDecimal rcustzk=(sku.getPrice().subtract(item.getPrice())).multiply(new BigDecimal(item.getQuantity()));

                        }else{
                            //促销折扣分摊金额
                            BigDecimal popzkfd=(new BigDecimal(skusRequestOrderUpload.getPopzkfd()).setScale(1,BigDecimal.ROUND_DOWN)).multiply(new BigDecimal(item.getQuantity()));
                            productsRequestOrderUpload.setPopzkfd(String.valueOf(setting.setScale(popzkfd)));
                            //促销活动编号
                            productsRequestOrderUpload.setPopdjbh(skusRequestOrderUpload.getPopdjbh());
                            //促销折扣金额
//                            BigDecimal popzk=(new BigDecimal(skusRequestOrderUpload.getPopzk()).setScale(1,BigDecimal.ROUND_DOWN)).multiply(new BigDecimal(item.getQuantity()));
                            productsRequestOrderUpload.setPopzk(String.valueOf(1));
                            productsRequestOrderUpload.setPopzk(String.valueOf(2));
//                            //整单折扣金额
//                            productsRequestOrderUpload.setRulezk(skusRequestOrderUpload.getRulezk());
//                            //会员折扣分摊金额
//                            productsRequestOrderUpload.setCustzkfd(skusRequestOrderUpload.getCustzkfd());
//                            //整单折扣编号hykh
//                            productsRequestOrderUpload.setRuledjbh(skusRequestOrderUpload.getRuledjbh());
//                            //整单折扣分摊金额
//                            productsRequestOrderUpload.setRulezkfd(skusRequestOrderUpload.getRulezkfd());
                            //会员折扣
                            productsRequestOrderUpload.setRulezk(skusRequestOrderUpload.getRulezk());

                            if(skusRequestOrderUpload.getViprate().equals("100")&&skusRequestOrderUpload.getVipzkatt().equals("0")){
                            }else{
                                BigDecimal rcustzk=(sku.getPrice().subtract(item.getPrice())).multiply(new BigDecimal(item.getQuantity()));
                            }
                        }
                    }
                }else{
                    BigDecimal rcustzk=(sku.getPrice().subtract(item.getPrice())).multiply(new BigDecimal(item.getQuantity()));
                }

        }
        return lstProductsRequestOrderUpload;


    }


    @Override
    public HashMap uploadOrder(String orderSn) {
        HashMap map = new HashMap();
        return  map;
    }

    /**
     * 上传订单
     *
     * @param orderSn 订单编号
     * @return 是否正常上传
     */
    public HashMap uploadOrderSeel(String orderSn) {
        Order order = orderService.findBySn(orderSn);
        // 更新冷冻店的订单状态,跳过审核，直接到待发货状态
        Store store=order.getStore();
        if(STORE_NO.equals(store.getStoreNo())){
            if(order.getStatus().getValue()==1){
                order.setStatus(Order.Status.PENDING_SHIPMENT);
                orderService.update(order);
            }
        }

        HashMap map = new HashMap();
        List<ProductsRequestOrderUpload>   searchDiscount=searchDiscount(orderSn);
        if(searchDiscount.size()==0){
            _logger.info("商品单品信息获取失败.");
            return map;
        }
        String req_orderSn = orderSn.substring(2, orderSn.length());
        String store_no = order.getStore().getStoreNo();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.setMethod(ErpInterfaceMethod.UPLOAD_PAYMENT);
        orderRequestBean.setOrgid(store_no);
        OrderData orderData = new OrderData();
        Head head = new Head();
        head.setBillkey("");
        head.setBillid(req_orderSn);
        Member m = memberService.find(order.getMemberId());
        head.setHykh(m.getAttributeValue0()==null?"":m.getAttributeValue0());
        try {
            head.setRecaddr(URLEncoder.encode(order.getAddress(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            head.setRecuser(URLEncoder.encode(order.getConsignee(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        head.setRectel(order.getPhone());
        head.setDeliveryfee(order.getFreight().intValue());
        head.setBilldate(formatter.format(order.getCreatedDate()));
        orderData.setHead(head);
        List<Products> lstProducts = new ArrayList<>();

        List<Payment> lstPayment = new ArrayList<>();
        Set<OrderPayment> orderPaymentSet = orderPaymentDao.findSet("orders", order.getId());

        for (OrderPayment orderPayment : orderPaymentSet) {
            Payment payment = new Payment();
            String pay_method = orderPayment.getPaymentMethod();

            if (null != pay_method) {

                if(pay_method.equals("TI")){
                    pay_method = pay_method.split("\\|")[1];
                }
                payment.setPaymentcode(pay_method);
                payment.setAmount(orderPayment.getAmount() == null ? "" : String.valueOf(orderPayment.getAmount()));

                payment.setAvalues(AVALUES);
//                payment.setBalance(BALANCE);
                payment.setReqcode(REQCODE);

//                payment.setTradecode(TRADE_CODE);
                payment.setPaytime(formatter.format(orderPayment.getCreatedDate()));
                payment.setLsh(LSH);
                payment.setBank_type(BANKTYPE);
                payment.setTrade_channel(TRADE_CHANNEL);
                lstPayment.add(payment);
            }
        }

        orderData.setPayment(lstPayment);

        try {

            for(ProductsRequestOrderUpload productsRequestOrderUpload : searchDiscount)
            {
                Products products = new Products();
//                products.setProductbarcode(productsRequestOrderUpload.getProductbarcode());
//                products.setZgdm(productsRequestOrderUpload.getZgdm());
//                products.setIprice(String.valueOf(productsRequestOrderUpload.getIprice()));
//                products.setQuantity(String.valueOf(productsRequestOrderUpload.getQuantity()));
                products.setTotalamount(String.valueOf(productsRequestOrderUpload.getTotalamount()));
                products.setCounterdiscount(productsRequestOrderUpload.getCounterdiscount());
                products.setCsupplyrate(productsRequestOrderUpload.getCsupplyrate());
                products.setTotalamount(String.valueOf(productsRequestOrderUpload.getTotalamount()));
                products.setCounterdiscount(productsRequestOrderUpload.getCounterdiscount());
                products.setCsupplyrate(productsRequestOrderUpload.getCsupplyrate());

                products.setTotalamount(String.valueOf(productsRequestOrderUpload.getTotalamount()));
                products.setCounterdiscount(productsRequestOrderUpload.getCounterdiscount());
                products.setCsupplyrate(productsRequestOrderUpload.getCsupplyrate());


//                products.setIprice(String.valueOf(productsRequestOrderUpload.getIprice()));
//                products.setQuantity(String.valueOf(productsRequestOrderUpload.getQuantity()));
//                products.setTotalamount(String.valueOf(productsRequestOrderUpload.getTotalamount()));
//                products.setCounterdiscount(productsRequestOrderUpload.getCounterdiscount());


//                products.setTotaldiscount(productsRequestOrderUpload.getTotaldiscount());
//                products.setPopzk(productsRequestOrderUpload.getPopzk());
//                products.setRulezk(productsRequestOrderUpload.getRulezk());
//                products.setCustzkfd(productsRequestOrderUpload.getCustzkfd());
//                products.setPopzkfd(productsRequestOrderUpload.getPopzkfd());
//                products.setPopdjbh(productsRequestOrderUpload.getPopdjbh());
//                products.setRuledjbh(productsRequestOrderUpload.getRuledjbh());
//                products.setRulezkfd(productsRequestOrderUpload.getRulezkfd());

//                products.setCustzkfd(productsRequestOrderUpload.getCustzkfd());
//                products.setPopzkfd(productsRequestOrderUpload.getPopzkfd());
//                products.setPopdjbh(productsRequestOrderUpload.getPopdjbh());
//                products.setRuledjbh(productsRequestOrderUpload.getRuledjbh());
//                products.setRulezkfd(productsRequestOrderUpload.getRulezkfd());

//                products.setCsupplyrate(productsRequestOrderUpload.getCsupplyrate());
//                products.setTotaldiscount(productsRequestOrderUpload.getTotaldiscount());
                products.setPopzk(productsRequestOrderUpload.getPopzk());
                products.setRulezk(productsRequestOrderUpload.getRulezk());
                products.setCustzkfd(productsRequestOrderUpload.getCustzkfd());
//                products.setPopzkfd(productsRequestOrderUpload.getPopzkfd());
//                products.setPopdjbh(productsRequestOrderUpload.getPopdjbh());
//                products.setRuledjbh(productsRequestOrderUpload.getRuledjbh());
//                products.setRulezkfd(productsRequestOrderUpload.getRulezkfd());
//                 if(true){
//                     String n="aa";
//                 }


//                lstProducts.add(products);
            }

            orderData.setProducts(lstProducts);
            orderRequestBean.setData(orderData);

            String  send = JSONObject.toJSONString(orderRequestBean);
            _logger.info("上传订单报文:"+send);


            String  retV = WebUtils.sendPost(erp_basic_url, send);
            JSONObject obj = JSONObject.parseObject(retV);
            String subcode = obj.getString("sub_code");

            order.setLastModifiedDate(new Date());
            order.setErpSyncTime(new Date());
            order.setErpSync(subcode);
            orderService.update(order);

            map.put("resultCode", subcode);

            JSONObject jsonObject = JSONObject.parseObject(retV);
            _logger.info("获取上传返回结果信息:"+jsonObject.getString("sub_msg"));
//            String msg=formatter.format(new Date()) +"订单号:"+order.getSn()+",发送报文："+send+",返回报文："+retV+"，返回结果："+jsonObject.getString("sub_msg");
//            System.out.println("订单上传");
//            XmlUtils.appendMethodC(msg,"订单上传");

        } catch (Exception e) {
            _logger.info("订单上传失败.");
            e.printStackTrace();
        }
        return map;
    }
}