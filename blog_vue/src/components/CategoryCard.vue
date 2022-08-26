<template>
    <BaseCard :icon="['fas', 'folder']" iconColor="#fcd53f" title="分类">
        <div class="category-list">
            <router-link
                v-for="category in categoryCounts"
                :key="category.id"
                :to="`/category/${category.id}`"
                class="category-item"
            >
                <span class="category-name">{{ category.name }}</span>
                <span class="category-count">{{ category.count }}</span>
            </router-link>
        </div>
    </BaseCard>
</template>

<script>
import BaseCard from '@/components/BaseCard'
import { mapState } from "../store/map";
export default {
    name: "CategoryCard",
    setup() {
        let { categoryCounts } = mapState("categoryAbout");
        return { categoryCounts };
    },
    components:{
        BaseCard
    }
};
</script>

<style scoped>
.category-item {
    display: flex;
    justify-content: space-between;
    text-decoration: none;
    padding: 10px 10px;
    color: var(--text-color);
    font-size: 14px;
    transition: all 0.4s;
    border-radius: 4px;
}

.category-item:hover {
    background-color: var(--el-color-primary);
    color: white;
    padding: 10px 17px;
}

.category-name {
    flex: 1;
    overflow: hidden;
    text-overflow: ellipsis;
}
</style>