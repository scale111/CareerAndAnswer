<template>
  <view class="">
    <view class="header">
      <view class="header-fitst">
        <view class="position">{{recruitmentInfo.position}}</view>
        <view class="salary">{{recruitmentInfo.salary}}</view>
      </view>
      <view class="header-second">
        <view class="header-second-item">
          <uni-icons custom-prefix="iconfont" type="icon-didian" ></uni-icons>
          <view class="header-second-item-text">{{recruitmentInfo.address}}</view>
        </view>
<!--        <view class="header-second-item">
          <uni-icons custom-prefix="iconfont" type="icon-renshutongji" ></uni-icons>
          <view class="header-second-item-text">{{recruitmentInfo.releaseTime}}</view>
        </view> -->
        <view class="header-second-item">
          <uni-icons custom-prefix="iconfont" type="icon-xueli" ></uni-icons>
          <view class="header-second-item-text" v-if="recruitmentInfo.education == 0">大专及以上学历</view>
          <view class="header-second-item-text" v-else-if="recruitmentInfo.education == 1">本科及以上学历</view>
          <view class="header-second-item-text" v-else-if="recruitmentInfo.education == 2">硕士及以上学历</view>
          <view class="header-second-item-text" v-else-if="recruitmentInfo.education == 3">博士及以上学历</view>
        </view>
      </view>
    </view>
    <view class="line">
      <u-line></u-line>
    </view>
    <view class="content">
      <view style="title"><text style="font-weight: bold;font-size: 4vw;">职位详情</text></view>
      <view class="content-text">
        <mp-html :content="recruitmentInfo.text"  :selectable="true"  />
      </view>
    </view>
  </view>
</template>

<script>
  import {getrecruitmentByid} from '../../api/recruitment.js'
  export default {
    data() {
      return {
        recruitmentInfo:[],
      };
    },
    onLoad(option) {
      console.log(option.id)
      this.loadRecruitmentInfo(option.id);
    },
    methods: {
      loadRecruitmentInfo(id){
        getrecruitmentByid({
          data:{
            id:id
          }
        }).then(res =>{
          this.recruitmentInfo=res.data;
          console.log(res.data);
        })
      },
      applyJob() {
        // 处理投递简历逻辑
      }
    }
  };
</script>

<style lang="scss">
  .header{
    margin: 3vw;
  }
  .header-fitst{
    display: flex;
    flex-direction: row;
  }
  .position{
    width: 45vw;
    font-weight: bold;
    font-size: 5vw;
  }
  .salary{
    margin-left: auto;
    color: lightseagreen;
  }
  .header-second{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    margin: 3vw;
  }
  .header-second-item{
    display: flex;
    flex-direction: row;
    align-items: center;
  }
  .header-second-item-text{
    font-size: 4vw;
    color: dimgray;
  }
  .line{
    margin: 0 3vw;
    display: flex;
    justify-content: center;
  }
  .content{
    margin: 2vw 3vw;
  }
  .content-text{
    margin-top: 5vw;
  }
</style>
