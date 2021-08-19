// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    tabList:[],
    imgHttpStr:'http://www.zhaoxiedu.net'
  },
 
  onLoad() {
    let _this = this
    wx.request({
      url: 'http://www.zhaoxiedu.net/static/json/public.json', //当前请求的接口地址，data表示当前请求接口的参数，可以是对象，字符串，json
      method:"GET",//当前请求的方式
      data: "",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        _this.setData({
          tabList:res.data
        })
      }
    })
  },
  
  onShow: function (options) {
    if(typeof this.getTabBar=="function"&&this.getTabBar()){
      this.getTabBar().setData({
        selected:0
      })
    }
  }
})
