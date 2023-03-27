<template>
  <view class="container">
    <!--搜索栏-->
    <!--    <u-sticky style="top: 0" offset-top="0">
      <view class="search-wrap">
        <u-search placeholder="搜索" disabled height="32" :show-action="false" @click="handleSearchClick"></u-search>
      </view>
    </u-sticky> -->
    <u-gap height="20px"></u-gap>

    <!--广告-->
    <view style="margin: 2%;">
      <u-swiper :list="bannerList" indicator indicatorMode="line" circular></u-swiper>
    </view>
    <!-- <yd-banner :banner-list="bannerList"></yd-banner> -->
    <u-gap height="20px"></u-gap>
    <!--宫格菜单按钮-->
    <u-scroll-list :indicator="indicator">
      <u-grid :border="false" col="4">
        <u-grid-item v-for="(item, index) in menuList1" :key="index" @click="navigator()" :name="item.link">
          <u-icon :name="item.icon" :size="30"></u-icon>
          <text class="grid-title">{{ item.title }}</text>
        </u-grid-item>
      </u-grid>
      <u-grid :border="false" col="4">
        <u-grid-item v-for="(item, index) in menuList2" :key="index">
          <u-icon :name="item.icon" :size="30"></u-icon>
          <text class="grid-title">{{ item.title }}</text>
        </u-grid-item>
      </u-grid>
      <u-grid :border="false" col="4">
        <u-grid-item v-for="(item, index) in menuList3" :key="index">
          <u-icon :name="item.icon" :size="30"></u-icon>
          <text class="grid-title">{{ item.title }}</text>
        </u-grid-item>
      </u-grid>
    </u-scroll-list>

    <u-gap height="15px"></u-gap>

    <!--导师面对面-->
    <view>
      <u-cell-group customStyle="padding:2%;">
        <u-cell title="导师面对面" value="查看更多" isLink url="/pages/teacher/teacher"></u-cell>
      </u-cell-group>
      <u-grid :border="false" customStyle="padding:2%">
        <u-grid-item v-for="(item,index) in teachers" :key="index" customStyle="width:50%">
          <u-image @click="navigatorTeacher(item.id)" :src="item.photo" mode="aspectFit" radius="1" height="30vh"></u-image> <text
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
    <view>
      <u-cell-group customStyle="padding:1%;">
        <u-cell title="求职交流社区" value="查看更多" isLink url=""></u-cell>
      </u-cell-group>
      <uni-list type="line" :border="false">
        <uni-list-item :border="false" ellipsis="1" title="超长文字显示一行,以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字"
          rightText="2023/3/9" />
        <uni-list-item :border="false" ellipsis="1" title="超长文字显示一行,以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字"
          rightText="2023/3/9" />
        <uni-list-item :border="false" ellipsis="1" title="超长文字显示一行,以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字以下是测试文字"
          rightText="2023/3/9" />
      </uni-list>
    </view>

  </view>
</template>

<script>
  import {
    getBannerData,
    getNoticeData
  } from '../../api/index'
  import {
    getTeacherInfo
  } from '../../api/teacher.js'
  export default {
    components: {},
    data() {
      return {
        indicator: false,
        bannerList: [{
            id: 1,
            title: '山不在高，有仙则名',
            url: 'https://cdn.uviewui.com/uview/swiper/swiper1.png'
          },
          {
            id: 2,
            title: '水不在深，有龙则灵',
            url: 'https://cdn.uviewui.com/uview/swiper/swiper2.png'
          },
          {
            id: 3,
            title: '斯是陋室，惟吾德馨',
            url: 'https://cdn.uviewui.com/uview/swiper/swiper3.png'
          },
          {
            id: 4,
            title: '神里绫华',
            url: '/static/images/banner/banner1.png'
          }
        ],
        menuList1: [{
            icon: '/static/images/grid/School_Employment_Network.png',
            title: '校就业网',
            link: 'https://zjut.jysd.com/'
          },
          {
            icon: '/static/images/grid/recruitment.png',
            title: '招聘公告',
            link: '/pages/index/recruitment'
          },
          {
            icon: '/static/images/grid/job_search.png',
            title: '职位搜索'
          },
          {
            icon: '/static/images/grid/lecture.png',
            title: '宣讲会',
            link: '/pages/index/careertalk'
          }
        ],
        menuList2: [{
            icon: '/static/images/grid/Job_skills.png',
            title: '求职技巧'
          },
          {
            icon: '/static/images/grid/process.png',
            title: '办事流程'
          },
          {
            icon: '/static/images/grid/Make_an_appointment.png',
            title: '活动预约'
          },
          {
            icon: '/static/images/grid/Recruitment_announcement.png',
            title: '通知公告'
          }
        ],
        menuList3: [{
            icon: '/static/images/grid/publicize.png',
            title: '公示专栏'
          },
          {
            icon: '/static/images/grid/news.png',
            title: '新闻快递'
          }
        ],
        noticeList: ['寒雨连江夜入吴', '平明送客楚山孤', '洛阳亲友如相问', '一片冰心在玉壶'],
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
        moreStatus: 'nomore'
      }
    },
    onLoad() {
      // this.loadBannerData()
      // this.loadNoticeData()
      this.loadTeacherData()
    },
    methods: {
      //监听宫格点击回调参数
      navigator(name) {
        if (name.charAt(0) == '/') {
          uni.navigateTo({
            url: name
          })
        } else {
          uni.navigateTo({
            url: '/pages/webview/webview?url=' + name
          })
        }
      },
      //获取导师信息
      loadTeacherData() {
        getTeacherInfo().then(res => {
          this.teachers = res.data
        })
      },
      //进入到导师详情页面
      navigatorTeacher(id){
        uni.navigateTo({
          url:'/pages/teacher/teacherDetail?id=' + id
        })
      },
      loadBannerData() {
        getBannerData().then(res => {
          this.bannerList = res.data
        })
      },
      loadNoticeData() {
        getNoticeData().then(res => {
          this.noticeList = res.data
        })
      },
      handleSearchClick(e) {
        uni.$u.route('/pages/search/search')
      }
    },
    computed: {
      noticeTextList() {
        return this.noticeList.map(item => {
          if (item.title) {
            return item.title
          }
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .search-wrap {
    background: $custom-bg-color;
    padding: 20rpx;
  }

  .grid-title {
    line-height: 50rpx;
    font-size: 26rpx;
  }

  .swiper {
    height: 150rpx;
  }
</style>
