<template>
    <div id="bar">
        <el-menu :default-active="activeIndex" mode="horizontal" router>
            <el-menu-item index="0">BLOG</el-menu-item>
            <el-input placeholder="Type something" style="width:16%;height:80%;margin-top:5px;">
                <template #prefix>
                    <el-icon class="el-input__icon">
                        <search />
                    </el-icon>
                </template>
            </el-input>
            <div class="flex-grow" />
            <el-menu-item index="1">首页</el-menu-item>
            <el-sub-menu index="2">
                <template #title>Workspace</template>
                <el-menu-item index="2-1">item one</el-menu-item>
                <el-menu-item index="2-2">item two</el-menu-item>
                <el-menu-item index="2-3">item three</el-menu-item>
                <el-sub-menu index="2-4">
                    <template #title>item four</template>
                    <el-menu-item index="2-4-1">item one</el-menu-item>
                    <el-menu-item index="2-4-2">item two</el-menu-item>
                    <el-menu-item index="2-4-3">item three</el-menu-item>
                </el-sub-menu>
            </el-sub-menu>
            <el-menu-item index="/writeArticle">admin</el-menu-item>
        </el-menu>


    </div>
</template>
<script>
// import { ref } from 'vue'
// import { Search } from '@element-plus/icons-vue'

export default {
    name: "MyNavigation",
    compoent: {
        // Search
    },
    data() {
        // Search
    },
    methods() {

    }
}


</script>

<style >
.flex-grow {
    flex-grow: 0.8;
}

#bar {
    box-sizing: border-box;
    box-shadow: 0 2px 5px rgb(0 0 0 / 6%);
}

#bar>.el-menu {
    height: 50px;
    border-bottom-style: none;
    width: 100%;
    margin: 0;
    padding: 0;
}
</style>