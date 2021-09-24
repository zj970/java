// pages/case/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    course:[],
    imgHttpStr:'https://www.zhaoxiedu.net',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let _this = this
    wx.request({
      url: 'https://www.zhaoxiedu.net/static/json/course.json', //当前请求的接口地址
      data: "",//data当前请求接口的参数
      method:"GET",//当前请求的请求方式
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        _this.setData({
          course:res.data
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if(typeof this.getTabBar=="function"&&this.getTabBar()){
      this.getTabBar().setData({
        selected:2
      })
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})