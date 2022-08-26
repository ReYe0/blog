import { createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/dark/css-vars.css';
import '@/assets/style/element-variarbles.scss'
// 设置icon
import FontAwesomeIcon from "./utils/fontawesome-icons";

import router from './router/index' // 引入路由

import request from './utils/request' // 引入封装的 axios

// import global from '@/assets/style/global.css'

import * as ElementPlusIconsVue from '@element-plus/icons-vue'  // 给全局组件 应用图标
import store from './store'

// i18n
import i18n from "@/i18n/i18n";

import MdEditorV3 from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
// import './style/index.css'
import tool from "./utils/tool";



const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

app.config.globalProperties.$http= request //vue 注册http ，这样请求 this.$http.post
app.config.warnHandler = () => null;
app.config.errorHandler = () => null;
app.config.productionTip = false 
app.use(i18n)
app.use(tool);
app.use(MdEditorV3)
app.use(store)
app.use(router)
app.use(ElementPlus)
app.component("font-awesome-icon", FontAwesomeIcon)
app.mount('#app')
