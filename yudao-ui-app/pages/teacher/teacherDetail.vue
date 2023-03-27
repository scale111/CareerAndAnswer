<template>
	<view class="container">
    <view class="avatar">
      <u-image mode="aspectFit" :src="teacherInfo.photo"></u-image>
    </view>
    <view class="info">
      <text class="bio-header">导师简介:</text>
      <view>
        {{teacherInfo.bio}}
      </view>
      <text class="bio-header">详细信息:</text>
      <mp-html :content="teacherInfo.dio"  :selectable="true"  />
    </view>
    <view class="btn">
    	<u-button customStyle="margin-top:5%" text="发起预约" type="primary"></u-button>
    </view>
	</view>
</template>

<script>
  import {getTeacherDetailInfo} from '../../api/teacher.js'

	export default {
    onLoad(option) {
      this.getTeacherDetailInfo(option.id);
    },
		data() {
			return {
        teacherInfo:{}
			};
		},
    methods:{
      getTeacherDetailInfo(id){
        getTeacherDetailInfo({
          data:{
            id:id
          }
        }).then(res =>{
          this.teacherInfo = res.data
          console.log(res)
        })
      }
    }
	}
</script>

<style lang="scss" scoped>
  .avatar {
  	display: flex;
  	flex-direction: row;
  	justify-content: center;
  	margin-top: 2%;
  }
  .btn {
  	display: flex;
  	flex-direction: column;
  	align-items: center;
  	margin: 15%;
  }
  .info{
    margin: 5vw;
  }
  .bio-header{
    font-weight: bold;
  }
</style>
