<template>

  <div id="app">
  <BlogHeader/>
  <div style="margin-bottom:80px;"></div>
    <router-view></router-view>
  </div>
</template>

<script>
import BlogHeader from '@/components/BlogHeader.vue'
export default {
  name: 'App',
  components:{
    BlogHeader,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* margin: 0;
  padding: 0; */
}
body,html{
  margin:0;
}
</style>
