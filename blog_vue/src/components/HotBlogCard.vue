<template>
    <BaseCard
        :icon="['fas', 'fire']"
        iconColor="#f01111"
        title="热门文章"
    >
        <div
            v-for="blog in hotBlogs"
            :key="blog.id"
            class="hot-blog-item"
        >
            <router-link
                :to="`/blog/${blog.id}`"
                class="hot-blog-thumbail-link"
                ><img
                    :src="blog.thumbnail"
                    @error.once="useDefaultThumbnail"
                    alt="缩略图"
                    class="hot-blog-thumbnail"
                />
            </router-link>

            <div class="hot-blog-info">
                <router-link
                    :to="`/blog/${blog.id}`"
                    class="hot-blog-title"
                    >{{ blog.title }}
                </router-link>
                <div class="hot-blog-meta-data">
                    {{ blog.createTime }}
                    <span>{{ blog.viewCount }}次围观</span>
                </div>
            </div>
        </div>
    </BaseCard>
</template>

<script>
import BaseCard from '@/components/BaseCard'
import { getHotBlogList } from "../api/blog";
import { reactive } from "@vue/reactivity";
import { defaultThumbnail, useDefaultThumbnail } from "../utils/thumbnail";

export default {
    name: "HotBlogCard",
    setup() {
        let hotBlogs = reactive([]);

        getHotBlogList().then((res) => {
            res.data.data.forEach((blog) => {
                blog.createTime = blog.createTime.split("T")[0];
                blog.thumbnail = blog.thumbnail || defaultThumbnail;
            });

            hotBlogs.push(...res.data.data);
        });

        return { hotBlogs, useDefaultThumbnail };
    },
    components:{
        BaseCard
    }
};
</script>

<style scoped>
.hot-blog-item {
    display: flex;
    justify-content: center;
    align-content: center;
    padding: 8px 0;
}

.hot-blog-thumbail-link {
    height: 58px;
    width: 58px;
    overflow: hidden;
}

.hot-blog-thumbnail {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: all 0.4s ease;
}

.hot-blog-thumbnail:hover {
    transform: scale(1.1);
}

.hot-blog-info {
    flex: 1;
    padding-left: 10px;
    word-break: break-all;
    display: inline-block;
    align-self: center;
}

.hot-blog-title {
    color: var(--text-color);
    font-size: 13.5px;
    text-decoration: none;
    transition: color 0.4s;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    line-height: 1.5;
    -webkit-line-clamp: 2;
}

.hot-blog-title:hover {
    color: var(--el-color-primary);
}

.hot-blog-meta-data {
    font-size: 12px;
    color: rgb(133, 133, 133);
    box-sizing: border-box;
    line-height: 24px;
    overflow: hidden;
    -webkit-line-clamp: 1;
    display: -webkit-box;
    -webkit-box-orient: vertical;
}

.hot-blog-meta-data span {
    margin-left: 4%;
}
</style>