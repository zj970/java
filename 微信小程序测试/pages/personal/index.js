// pages/personal/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list :[[],[],[]],
    imgHttpStr:'https://www.zhaoxiedu.net',
    token:'1',
  },

  outLogin(){
    wx.removeStorage({
      key: 'zxToken',
      success (res) {
        wx.switchTab({
          url: '/pages/index/index',
        }) 
      }
    })
  },
  goLogin(){
    wx.navigateTo({
      url: '/pages/login/index',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let _this = this
    wx.request({
      url: 'https://test.zhaoxiedu.net/api/Resource/GetResourceList/', //当前请求的接口地址
      data: "",//data当前请求接口的参数
      method:"GET",//当前请求的请求方式
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        let data=res.data
        _this.setData({
         'list[0]' :data.filter(v=>v.type===1),
         'list[1]' :data.filter(v=>v.type===2),
         'list[2]' :data.filter(v=>v.type===3),
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
    let _this = this
    if(typeof this.getTabBar =="function" &&this.getTabBar()){
      this.getTabBar().setData({
       selected:4
      })
    }
    try {
      var value = wx.getStorageSync('zxToken')
      if (value) {
        _this.setData({
          token:value
        })
      }else{
        _this.setData({
          token:''
        })
      }
    } catch (e) {
      _this.setData({
        token:''
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