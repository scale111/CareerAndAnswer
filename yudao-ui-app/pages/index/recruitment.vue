<template>
  <view class="">
    <view v-for="(item,index) in info" :key="index">
      <uni-card :title="item.position" :extra="item.salary" shadow="0rpx 20rpx 20rpx 0rpx rgb(113, 163, 216)"
        :border="false" spacing="20rpx" padding="30rpx" margin="30rpx 20rpx">
        <view>
          本科及以上学历，熟练掌握Java编程语言，有较强的团队合作能力。
        </view>
        <view slot="actions" style="display: flex;">
          <view>
            {{item.company}}
          </view>
          <view style="margin-left:auto;">
            {{item.address}}
          </view>
          <view style="display: flex; flex-direction: row; align-items: center;margin-left: auto;" @click="actionsClick('收藏')">
            <uni-icons type="heart" size="18" color="#999"></uni-icons>
            <text>收藏</text>
          </view>
        </view>
      </uni-card>
    </view>
  </view>
</template>

<script>
  import {getrecruitment} from '../../api/recruitment'
  export default {
    data() {
      return {
        info: [{
          title: '2023年春季招聘会',
          time: '2023年4月1日 9:00-17:00',
          salary: "200-250元/天",
          address: '西湖区 西溪',
          company: '菜鸟网络',
          position: '软件工程师',
          text: '本科及以上学历，熟练掌握Java编程语言，有较强的团队合作能力。',
        }, {
          title: '2023年春季招聘会',
          time: '2023年4月1日 9:00-17:00',
          salary: "200-250元/天",
          address: '西湖区 西溪',
          company: '菜鸟网络',
          position: '软件工程师',
          text: '本科及以上学历，熟练掌握Java编程语言，有较强的团队合作能力。',
        }, ]
      }
    },
    onLoad() {
      this.getrecruitment();
    },
    methods: {
      apply() {
        // TODO: 跳转到申请职位页面或打开链接
      },
      getrecruitment(){
        getrecruitment({}).then(res =>{
          console.log("?????????")
          console.log(res);
          this.info=res.data;
        })
      }
    }
  }
</script>

<style lang="scss">

</style>
