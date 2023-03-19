<template>
  <view>
    <view class="cell">
      <text>公共咨询</text>
    </view>
    <view class="zixun">
      <uni-list v-for="(item,index) in questions" :key="index">
        <uni-list-item :title="item.title" :note="item.note" :thumb="item.thumb">

        </uni-list-item>
      </uni-list>
    </view>
    <view style="margin-top: 2%;">
      <view class="cell">
        <text>导师问答</text>
      </view>
      <u-grid :border="false" col="2" customStyle="margin-top:1%;">
        <u-grid-item v-for="(item,index) in teachers" :key="index" customStyle="margin-top:3%">
          <u-image :src="item.src" mode="aspectFit" radius="100"></u-image>
          <text style="font-size: 35rpx;">{{item.name}}</text>
          <text style="color: gray;font-size: 20rpx;">{{item.major}}</text>
        </u-grid-item>
      </u-grid>
    </view>
  </view>
</template>

<script>
  export default {
    data() {
      return {
        questions:[
          {
            title:"网申截止日期为何时？",
            note:"截止2023/3/31",
            thumb:"/static/images/grid/news.png"
          },
          {
            title:"网申截止日期为何时？",
            note:"截止2023/3/31",
            thumb:"/static/images/grid/news.png"
          },
        ],
        teachers: [{
            src: "/static/images/teacher/teacher1.jpg",
            name: "温慧敏",
            major: "化学工程学院"
          },
          {
            src: "/static/images/teacher/teacher2.jpg",
            name: "李小年",
            major: "化学工程学院"
          },
          {
            src: "/static/images/teacher/teacher3.jpg",
            name: "陈巧丽",
            major: "化学工程学院"
          },
          {
            src: "/static/images/teacher/teacher4.jpg",
            name: "艾青林",
            major: "机械工程学院"
          }
        ],
      }
    },
    methods: {

    }
  }
</script>

<style lang="scss">
  .cell {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    background-color: dodgerblue;
    font-size: 45rpx;
    margin: 2% 5%;
    border-radius: 5px 5px 15px 15px;
    color: whitesmoke;
    text-shadow: black 2px 2px 2px;
    padding: 2% 0;
    font-family: 'Courier New', Courier, monospace;
  }
  // .cell:hover{
  //   -webkit-transform: scale(1.5);
  //   -moz-transform: scale(1.5);
  //   -o-transform: scale(1.5);
  //   transform: scale(1.5);
  // }
</style>
