package net.xiaoxiangshop.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import net.xiaoxiangshop.Filter;
import net.xiaoxiangshop.Order;
import net.xiaoxiangshop.entity.MemberAttribute;
import net.xiaoxiangshop.service.MemberAttributeService;

/**
 * 模板指令 - 会员注册项列表
 * 
 */
public class MemberAttributeListDirective extends BaseDirective {

	/**
	 * 变量名称
	 */
	private static final String VARIABLE_NAME = "memberAttributes";

	@Inject
	private MemberAttributeService memberAttributeService;

	/**
	 * 执行
	 * 
	 * @param env
	 *            环境变量
	 * @param params
	 *            参数
	 * @param loopVars
	 *            循环变量
	 * @param body
	 *            模板内容
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer count = getCount(params);
		List<Filter> filters = getFilters(params, MemberAttribute.class);
		List<Order> orders = getOrders(params);
		boolean useCache = useCache(params);

		List<MemberAttribute> memberAttributes = memberAttributeService.findList(true, count, filters, orders, useCache);
		setLocalVariable(VARIABLE_NAME, memberAttributes, env, body);
	}

}