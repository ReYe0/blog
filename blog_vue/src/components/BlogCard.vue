<template>
  <div :class="cardClass">
    <!-- 缩略图 -->
    <router-link :to="`/blog/${blog.id}`" :class="thumbailLinkClass"
      ><img
        :src="blog.thumbnail"
        @error.once="useDefaultThumbnail"
        alt="缩略图"
        class="post-blog-thumbnail"
      />
    </router-link>
    <!-- 文章信息 -->
    <div class="post-blog-info">
      
      <!-- 文章标题 -->
      <router-link :to="`/blog/${blog.id}`" class="post-blog-title"
        ><span style="color:#00BFFF;font-size:18px;" v-show="blog.isTop"><el-icon><Flag /></el-icon></span>{{ blog.title }}
      </router-link>

      <!-- 其他元数据 -->
      <div class="post-blog-meta-data-wrap">
        <span class="post-blog-meta-data">
          <el-icon><Calendar /></el-icon>
          发表于 {{ blog.createTime }}
        </span>
        <span class="post-blog-meta-data-divider">|</span>
        <span class="post-blog-meta-data">
          <el-icon><Folder /></el-icon>
          分类 {{ blog.categoryName }}
        </span>
        <span class="post-blog-meta-data-divider">|</span>
        <span class="post-blog-meta-data">
          <el-icon><View /></el-icon>
          阅读量 {{ blog.viewCount }}
        </span>
      </div>

      <!-- 文章摘要 -->
      <div class="post-blog-summary">
        {{ blog.summary }}
      </div>
    </div>
  </div>
</template>

<script>
import { reactive } from "vue";
import { useDefaultThumbnail } from "../utils/thumbnail";

export default {
  name: "BlogCard",
  props: {
    blog: {
      typing: Object,
      require: true,
    },
    reverse: {
      type: Boolean,
      require: false,
    },
  },
  setup(props) {
    let cardClass = reactive(["post-blog-card"]);
    let thumbailLinkClass = reactive(["post-blog-thumbail-link"]);

    if (props.reverse) {
      cardClass.push("post-blog-card-reversed");
      thumbailLinkClass.push("post-blog-thumbail-link-reversed");
    }

    return { cardClass, thumbailLinkClass, useDefaultThumbnail };
  },
};
</script>

<style scoped>
.post-blog-card {
  height: 252px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
    /* background-color: var(--el-bg-color); */
  /* background: white; */
  border-radius: 8px;
  /* border-color: var(--el-menu-border-color); */
  /* border: 1px outset  var(--el-menu-border-color); */
  box-shadow: var(--card-box-shadow);
}

.post-blog-card-reversed {
  flex-direction: row-reverse;
}

.post-blog-thumbail-link {
  width: 44%;
  height: 100%;
  overflow: hidden;
  box-sizing: border-box;
  border-radius: 8px 0 0 8px;
}

.post-blog-thumbail-link-reversed {
  border-radius: 0 8px 8px 0;
}

.post-blog-thumbnail {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: all 0.4s ease;
  box-sizing: border-box;
  overflow: hidden;
}

.post-blog-thumbnail:hover {
  transform: scale(1.1);
}

.post-blog-info {
  width: 57%;
  padding: 0 40px;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  line-height: 2;
  -webkit-line-clamp: 2;
}

.post-blog-title {
  /* color: #1f2d3d; */
  color: var(--el-menu-text-color);
  font-size: 24px;
  text-decoration: none;
  transition: color 0.4s;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  line-height: 1.5;
  -webkit-line-clamp: 2;
}

.post-blog-title:hover {
  color: var(--theme-color);
}

.post-blog-meta-data-wrap {
  display: flex;
  margin: 9px 0;
}

.post-blog-meta-data {
  font-size: 12px;
  color: rgb(133, 133, 133);
  box-sizing: border-box;
  line-height: 24px;
  overflow: hidden;
  -webkit-line-clamp: 1;
  display: -webkit-box;
  -webkit-box-orient: vertical;
}

.post-blog-meta-data-divider {
  color: rgb(133, 133, 133);
  margin: 3px 8px;
  font-size: 12px;
}

.post-blog-summary {
  color: var(--text-color);
  font-size: 14px;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  line-height: 2;
  -webkit-line-clamp: 2;
}

@media screen and (max-width: 650px) {
  .post-blog-card {
    flex-direction: column;
    height: auto !important;
  }
  .post-blog-thumbail-link {
    border-radius: 8px 8px 0px 0px;
    width: 100%;
    height: 25vh;
    /* height: 50% !important; */
  }
  .post-blog-info {
    padding: 0 !important;
    width: 100% !important;
    height: 50% !important;
    box-sizing: border-box;
  }
  .post-blog-title {
    padding: 20px;
    padding-bottom: 0;
    font-size: 20px !important;
  }
  .post-blog-summary {
    padding: 0 20px;
    padding-top: 5px;
    font-size: 13.5px !important;
    overflow: hidden !important;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    line-height: 2;
    -webkit-line-clamp: 2;
    margin-bottom: 20px;
  }
  .post-blog-meta-data-wrap {
    padding-left: 20px;
  }
}
</style>
