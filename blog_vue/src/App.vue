<template>

  <div id="app">
  <MyNavigation/>
    <router-view></router-view>
  </div>
</template>

<script>
import MyNavigation from '@/components/MyNavigation'
export default {
  name: 'App',
  components:{
    MyNavigation
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
