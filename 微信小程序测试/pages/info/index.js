// pages/info/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    formData:{},
    array:["女", "男", "其他"],
    nikeName:'',
    sex:'',
    token:'',
  },
  getNickName(e){
    this.setData({
      nikeName:e.detail.value
    })
  },
  bindPickerChange(e){
    this.setData({
      sex:e.detail.value,
     'formData.userSex':e.detail.value
    })
  },
  subFun(e){
    // console.log(e)
    let type = e.currentTarget.dataset.type;
    let data={
      token:this.data.token,
      value:type===1?this.data.nikeName:this.data.sex,
      tag:type===1?'nikeName':'userSex',
    };
    wx.request({
      method:'POST',
      header:{"Content-Type": "application/x-www-form-urlencoded"},
      url: 'https://test.zhaoxiedu.net/api/User/SetUser/', 
      data:data,
      success (res) {
        if (res.statusCode == 212) {
          wx.showToast({
            title: '登录超时',
            icon: 'none',
            duration: 2000
          })
          wx.removeStorage({
            key: 'zxToken',
            success (res) {
              wx.navigateTo({
                url: '/pages/login/index',
              })
            }
          })
       } else if(res.statusCode == 214) {
        wx.showToast({
          title: res.data,
          icon: 'none',
          duration: 2000
        })
       }else {
        wx.showToast({
          title: '修改成功',
          duration: 2000
        })
       }
      }
    })
  
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
    var value = wx.getStorageSync('userInfo')
    this.setData({
      formData:JSON.parse(value),
      token: wx.getStorageSync('zxToken')
    })
    console.log(this.data.formData)
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