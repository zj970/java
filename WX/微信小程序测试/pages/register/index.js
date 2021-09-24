// pages/login/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    formData:{
      NickName: '',
      Sex: 1,
      QQ: '',
      PhoneNum: '',
      Pwd: '',
      Pwd2: '',
      ValidateString:'',
    },
    array:["女", "男", "其他"],
    imgValidateCode:0
  },
  goLogin(){
    wx.navigateTo({
      url: '/pages/login/index',
    })
  },
  bindPickerChange(e){
      this.setData({
        'formData.Sex':e.detail.value
      })
  },
  setImgFun(){
      this.setData({
        imgValidateCode:this.data.imgValidateCode+1
      })
  },
  formInputChange(e){
    this.data.formData[e.currentTarget.dataset.field] = e.detail.value
    this.setData({
      formData:this.data.formData
    })
  },
  loginFun(){
    for (const key in this.data.formData) {
        const element = this.data.formData[key];
        if(!element){
          wx.showToast({
            title: '信息不完整',
            icon: 'error',
            duration: 2000
          })
          return
        }
    }
      let _this = this
      if(this.data.formData.Pwd!==this.data.formData.Pwd2){
        wx.showToast({
          title: '两次密码不一致',
          icon: 'error',
          duration: 2000
        })
        return
      }
      wx.request({
        method:'POST',
        header:{"Content-Type": "application/x-www-form-urlencoded"},
        url: 'https://test.zhaoxiedu.net/api/User/AddUser/', 
        data:this.data.formData,
        success (res) {
          console.log(res)
          let data= res.data.backInfo;
          let msg = '';
          switch(data){
              case 'success':
                msg = 1;
                break;
              case 'hasQQ':
                msg = 'QQ已注册，请直接登录';
                break;
              case 'validateErr':
                msg = '验证码输入错误';
                break;
              default:
                msg="";
                break;  
          }
          if(msg==1){
            wx.showModal({
              title: '提示',
              content: '注册成功，请联系客服人员开通权限',
              showCancel:false,
              success (res) {
                  wx.switchTab({
                    url: '/pages/index/index',
                  }) 
              }
            })
          }else{
            wx.showToast({
              title: msg,
              icon: 'none',
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