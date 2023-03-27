<template>
	<view class="container">
    <view class="title">
      <text>{{careertalkInfo.title}}</text>
    </view>
    <view>
      <u-line></u-line>
    </view>
    <view class="base-info">
      <text>基本信息</text>
      <view class="base-info-item">
        <text>宣讲地址:</text>
        <text>{{careertalkInfo.address}}</text>
      </view>
      <view class="base-info-item">
        <text>主讲人:</text>
        <text>{{careertalkInfo.speaker}}</text>
      </view>
      <view class="base-info-item">
        <text>宣讲会主办方:</text>
        <text>{{careertalkInfo.organizer}}</text>
      </view>
      <view class="base-info-item">
        <text>开始时间:</text>
        <text>{{careertalkInfo.startTime}}</text>
      </view>
      <view class="base-info-item">
        <text>结束时间:</text>
        <text>{{careertalkInfo.endTime}}</text>
      </view>
    </view>
	</view>
</template>

<script>
  import {getCareertalkDetailInfo} from '../../api/careertalk.js'
	export default {
    onLoad(option) {
      this.getCareertalkDetailInfo(option.id);
    },
		data() {
			return {
				careertalkInfo:{}
			};
		},
    methods:{
      getCareertalkDetailInfo(id){
        getCareertalkDetailInfo({
          data:{
            id:id
          }
        }).then(res =>{
          console.log(res);
          this.careertalkInfo = res.data;
        })
      }
    }
	}
</script>

<style lang="scss">
  .title{
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-top: 2%;
    font-weight: bold;
    font-size: 6vw;
  }
  .base-info{
    margin: 2vw;
    padding: 2vw;
  }
  .base-info-item {
    font-size: 4vw;
    margin-top: 10px;
  }
</style>
