<template>
  <el-container style="height: 100vh;width:99%;">
    <el-aside
      :width="sideWidth"
      height="100vh"
    >
    <Aside/>

    </el-aside>
  <!-- {{isCollapse}} -->
    <el-container >
      <el-header
        style="
          margin-bottom:50px;
          padding:0;
          width:101%;
        "
      >
      <Header  :staff="staff"/>
      <TagsView style="padding:5px 0;"/>
      </el-header>
      <!-- 表示当前页面的子路由 会在 <router-view/> 里面展示 -->
      <router-view @refreshStaff="getStaff"/>
      <el-main>
          <HomePage/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import HomePage from '@/admin/components/HomePage'
import TagsView from "../components/TagsView/index.vue"
// import { ref } from 'vue'
// @ is an alias to /src
import Aside from './../components/Aside.vue'
import Header from './../components/Header.vue'

export default {
  name: "BlogBackHome",
  components: {
    Aside,
    Header,
    TagsView,
    HomePage
  },
  // setup(){
  //   const  isCollapse = ref(false)
  //   return {isCollapse}
  // },
  data() {
    return {

      collapseBtnClass: "el-icon-s-fold",
      isCollapse: false,
      sideWidth: "200px",
      // logoTextShow: true,
      staff: {}
    };
  },
  created(){
    //从后台获取最新的数据
    this.getStaff()
  },

  methods: {
    collapse() {
      console.log(888888);
      //点击收缩按钮触发
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        //收缩
        this.sideWidth = "50px";
        // this.collapseBtnClass = "el-icon-s-unfold";
        // this.logoTextShow = false;
      } else {
        //展开
        this.sideWidth = "200px";
        // this.collapseBtnClass = "el-icon-s-fold";
        // this.logoTextShow = true;
      }
    },
    getStaff(){
      let id = localStorage.getItem("staff") ? JSON.parse(localStorage.getItem("staff")).id :""
      if(id){
        //从后台获取Staff数据
       this.request.get("/staff/get/" + id).then(res =>{
         //重新赋值后台的最新数据
         this.staff = res.data.staff
        //  localStorage.setItem("staff",JSON.stringify(res.data))
       })
      }

      },
    
  },
};
</script>
<style>

</style>
