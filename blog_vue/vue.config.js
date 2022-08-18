const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
    // 设置lintOnSave为false,禁用eslint。
    // lintOnSave: false,
  lintOnSave:false
})
