<template>
  <div class="community">
    <!-- 顶部导航栏 -->
    <div class="nav-bar">
      <div class="left-icon">
        <img src="https://img.icons8.com/ios/50/000000/menu--v1.png"/>
      </div>
      <div class="title">社区论坛</div>
      <div class="right-icon">
        <img src="https://img.icons8.com/fluent-systems-filled/48/000000/search.png"/>
      </div>
    </div>
    <!-- 话题列表 -->
    <div class="topics">
      <div class="topic" v-for="(item, index) in topicList" :key="index">
        <div class="avatar">
          <img :src="item.avatar" alt="Avatar">
        </div>
        <div class="info">
          <div class="title">{{ item.title }}</div>
          <div class="description">{{ item.description }}</div>
          <div class="meta">
            <span class="author">{{ item.author }}</span>
            <span class="time">{{ item.time }}</span>
            <span class="comment">{{ item.commentCount }} 评论</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Community',
  data() {
    return {
      topicList: [
        {
          id: 1,
          title: '如何提高英语口语水平？',
          description: '英语口语对于我们来说非常重要，但是很多人却发现自己的英语口语水平始终无法提高。',
          avatar: 'https://picsum.photos/id/237/50/50',
          author: '小明',
          time: '1天前',
          commentCount: 10
        },
        {
          id: 2,
          title: '如何学习编程？',
          description: '编程是一项非常有用的技能，但是对于初学者来说，学习编程可能会遇到许多困难。',
          avatar: 'https://picsum.photos/id/238/50/50',
          author: '小红',
          time: '2天前',
          commentCount: 5
        },
        {
          id: 3,
          title: '如何学好高等数学？',
          description: '高等数学是许多学科的基础，但是许多人都觉得自己不擅长数学。',
          avatar: 'https://picsum.photos/id/239/50/50',
          author: '小刚',
          time: '3天前',
          commentCount: 7
        }
      ]
    };
  }
};
</script>

<style scoped>
.community {
  display: flex;
  flex-direction: column;
  height: 100%;
  font-family: Arial, sans-serif;
}

.nav-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 15px;
  background-color: #fff;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
}

.left-icon img,
.right-icon img {
  width: 24px;
  height: 24px;
}

.title {
  font-size: 18px;
  font-weight: bold;
}

.topics {
  padding: 20px;
}

.topic {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.avatar {
  width: 50px;
  height: 50px;
  margin-right: 15px;
  border-radius: 50%;
  overflow: hidden;
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.info {
  flex: 1;
}

.title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
}

.description {
  font-size: 14px;
  margin-bottom: 5px;
}

.meta {
  display: flex;
  font-size: 14px;
  color: #999;
}

.meta span {
  margin-right: 10px;
}

.comment {
  margin-left: auto;
}
</style>