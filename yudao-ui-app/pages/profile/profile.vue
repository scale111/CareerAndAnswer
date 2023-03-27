<template>
  <view class="container">
    <view class="user-info">
      <view class="info-item">
        <view class="label">头像：</view>
        <view class="info" @click="handleAvatarClick">
          <u-avatar size="50" shape="square" :src="userInfo.avatar"></u-avatar>
          <u-icon class="btn" name="arrow-right"></u-icon>
        </view>
      </view>
      <view class="info-item">
        <view class="label">昵称：</view>
        <view class="info">
          <u--input maxlength="10" border="none" v-model="userInfo.nickname" inputAlign="right"
            @change="handleNameChange"></u--input>
        </view>
      </view>
      <view class="info-item">
        <view class="label">手机：</view>
        <view class="info">
          <u--input maxlength="11" border="none" v-model="userInfo.mobile" inputAlign="right"
            @change="handleMobileChange"></u--input>
          <!-- <view class="value">{{ userInfo.mobile }}</view> -->
        </view>
      </view>
      <view class="info-item">
        <view class="label">就业状态：</view>
        <view class="info">
          <picker class="select" mode="selector" :range="statusList" @change="onStatusChange">
            <text>{{ statusList[selectedStatusIndex] }}</text>
          </picker>
        </view>
      </view>
      <view class="info-item">
        <view class="label">性别：</view>
        <view class="info">
          <picker class="select" mode="selector" :range="genderList" @change="onGenderChange">
            <text>{{ genderList[selectedGenderIndex] }}</text>
          </picker>
        </view>
      </view>
      <view class="info-item">
        <view class="label">学校：</view>
        <view class="info">
          <picker class="select" mode="selector" :range="statusList" @change="onStatusChange">
            <text>{{ statusList[selectedStatusIndex] }}</text>
          </picker>
        </view>
      </view>
      <view class="info-item">
        <view class="label">学院：</view>
        <view class="info">
          <picker class="select" mode="selector" :range="statusList" @change="onStatusChange">
            <text>{{ statusList[selectedStatusIndex] }}</text>
          </picker>
        </view>
      </view>
      <view class="info-item">
        <view class="label">专业：</view>
        <view class="info">
          <picker class="select" mode="selector" :range="statusList" @change="onStatusChange">
            <text>{{ statusList[selectedStatusIndex] }}</text>
          </picker>
        </view>
      </view>
    </view>

    <view v-if="nameUpdateVisible" class="btn-group">
      <u-button type="primary" text="保存" customStyle="margin-top: 50px" @click="handleSaveBtnClick"></u-button>
    </view>

  </view>
</template>

<script>
  import {
    getUserInfo,
    updateAvatar,
    updateNickname
  } from '../../api/user'

  export default {
    data() {
      return {
        genderList: ['男', '女', '保密'],
        selectedGenderIndex: 0,
        statusList: ['已就业', '未就业'],
        selectedStatusIndex: 0,
        userInfo: {
          nickname: '',
          avatar: '',
          mobile: ''
        },
        avatarFiles: [],
        tempName: ''
      }
    },
    computed: {
      nameUpdateVisible: function() {
        return this.userInfo.nickname !== this.tempName
      }
    },
    onLoad() {
      this.loadUserInfoData()
    },
    methods: {
      onGenderChange(e) {
        this.selectedGenderIndex = e.detail.value;
        console.log('当前选择的性别是：', this.genderList[this.selectedGenderIndex]);
      },
      onStatusChange(e) {
        this.selectedStatusIndex = e.detail.value;
        console.log('当前选择的就业状态是：', this.statusList[this.selectedStatusIndex]);
      },
      loadUserInfoData() {
        getUserInfo().then(res => {
          this.userInfo = res.data
          this.tempName = this.userInfo.nickname
        })
      },
      handleAvatarClick() {
        uni.chooseImage({
          success: chooseImageRes => {
            const tempFilePaths = chooseImageRes.tempFilePaths
            updateAvatar(tempFilePaths[0]).then(res => {
              this.userInfo.avatar = res.data
              this.$store.commit('SET_USER_INFO', this.userInfo)
            })
          }
        })
      },
      handleNameChange(val) {
        let str = uni.$u.trim(val, 'all')
        this.$nextTick(() => {
          this.userInfo.nickname = str
        })
      },
      handleMobileChange(val) {
        let str = uni.$u.trim(val, 'all')
        console.log(str)
        this.$nextTick(() => {
          this.userInfo.mobile = str
        })
      },
      handleSaveBtnClick() {
        updateNickname({
          nickname: this.userInfo.nickname
        }).then(res => {
          this.tempName = this.userInfo.nickname
          this.$store.commit('SET_USER_INFO', this.userInfo)
          uni.$u.toast('已保存')
          setTimeout(() => {
            uni.switchTab({
              url: '/pages/user/user'
            })
          }, 300)
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .user-info {
    .info-item {
      padding: 20rpx 60rpx;
      border-bottom: $custom-border-style;
      @include flex-space-between;

      .label {
        font-size: 30rpx;
      }

      .info {
        @include flex-left;

        .value {
          font-size: 30rpx;
        }

        .btn {
          margin-left: 30rpx;
        }
      }

      .name-edit {
        @include flex-left;

        .edit-btn-group {
          @include flex;

          .edit-btn {
            margin-left: 20rpx;
          }
        }
      }
    }
  }

  .btn-group {
    padding: 0 30rpx;
  }
</style>
