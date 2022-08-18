<template>
  <div id="app">
    <BlogHeader />
    <div style="margin-bottom: 80px"></div>
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
  /* width: 100%;
  height: 100%; */
  margin: 0 auto;
  /* padding: 0; */
}
body,
html {
  margin: 0;
}
#container{
  max-width: 1300px;
  margin: 0 auto;

}
</style>
