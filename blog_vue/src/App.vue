<template>
  <div id="app">
    <BlogHeader />
    <div style="opacity:0;margin-top:80px;"></div>
    <router-view :key="$route.fullPath"></router-view>
    <BlogFooter :adminName="$store.state.adminAbout.adminInfo.nickName"/>
  </div>
</template>

<script>
import BlogHeader from "@/components/BlogHeader.vue";
import BlogFooter from '@/components/BlogFooter'
import store from "./store";
import bus from "./utils/bus";
export default {
  name: "App",
  components: {
    BlogHeader,
    BlogFooter
  },
    setup() {
        store.dispatch("adminAbout/getAdminInfo");
        updateArticleInfo();
        bus.on("articlePosted", updateArticleInfo);

        function updateArticleInfo() {
            store.dispatch("adminAbout/getArticleCount");
            store.dispatch("categoryAbout/getCategoryCounts");
            store.dispatch("tagAbout/getTagCounts");
        }
    },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin: 0 auto;
}
body,
html {
  margin: 0;
  padding: 0;
}
body{
  overflow: overlay;
  /* background-image: url(https://img0.baidu.com/it/u=1577435851,3470223877&fm=253&fmt=auto&app=138&f=JPEG?w=547&h=500); */

}
:root {
    /* --theme-color: #1892ff; */
    /* --text-color: #4c4948; */
    --card-box-shadow: var(--el-box-shadow);
}
/* 改变滚动条样式 */
::-webkit-scrollbar {
    height: 14px;
    width: 4px;
}
::-webkit-scrollbar-thumb {
    background-color: rgba(153, 153, 153, 0.8);
    border-radius: 10px;
}
::-webkit-scrollbar-track {
    border-radius: 10px;
}
/* #container{
  max-width: 1300px;
  margin: 0 auto;
  padding-top: 80px;
} */

</style>
