// pages/password/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      password:''
  },
  getValue(e){
    this.setData({
      password:e.detail.value
    })
  },
  subFun(){
    wx.request({
      method:'POST',
      header:{"Content-Type": "application/x-www-form-urlencoded"},
      url: 'https://test.zhaoxiedu.net/api/User/SetUser/', 
      data:{
        token:this.data.token,
        value:this.data.password,
        tag:'passWord'
      },
      success (res) {
        wx.hideLoading()
        if (res.statusCode == 212) {
          wx.showModal({
            title: '提示',
            showCancel:false,
            content: '登录超时,需要重新登录',
            success (res) {
              if (res.confirm) {
                wx.removeStorage({
                  key: 'zxToken',
                  success (res) {
                      wx.navigateTo({
                        url: '/pages/login/index',
                      })
                  }
                })
              } else if (res.cancel) {
                wx.switchTab({
                  url: '/pages/index/index',
                })
              }
            }
          })
         }else if(res.statusCode == 214) {
        wx.showToast({
          title: res.data,
          icon: 'none',
          duration: 2000
        })
       }else {
        wx.showModal({
          title: '提示',
          content: '修改成功,需要重新登录',
          success (res) {
            wx.removeStorage({
              key: 'zxToken',
            })
            if (res.confirm) {
              wx.navigateTo({
                url: '/pages/login/index',
              })
            } else if (res.cancel) {
              wx.switchTab({
                url: '/pages/index/index',
              })
            }
          }
        })
       }
      }
    })
   
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      token: wx.getStorageSync('zxToken')
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