<template>
  <div id="app">
    <BlogHeader />
    <router-view></router-view>
  </div>
</template>

<script>
import BlogHeader from "@/components/BlogHeader.vue";
export default {
  name: "App",
  components: {
    BlogHeader,
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
  /* background-color: #F3F6F7; */
}
#container{
  max-width: 1300px;
  margin: 0 auto;
  padding-top: 80px;
}
</style>
