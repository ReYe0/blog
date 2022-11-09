<template>
<div>
    <BlogHeader/>
    <div style="opacity:0;margin-top:80px;"></div>
  <div class="container">
    <!-- 侧边栏 -->
    <div class="side-content">
      <!-- <AuthorCard /> -->
      <HotBlogCard/>
      <CategoryCard/>
      <TagCard/>
      <ArchiveCard/>
    </div>
    <!-- 发表的文章 -->
    <div class="post-blog-list">
      <BlogCard
        v-for="(blog, index) in postBlogs"
        :key="blog.id"
        :blog="blog"
        :reverse="index % 2 == 1"
      />
      <!-- 分页  background 设置 在里面 可以设置背景 -->
        <el-pagination
            layout="prev, pager, next"
            :total="blogCount"
            :page-size="pageSize"
            id="pagination"
            @current-change="onCurrentPageChanged"
            v-if="blogCount > 0"
        >
        </el-pagination>
    </div>
    
  </div>
    <!-- 页脚 -->
        <!-- <BlogFooter 
        :adminName="$store.state.adminAbout.adminInfo.nickName"/> -->
     <!-- 滚动到顶部按钮 -->
        <BackToTop />
  </div>
</template>
<script>
import BlogHeader from "@/components/BlogHeader.vue";
import ArchiveCard from '@/components/ArchiveCard'
import TagCard from '@/components/TagCard'
import CategoryCard from '@/components/CategoryCard.vue'
import HotBlogCard from "@/components/HotBlogCard.vue"
import AuthorCard from "@/components/AuthorCard.vue";
import BlogCard from "@/components/BlogCard";
import BackToTop from '@/components/BackToTop';
import { defaultThumbnail } from "../utils/thumbnail";
import { reactive, ref } from "vue";
import { getPostBlogList } from "../api/blog";
export default {
  name: "BlogHome",
  components: {
    BlogHeader,
    AuthorCard,
    BlogCard,
    BackToTop,
    HotBlogCard,
    CategoryCard,
    TagCard,
    ArchiveCard
  },
  setup() {
        let pageSize = 5;
        let postBlogs = reactive([]);
        let blogCount = ref(0);
            onCurrentPageChanged(1);
        function onCurrentPageChanged(pageNum) {
            getPostBlogList(pageNum, pageSize).then(res =>{
                blogCount.value = parseInt(res.data.data.total);
                 res.data.data.blogList.forEach((blog) => {
                    blog.createTime = blog.createTime.split("T")[0];
                    blog.thumbnail = blog.thumbnail || defaultThumbnail;
                });
                postBlogs.splice(0, postBlogs.length, ...res.data.data.blogList);
            })
        }

        return { postBlogs, blogCount, pageSize, onCurrentPageChanged };
  },
};
</script>
<style lang="less" scoped>
.container {
    padding: 40px 15px;
    padding-top: 0;
    max-width: 1300px;
    margin: 0 auto;
    display: flex;
    animation: fadeInUp 1s;
}

.post-blog-list {
    width: 74%;

    .post-blog-card {
        margin-top: 20px;
    }

    .post-blog-card:nth-child(1) {
        margin-top: 0;
    }
}

.side-content {
    width: 26%;
    margin-right: 20px;
}

:deep(#pagination) {
    margin-top: 20px;
    justify-content: center;

    & > button {
        box-shadow: var(--card-box-shadow);
        // background: white;
        border-radius: 8px;
        height: 35px;
        width: 35px;
    }

    li {
        box-shadow: var(--card-box-shadow);
        background-color: var(--el-pagination-bg-color);
        border-radius: 8px;
        margin: 0 6px;
        height: 35px;
        width: 35px;
    }

    li.active {
        color: white;
        background: var(--el-color-primary);
        font-weight: normal;
    }
}

@media screen and (max-width: 900px) {
    .side-content {
        display: none;
    }

    .post-blog-list {
        width: 100%;
    }
}

@keyframes fadeInUp {
    from {
        margin-top: 50px;
        opacity: 0;
    }

    to {
        margin-top: 0;
        opacity: 1;
    }
}
</style>
