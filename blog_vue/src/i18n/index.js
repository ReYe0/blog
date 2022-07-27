// \src\i18n\index.ts
// import { createI18n } from "vue-i18n";
// 语言包
import zh from "./lang/zh";
import en from "./lang/en";
 

// const language = (navigator.language || 'en').toLocaleLowerCase() // 这是获取浏览器的语言
// const i18n = createI18n({
  // locale: localStorage.getItem('lang') || language.split('-')[0] || 'en', // 首先从缓存里拿，没有的话就用浏览器语言，
  // fallbackLocale: 'en', // 设置备用语言
  // locale: sessionStorage.getItem("localeLang") || "zhCn",
  // messages: {
    // zhCn,
    // en,
  // },
// });
 
// export default i18n;
export default {
  en,
  zh,
}