// pages/bind/bind.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone:10086,
    password:10086
  },
  doLogin:function(e){
    console.log("进入登录事件"+e.detail.value.phone);
    wx.request({
      url: 'http://192.168.50.62:8080/doLogin',
      method:"POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data:{
        phone:e.detail.value.phone,
        password:e.detail.value.password
      },
      success:function(res){
        console.log(res);
        if(res.data.code == 200){
          if(res.data.result == "登录成功"){
            console.log("登录成功");
            wx.redirectTo({
              url: '../index/index',
            })
          }
          }
        }
      }
    )
  },
  redirectBtn:function(){

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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