<template>
    <div id="category-details">
        <!-- 页头 -->
        <BlogHeader />
<div style="opacity:0;margin-top:80px;"></div>
        <!-- 二次元封面 -->
        <!-- <kila-kila-wife-cover>
            <div class="category-info">
                <h1 class="category-name">{{ categoryName }}</h1>
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
            <div class="post-article-list">
                <BlogCard
                    v-for="(article, index) in postArticles"
                    :key="article.id"
                    :article="article"
                    :reverse="index % 2 == 1"
                />

                <!-- 分页 -->
                <el-pagination
                    layout="prev, pager, next"
                    :total="articleCount"
                    :page-size="pageSize"
                    id="pagination"
                    @current-change="onCurrentPageChanged"
                    v-if="articleCount > 0"
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
import BackToTop from '@/components/BackToTop'
import BlogCard from '@/components/BlogCard'
import AuthorCard from '@/components/AuthorCard';
import HotBlogCard from '@/components/HotBlogCard'
import CategoryCard from '@/components/CategoryCard'
import TagCard from '@/components/TagCard';
import ArchiveCard from '@/components/ArchiveCard'
import { computed, reactive, ref } from "vue";
import { getPostArticleList } from "../../api/article";
import { defaultThumbnail } from "../../utils/thumbnail";
import { mapState } from "../../store/map";

export default {
    name: "CategoryDetails",
    components:{
        BlogHeader,
        AuthorCard,
        HotBlogCard,
        CategoryCard,
        TagCard,
        ArchiveCard,
        BlogCard,
        BackToTop
    },
    setup(props) {
        let pageSize = 10;
        let postArticles = reactive([]);
        let articleCount = ref(0);
        let { categoryCounts } = mapState("categoryAbout");
        let categoryName = computed(() => {
            let map = Object.fromEntries(
                categoryCounts.value.map((i) => [i.id, i.name])
            );
            return map[props.id];
        });

        onCurrentPageChanged(1);

        function onCurrentPageChanged(pageNum) {
             getPostArticleList(pageNum, pageSize,props.id).then(res =>{
                articleCount.value = parseInt(res.data.data.total);
                 res.data.data.blogList.forEach((article) => {
                    article.createTime = article.createTime.split("T")[0];
                    article.thumbnail = article.thumbnail || defaultThumbnail;
                });
                postArticles.splice(0, postArticles.length, ...res.data.data.blogList);
            });
        }

        window.scrollTo({ top: 0 });

        return {
            categoryName,
            postArticles,
            articleCount,
            pageSize,
            onCurrentPageChanged,
        };
    },
    props: ["id", "name"],
};
</script>

<style lang="less" scoped>
#category-details {
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

    .category-info {
        text-align: center;
        position: absolute;
        width: 100%;
        text-shadow: 0 3px 6px rgba(0, 0, 0, 0.3);

        .category-name {
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

.post-article-list {
    width: 74%;

    .post-article-card {
        margin-top: 20px;
    }

    .post-article-card:nth-child(1) {
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

    .post-article-list {
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