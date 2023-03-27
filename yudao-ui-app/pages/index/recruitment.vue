<template>
  <view class="">
<!--    <view v-for="(item,index) in info" :key="index">
      <uni-card :title="item.position" :extra="item.salary"
        shadow="0 8px 12px rgba(113, 163, 216, 0.5), 0 16px 24px rgba(113, 163, 216, 0.5)" :border="false"
        spacing="20rpx" padding="30rpx" margin="30rpx 20rpx">
        <view @click="Navigator(item.id)">
          本科及以上学历，熟练掌握Java编程语言，有较强的团队合作能力。
        </view>
        <view slot="actions" class="actions-container">
          <view class="company-name">{{ item.company }}</view>
          <view class="like-container" @click="toggleLike">
            <div class="like-icon" :class="{ active: isLiked }"></div>
            <div class="like-text">{{ isLiked ? '已收藏' : '收藏' }}</div>
          </view>
          <view class="company-address">{{ item.address }}</view>
        </view>
      </uni-card>
    </view> -->

    <view v-for="(item,index) in info" :key="index">
      <uni-card shadow="0 8px 12px rgba(113, 163, 216, 0.5), 0 16px 24px rgba(113, 163, 216, 0.5)" :border="false"
        spacing="20rpx" padding="30rpx" margin="30rpx 20rpx">
        <view slot="title" class="title">
          <view class="title-left">
            <view class="title-left-position">{{item.position}}</view>
          </view>
          <view class="title-right">
            {{item.salary}}
          </view>
        </view>
        <view @click="Navigator(item.id)">
          本科及以上学历，熟练掌握Java编程语言，有较强的团队合作能力。
        </view>
        <view slot="actions" class="actions-container">
          <view class="company-name">{{ item.company }}</view>
          <view class="like-container" @click="toggleLike">
            <div class="like-icon" :class="{ active: isLiked }"></div>
            <div class="like-text">{{ isLiked ? '已收藏' : '收藏' }}</div>
          </view>
          <view class="company-address">{{ item.address }}</view>
        </view>
      </uni-card>
    </view>
  </view>
</template>

<script>
  import {
    getrecruitment
  } from '../../api/recruitment'
  export default {
    data() {
      return {
        isLiked: false,
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
      toggleLike() {
        this.isLiked = !this.isLiked;
      },
      apply() {
        // TODO: 跳转到申请职位页面或打开链接
      },
      getrecruitment() {
        getrecruitment({}).then(res => {
          console.log(res);
          this.info = res.data;
        })
      },
      actionsClick(e) {},
      Navigator(id) {
        uni.navigateTo({
          url: 'recruitmentDetail?id=' + id
        })
      }
    }
  }
</script>

<style lang="scss">
  .actions-container {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 2.5vw;
  }

  .company-name {
    font-size: 4vw;
    width: 30vw;
  }

  .company-address {
    font-size: 4vw;
    color: #888;
  }

  .like-container {
    display: flex;
    align-items: center;
  }

  /* 定义红心的样式 */
  .like-icon {
    width: 7vw;
    height: 7vw;
    background-image: url('/static/images/empty/heart.png');
    background-size: cover;
    filter: grayscale(100%);
  }

  /* 定义红心激活状态的样式 */
  .like-icon.active {
    animation: pulse 0.5s ease-out both;
    filter: none;
  }

  /* 定义红心闪烁的动画 */
  @keyframes pulse {
    0% {
      transform: scale(1);
    }

    50% {
      transform: scale(1.2);
    }

    100% {
      transform: scale(1);
    }
  }

  .class-header-left {
    width: 70vw;
  }

  .title {
    display: flex;
    flex-direction: row;
    justify-content: center;
  }

  .title-right {
    margin-left: auto;
    color: lightseagreen;
    font-size: 4vw;
  }

  .title-left-position {
    font-weight: bold;
    font-size: 4vw;
  }
</style>
