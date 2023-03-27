<template>
  <view>
    <view>
      <uni-list v-for="(item,index) in careertalkData" :key="index">
        <uni-list-item clickable="true" @click="navigator(item.id)" ellipsis="2" :title="item.title" :note="item.address" :rightText="item.createTime">
        </uni-list-item>
      </uni-list>
    </view>
  </view>
</template>

<script>
  import {
    getCareertalkInfo
  } from '../../api/careertalk.js'
  export default {
    onLoad() {
      this.getCareertalkInfo();
    },
    data() {
      return {
        careertalkData: [{
            title: "浙江工业大学宣讲会",
            name: "宣讲会",
            address: "厚礼楼519",
            createTime: "2023-03-16"
          },
          {
            title: "浙江工业大学宣讲会",
            name: "宣讲会",
            address: "厚礼楼519",
            createTime: "2023-03-16"
          },
          {
            title: "浙江工业大学宣讲会",
            name: "宣讲会",
            address: "厚礼楼519",
            createTime: "2023-03-16"
          }
        ]
      }
    },
    methods: {
      //获取宣讲会列表
      getCareertalkInfo() {
        getCareertalkInfo({}).then(res => {
          console.log(res)
          this.careertalkData = res.data;
        })
      },
      navigator(id) {
        console.log(id)
        uni.navigateTo({
          url: 'careertalkDetail?id=' + id
        })
      }
    }
  }
</script>

<style lang="scss">

</style>
