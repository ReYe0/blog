import { createI18n } from 'vue-i18n' //引入vue-i18n组件
import messages from './index'
const language = (
  (navigator.language ? navigator.language : navigator.userLanguage) || "zh"
).toLowerCase();
const i18n = createI18n({
  // silentFallbackWarn:true,
  fallbackLocale: 'en', // 设置备用语言
  globalInjection:true,
  legacy: false, // you must specify 'legacy: false' option
  locale: localStorage.getItem('lang') || language.split('-')[0] || 'en',//language.split("-")[0] || "zh",
  messages,
});
console.log(localStorage.getItem('lang') || language.split('-')[0] || 'en',888);
 
export default i18n