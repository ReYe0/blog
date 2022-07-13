import { createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';

import Prism from 'prismjs';
VueMarkdownEditor.use(vuepressTheme, {
    Prism,
  });
//引入mavonEditor
// import mavonEditor from 'mavon-editor'
// import 'mavon-editor/dist/css/index.css'
import axios from '@/utils/axiosInstance'

const app = createApp(App)
app.config.globalProperties.$axios=axios;  //配置axios的全局引用
// use
app.use(VueMarkdownEditor)
app.use(ElementPlus)
app.mount('#app')
