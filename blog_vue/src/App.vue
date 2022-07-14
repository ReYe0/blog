<template>
  <div>
    <MyNavigation/>
    <MyHome/>
    <WriteArticle/>
  </div>
  
  <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import MyHome from './components/MyHome.vue'
import MyNavigation from './components/MyNavigation.vue'
import WriteArticle from './pages/WriteArticle.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld,
    MyHome,
    MyNavigation,
    WriteArticle
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  /* margin:auto 0; */
  /* width:100%; */
  /* overflow-x: auto; */
  padding:0;
  /* overflow: auto; */
  /* background-color: red; */
  /* margin-top: 60px; */
}
/* #app > div{ */
    /* //这个样式添加到el-row的父级中 */
    /* margin: auto 0; */
  /* overflow-x: hidden;
  padding: 0 30px;
  box-sizing: border-box; */

  /* margin:auto 0; */
/* } */
</style>
