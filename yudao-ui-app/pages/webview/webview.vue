<template>
  <web-view :src="weburl"></web-view>
</template>

<script>
export default {
  data() {
    return {
      weburl: ''
    }
  },
  onLoad(item) {
    // 传入需要跳转的链接 使用web-view标签进行跳转
    this.weburl = decodeURIComponent(item.url)
    console.log(this.weburl)
  }
}
</script>

<style>

</style>
