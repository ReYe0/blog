<template>
  <div>
    <div>
      <MdEditor
        v-model="value"
        :theme="Boolean(isDark) === true ? 'dark' : 'light'"
        codeTheme="github"
      />
    </div>
    <div>{{Boolean(isDark) === true ? 'dark' : 'light'}},{{typeof isDark}},{{Boolean(isDark)}},{{isDark.value}}</div>
  </div>
</template>
<script>
import { useDark } from '@vueuse/core'
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
export default {
  name: "WriteArticle",
  data() {
    return {
      isDark:useDark(),
      value:"大话西游"
    };
  },
  components: {
    MdEditor,
  },
  mounted() {
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
    });
  },
  methods: {

  },
};
</script>
<style></style>
