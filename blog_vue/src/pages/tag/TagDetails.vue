<template>
    <div id="tag-details">
        <!-- 页头 -->
        <BlogHeader />
<div style="opacity:0;margin-top:80px;"></div>
        <!-- 二次元封面 -->
        <!-- <kila-kila-wife-cover>
            <div class="tag-info">
                <h1 class="tag-name">{{ tagName }}</h1>
            </div>
        </kila-kila-wife-cover> -->

        <div class="container">
            <!-- 侧边栏 -->
            <div class="side-content">
                <AuthorCard />
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

                <!-- 分页 -->
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


        <!-- 回到顶部 -->
        <BackToTop />
    </div>
</template>

<script>
import BlogHeader from "@/components/BlogHeader.vue";
import BlogCard from '@/components/BlogCard'
import BackToTop from '@/components/BackToTop'
import AuthorCard from '@/components/AuthorCard';
import HotBlogCard from '@/components/HotBlogCard'
import CategoryCard from '@/components/CategoryCard'
import TagCard from '@/components/TagCard';
import ArchiveCard from '@/components/ArchiveCard'
import { computed, reactive, ref } from "vue";
import { getPostBlogList } from "../../api/blog";
import { defaultThumbnail } from "../../utils/thumbnail";
import { mapState } from "../../store/map";

export default {
    name: "TagDetails",
     components:{
        BlogHeader,
        AuthorCard,
        HotBlogCard,
        CategoryCard,
        TagCard,
        ArchiveCard,
        BackToTop,
        BlogCard
    },
    setup(props) {
        let pageSize = 10;
        let postBlogs = reactive([]);
        let blogCount = ref(0);
        let { tagCounts } = mapState("tagAbout");
        let tagName = computed(() => {
            let map = Object.fromEntries(
                tagCounts.value.map((i) => [i.id, i.name])
            );
            return map[props.id];
        });

        onCurrentPageChanged(1);

        function onCurrentPageChanged(pageNum) {
            getPostBlogList(pageNum, pageSize, null, props.id).then(
                (res) => {
                    blogCount.value = parseInt(res.data.data.total);
                    res.data.data.blogList.forEach((blog) => {
                    blog.createTime = blog.createTime.split("T")[0];
                    blog.thumbnail = blog.thumbnail || defaultThumbnail;
                });
                postBlogs.splice(0, postBlogs.length, ...res.data.data.blogList);
                }
            );
        }

        window.scrollTo({ top: 0 });

        return {
            tagName,
            postBlogs,
            blogCount,
            pageSize,
            onCurrentPageChanged,
        };
    },
    props: ["id", "name"],
};
</script>

<style lang="less" scoped>
#tag-details {
    height: 100%;
    width: 100%;
}

.container {
    padding: 40px 15px;
    max-width: 1300px;
    margin: 0 auto;
    display: flex;
    animation: fadeInUp 1s;
}

.wife-cover {
    display: flex;
    align-items: center;
    justify-content: center;

    .tag-info {
        text-align: center;
        position: absolute;
        width: 100%;
        text-shadow: 0 3px 6px rgba(0, 0, 0, 0.3);

        .tag-name {
            font-size: 40px;
            color: white;
            line-height: 1.5;
            margin-bottom: 15px;
            padding: 0 30px;
            overflow: hidden;
            display: -webkit-box;
            text-overflow: ellipsis;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
        }
    }
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
        background: var(--theme-color);
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