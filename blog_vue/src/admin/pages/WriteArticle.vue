<template>
  <div>
    <div>
      <MdEditor
        v-model="value"
        :theme="Boolean(isDark) === true ? 'dark' : 'light'"
        :language="getLang()"
        codeTheme="a11y"
        id="editor"
        @onUploadImg="onUploadImg"
      />
    </div>
    <!-- <div>{{Boolean(isDark) === true ? 'dark' : 'light'}},{{typeof isDark}},{{Boolean(isDark)}},{{isDark.value}},{{getLang()}}</div> -->
  </div>
</template>
<script>
import { useDark } from '@vueuse/core'
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
const language = ((navigator.language ? navigator.language : navigator.userLanguage) || "zh").toLowerCase();
export default {
  name: "WriteArticle",
  data() {
    return {
      isDark:useDark(),
      lang:localStorage.getItem('lang') || language.split('-')[0] || 'en',
      value:"# 真的难顶！！！！受不了了！！",
      // files:'',
      // urls:''
    };
  },
  components: {
    MdEditor,
  },
  mounted() {
    var height=document.documentElement.clientHeight - 80;
      document.getElementById('editor').style.height=height+'px';
    //解决this指向问题，在window.addEventListener中this是指向window的。
    //需要将vue实例赋值给_this,这样在window.addEventListener中通过_this可以为vue实例上data中的变量赋值
    let _this = this;
    //根据自己需要来监听对应的key
    window.addEventListener("setItemEvent", function (e) {
      //e.key : 是值发生变化的key
      //例如 e.key==="token";
      //e.newValue : 是可以对应的新值
      if (e.key === "isDark") {
        _this.isDark = e.newValue;
      }
      if(e.key === "lang"){
        _this.lang = e.newValue;
      }
    });
  },
  methods: {
    getLang(){
      this.lang = localStorage.getItem('lang') || language.split('-')[0] || 'en';
      if(this.lang == 'en'){
        return 'en-US';
      }else{
        return 'zh-CN';
      }
    },
    onUploadImg(files,urls){
      console.log(files,11);
      // console.log(this.files,22);
      console.log(urls,33);
      // console.log(this.urls,44);
      console.log("kewu");
    }
  },
};
</script>
<style>
#editor{
  height: 100%;
}
</style>
