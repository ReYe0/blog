<template>
  <el-menu
  router
    default-active="2"
    class="el-menu-vertical-demo"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
  <div style="height: 60px; line-height: 60px; text-align: center">
      <img
        src="../../assets/logo.png"
        alt=""
        style="width: 20px;position: relative; top: 5px; margin-right: 5px"
      />
      <b style="color: #999" v-if="logoTextShow">后台管理系统</b>
    </div>
    <el-menu-item index="/blogbackhome">
      <el-icon><document /></el-icon>
      <template #title>主页</template>
    </el-menu-item>
    <el-sub-menu>
      <template #title>
        <el-icon><location /></el-icon>
        <span>博客管理</span>
      </template>
      <el-menu-item-group>
        <template #title><span>Group One</span></template>
        <el-menu-item index="/writeBlog">编写博客</el-menu-item>
        <el-menu-item index="1-2" >item two</el-menu-item>
      </el-menu-item-group>
      <el-menu-item-group title="Group Two">
        <el-menu-item index="1-3">item three</el-menu-item>
      </el-menu-item-group>
      <el-sub-menu index="1-4">
        <template #title><span>item four</span></template>
        <el-menu-item index="1-4-1">item one</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="/writeBlog">
      <el-icon><document /></el-icon>
      <template #title>Navigator Two</template>
    </el-menu-item>
    <el-menu-item index="3" disabled>
      <el-icon><document /></el-icon>
      <template #title>Navigator Three</template>
    </el-menu-item>
    <el-menu-item index="4">
      <el-icon><setting /></el-icon>
      <template #title>Navigator Four</template>
    </el-menu-item>
  </el-menu>
</template>

<script>
import bus from "@/utils/bus";
export default{
    name:"Aside",
    data(){
        return{
            isCollapse:false,
            logoTextShow:true
        }
    },
  mounted(){
    bus.on("event",e=>{
        this.isCollapse = e
        this.logoTextShow = !this.logoTextShow
        console.log("e:",e);
    })
  },
  watch:{

    isCollapse:{
    deep: true,
    immediate:true,
        handler(newValue, oldValue) {
            this.isCollapse = newValue
    }
    }
},
methods:{
}
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  max-width: 400px;
  min-height: 400px;
}
</style>
