// pages/login/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgValidateCode: 0,
    formData: {
      qq: '',
      psa: '',
      code: ''
    }
  },
  //设置随机码，验证码
  setImgFun() {
    this.setData({
      imgValidateCode: this.data.imgValidateCode + 1
    })
  },
  formInputChange(e) {
    console.log(e);
    this.data.formData[e.currentTarget.dataset.field] = e.detail.value;
    this.setData({
      formData: this.data.formData
    })
  },
  //按钮点击事件
  loginFun() {
    console.log(this.data.formData);
    if (!this.data.formData.qq || !this.data.formData.psa || !this.data.formData.code) {
      //都为空事件
      wx.showToast({
        title: '填写信息不完整',
        icon: 'error',
        duration: 2000
      })
    }
    else {
      let _this = this
      wx.request({
        method:'POST',
        header:{"Content-Type": "application/x-www-form-urlencoded"},
        url: 'https://test.zhaoxiedu.net/api/Login/CheckLogin', 
        data:{
          qq:this.data.formData.qq,
          pwd:this.data.formData.psa,
          validateString:this.data.formData.code
        },
        success (res) {
          if(res.statusCode!=200){
            wx.showToast({
              title: res.data,
              icon: 'error',
              duration: 2000
            })
            _this.setImgFun()
          }else{
            wx.setStorage({
              key:"zxToken",
              data:res.data
            })
           _this.getInfo(res.data)
          }
        }
      })
    }
  },
  goRegister(){
    wx.navigateTo({
      url: '/pages/register/index',
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