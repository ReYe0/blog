<template>
  <div id="app">
    <BlogHeader />
    <div style="opacity:0;margin-top:80px;"></div>
    <router-view></router-view>
    <BlogFooter :adminName="$store.state.adminAbout.adminInfo.nickName"/>
  </div>
</template>

<script>
import BlogHeader from "@/components/BlogHeader.vue";
import BlogFooter from '@/components/BlogFooter'
export default {
  name: "App",
  components: {
    BlogHeader,
    BlogFooter
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin: 0 auto;
  /* background-color: #fff; */
}
body,
html {
  margin: 0;
  padding: 0;
}
:root {
    /* --theme-color: #1892ff; */
    /* --text-color: #4c4948; */
    --card-box-shadow: var(--el-box-shadow);
}
/* #container{
  max-width: 1300px;
  margin: 0 auto;
  padding-top: 80px;
} */

</style>
