<template>
  <div>
    <el-row :gutter="24">
      <el-col :span="6">
        1
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
<script >
export default {
  name: "MyHome"
}
</script>
<style scoped>
div{
    overflow-x: hidden;
    padding: 0 30px;
    box-sizing: border-box;
}
</style>