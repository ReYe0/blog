import { createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import VueMarkdownEditor from './utils/vueMarkdownEditor' // md 引入

// import axios from '@/utils/axiosInstance' // 引入 axios 请求方法

import router from './router/index' // 引入路由

import request from './utils/request' // 引入封装的 axios

import global from './style/global.css'

import * as ElementPlusIconsVue from '@element-plus/icons-vue'  // 给全局组件 应用图标

// import zhCn from 'element-plus/es/locale/lang/zh-cn' // 引入国际化
// i18n
import i18n from "@/i18n/i18n";

// const app = createApp(App)

const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

  
// ue.prototype.request = request 
// app.config.globalProperties.$axios=axios;  //配置axios的全局引用
// use
app.config.globalProperties.$http= request //vue 注册http
app.use(i18n)
app.use(global)
app.use(router)
app.use(VueMarkdownEditor)
app.use(ElementPlus)
app.mount('#app')
