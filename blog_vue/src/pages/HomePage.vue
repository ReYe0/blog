<template>
  <div>
    <MyNavigationVue/>
    <el-row :gutter="24">
      <el-col :span="6">
        1<el-button type="primary" @click="test">sdfsdf</el-button>
      </el-col>
      <el-col :span="12">
        2
      </el-col>
      <el-col :span="6">
        3
      </el-col>
    </el-row>
  </div>
</template>

<script>

import MyNavigationVue from '@/components/MyNavigation.vue';

export default {
  name: 'HomePage',
  props: {
    msg: String
  },
  components:{
    MyNavigationVue
  },
   methods:{
    test(){
      this.$http.get("/sdfsdf")
    }
  }
}
</script>
<style scoped>
div{
    overflow-x: hidden;
    padding: 0 30px;
    box-sizing: border-box;
}
</style>
