import {createRouter, createWebHistory} from 'vue-router';
import routes from './routes';
import store from '@/store';
// import { mapState } from "@/store";
// import { mapState } from "../store/map";

const router = createRouter({
    history: createWebHistory(), 
    routes
});
// 路由守卫
router.beforeEach((to, from, next) => {
    console.log("to.name",to);
    localStorage.setItem("currentPathName", to.name); //设置当前路由名称,未来在Header组件中去使用
    store.commit("currentPathName/setPath");
    // store.commit("setPath"); //触发store的数据更新
    //未找到路由的情况
    if(!to.matched.length){
    const storeMenus = localStorage.getItem("menus")
    console.log(storeMenus);
      if(storeMenus){
        next("/404"); 
      }else{
        // 跳回登录页面
        next("/login")
      }
    }
    
  next()//放行路由
  });
export default router;
