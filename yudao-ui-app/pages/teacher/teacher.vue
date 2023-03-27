<template>
  <view>
    <view class="cell">
      <text>公共咨询</text>
    </view>
    <view class="zixun">
      <uni-list>
        <uni-list-chat title="uni-app" avatar="https://web-assets.dcloud.net.cn/unidoc/zh/unicloudlogo.png"
          note="您收到一条新的消息" time="2020-02-02 20:20" badge-positon="left" badge-text="dot"></uni-list-chat>
      </uni-list>
    </view>
    <view style="margin-top: 2%;">
      <view class="cell">
        <text>导师问答</text>
      </view>
      <u-grid :border="false" customStyle="padding:2%">
        <u-grid-item v-for="(item,index) in teachers" :key="index" customStyle="width:50%">
          <u-image :src="item.photo" mode="aspectFit" radius="1" height="30vh"></u-image> <text
            style="font-size: 5vw;text-align: center;">{{item.name}}</text> <text
            style="color: gray;font-size: 4vw;text-align: center;">{{item.college}}</text>
        </u-grid-item>
        <!-- <u-grid-item v-for="(item,index) in teachers" :key="index" customStyle="margin-top:3%">
          <u-image :src="item.src" mode="aspectFit" radius="100"></u-image>
          <text style="font-size: 35rpx;">{{item.name}}</text>
          <text style="color: gray;font-size: 20rpx;">{{item.major}}</text>
        </u-grid-item> -->
      </u-grid>
    </view>
  </view>
</template>

<script>
  import {
    getTeacherInfo
  } from '../../api/teacher.js'
  
  export default {
    data() {
      return {
        questions: [{
            title: "网申截止日期为何时？",
            note: "截止2023/3/31",
            thumb: "/static/images/grid/news.png"
          },
          {
            title: "网申截止日期为何时？",
            note: "截止2023/3/31",
            thumb: "/static/images/grid/news.png"
          },
        ],
        teachers: [{
            photo: "/static/images/teacher/teacher1.jpg",
            name: "温慧敏",
            major: "化学工程学院"
          },
          {
            photo: "/static/images/teacher/teacher2.jpg",
            name: "郑建炜",
            major: "计算机科学与技术学院、软件学院"
          },
          {
            photo: "/static/images/teacher/teacher3.jpg",
            name: "陈巧丽",
            major: "化学工程学院"
          },
          {
            photo: "/static/images/teacher/teacher4.jpg",
            name: "艾青林",
            major: "机械工程学院"
          }
        ],
      }
    },
    methods: {
      //获取导师信息
      loadTeacherData() {
        getTeacherInfo().then(res => {
          this.teachers = res.data
          console.log('teacher:')
          console.log(res)
        })
      },
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
