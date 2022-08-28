<template>
  <div style="line-height: 60px;width:100%;display: flex;border:none; box-sizing: border-box;box-shadow: 0 2px 5px rgb(0 0 0 / 6%);">
    <div style="flex: 1; ">
      <el-icon style="cursor: pointer;font-size: 18px;" @click="collapseAside()" v-if="!isCollapse"><Fold /></el-icon>
      <el-icon style="cursor: pointer;font-size: 18px;" @click="collapseAside()" v-else><Expand /></el-icon>
      <el-breadcrumb separator="/" style="display:inline-block;margin-left:10px;">
        <el-breadcrumb-item :to="'/blogbackhome'">首页</el-breadcrumb-item>
        <el-breadcrumb-item >{{currentPathName.currentPathName}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-dropdown style=" cursor: pointer;">
      <div >
        <img src="../../assets/logo.png" alt="" style="width:30px;border-radius:50%;position:relative;top:10px;right:5px;">
      <span>admin</span
      >
      <el-icon style="margin-left: 5px;vertical-align: middle;"><ArrowDown /></el-icon>
      </div>

        <template #dropdown >
          <el-dropdown-menu >
            <el-dropdown-item :icon="Plus">个人信息</el-dropdown-item>
            <el-dropdown-item :icon="CirclePlusFilled">
              <router-link to="/">返回前端</router-link>
            </el-dropdown-item>
            <el-dropdown-item :icon="CirclePlus">退出</el-dropdown-item>
            <el-dropdown-item :icon="Check">Action 4</el-dropdown-item>
            <el-dropdown-item :icon="CircleCheck">Action 5</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      <!-- <el-dropdown-menu slot="dropdown" style="text-align:center;">
        <el-dropdown-item style="font-size:14px;padding:5px 5px;"><router-link to="/person">个人信息</router-link></el-dropdown-item>
        <el-dropdown-item style="font-size:14px;padding:5px 5px;">
          <span style="text-decoration:none;" @click="logout">退出</span>
          </el-dropdown-item>
      </el-dropdown-menu> -->
    </el-dropdown>
  </div>
</template>
<script>
import bus from "@/utils/bus";
export default {
  name: "Header",
  data(){
    return{
      // staff:localStorage.getItem("staff") ? JSON.parse(localStorage.getItem("staff")) : {}
      // staff:Object
      isCollapse:false,
    //   logoTextShow:true
    }
  },
  props: {
    staff:Object,
  },
  computed:{
    currentPathName(){
      return this.$store.state.currentPathName;//需要监听的数据
    }
  },
  watch:{// 监听路由变化
      currentPathName(newVal,oldVal){
        console.log(newVal);
      }
      },
  methods:{
    collapseAside(){
        this.isCollapse = !this.isCollapse
        bus.emit("event",this.isCollapse)
        this.$parent.$parent.$parent.$parent.collapse()  // 通过4个 $parent 找到父组件，从而调用其折叠方法
    },
    logout(){
      this.$router.push("/login")
      localStorage.removeItem("staff")
      this.$message.success("退出成功")
    },
  }
  }

</script>
