<template>
  <div>
    <div>
      <MdEditor
        v-model="value"
        :theme="isDark === false ? 'light' : 'dark'"
        codeTheme="github"
      />
    </div>
    <!-- <div>{{isDark === false ? 'light' : 'dark'}},{{isDark}},{{test()}}</div> -->
  </div>
</template>
<script>
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
export default {
  name: "WriteArticle",
  data() {
    return {
      isDark:  JSON.parse(localStorage.getItem("isDark")),
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
    test(){
        if(this.isDark === false){
            return 'light';
        }
        if(this.isDark === true){
            return 'dark';
        }
        // return this.isDark === false ? 'light' : 'dark';
    }

  },
};
</script>
<style></style>
