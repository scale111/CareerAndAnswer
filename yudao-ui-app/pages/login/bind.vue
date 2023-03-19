<template>
  <view>
    <view style="padding: 2%;margin-top: 5%;">
      <view>
        <picker @change="bindPickerChange" :value="index" :range="array">
          <u-input disabledColor="#ffffff" disabled :placeholder="array[index]"></u-input>
        </picker>
       <!-- <uni-data-select v-model="value" :localdata="member_type" @change="pickchange" label="请选择身份:">
        </uni-data-select> -->
      </view>
    </view>
    <view class="teacher" style="padding: 2%;" v-if="index==1">
      <u--form labelPosition="left" :borderBottom="borderBottom" :model="formdata" ref="form1" :rules="rules">
        <u-form-item prop="userInfo.name" :borderBottom="borderBottom" ref="userInfo.name" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.name" border="none"></u-input> -->
          <u-input type="string" v-model="formdata.userInfo.name"
          	placeholder="请输入姓名"></u-input>
        </u-form-item>
        <u-form-item prop="userInfo.number" :borderBottom="borderBottom" ref="userInfo.number" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.number" border="none" style="text-align: right;"></u-input> -->
          <u-input type="string" v-model="formdata.userInfo.number"
          	placeholder="请输入学号/工号"></u-input>
        </u-form-item>
      </u--form>
    </view>
    <view class="student" style="padding: 2%;" v-if="index==2">
      <u--form labelPosition="left" :borderBottom="borderBottom" :model="formdata" ref="form1" :rules="rules">
        <u-form-item prop="userInfo.name" :borderBottom="borderBottom" ref="userInfo.name" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.name" border="none"></u-input> -->
          <u-input type="string" v-model="formdata.userInfo.name"
          	placeholder="请输入姓名"></u-input>
        </u-form-item>
        <u-form-item prop="userInfo.number" :borderBottom="borderBottom" ref="userInfo.number" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.number" border="none" style="text-align: right;"></u-input> -->
          <u-input type="string" v-model="formdata.userInfo.number"
          	placeholder="请输入学号/工号"></u-input>
        </u-form-item>
        <u-form-item prop="userInfo.phone" :borderBottom="borderBottom" ref="userInfo.phone" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.phone" border="none"></u-input> -->
          <u-input type="string" v-model="formdata.userInfo.phone"
          	placeholder="请输入电话号码"></u-input>
        </u-form-item>
        <u-form-item prop="userInfo.idcard" :borderBottom="borderBottom" ref="userInfo.idcard" labelWidth="auto">
          <!-- <u-input v-model="formdata.userInfo.idcard" border="none"></u-input> -->
          <u-input type="string" maxlength="6" v-model="formdata.userInfo.idcard"
          	placeholder="请输入身份证后六位"></u-input>
        </u-form-item>
      </u--form>
    </view>
    <view style="padding: 5%;margin-top: 5%;">
      <u-button class="btn" type="primary" @click="submit()">提交</u-button>
    </view>
  </view>
</template>

<script>
  export default {
    data() {
      return {
        borderBottom:false,
        index: 0,
        array: ['请选择身份', '导师', '学生'],
        rules: {
          'userInfo.phone': {
            type: 'string',
            required: true,
            message: '请填写电话号码',
            trigger: ['blur', 'change']
          },
          'userInfo.number': {
            type: 'string',
            required: true,
            message: '请填写学号/工号',
            trigger: ['blur', 'change']
          },
          'userInfo.name': {
            type: 'string',
            required: true,
            message: '请填写姓名',
            trigger: ['blur', 'change']
          },
          'userInfo.idcard': {
            type: 'string',
            required: true,
            message: '请填写身份证号后六位',
            trigger: ['blur', 'change'],
            len: 6
          }
        },
        value: 0,
        show: false,
        formdata: {
          userInfo: {
            number: "",
            name: "",
            idcard: "",
            phone:""
          },

        }
      }
    },
    methods: {
      bindPickerChange: function(e) {
      	console.log('index:')
      	this.index = e.detail.value
        console.log(this.index);
      },
      submit() {
        this.$refs.form1.validate().then(res => {
          uni.$u.toast('校验通过')
        }).catch(errors => {
          uni.$u.toast('校验失败')
        })
      }
    },
    onReady() {
      //如果需要兼容微信小程序，并且校验规则中含有方法等，只能通过setRules方法设置规则。
      this.$refs.form1.setRules(this.rules)
    },
  }
</script>

<style>

</style>
