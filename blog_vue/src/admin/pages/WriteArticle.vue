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
        :toolbarsExclude="toolbarsExclude"
      />
    </div>
  </div>
</template>
<script setup>
import { useDark } from "@vueuse/core";
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
import axios from "axios";
import { ElMessage } from "element-plus";
//判断图片类型是否支持上传，支持true,不支持false
function Chacktypefun(name) {
  return /\.(gif|jpg|jpeg|png)$/i.test(name);
} // 判断图片类型
const onUploadImg = async (files, callback) => {
  let urls;
  const res = await Promise.all(
    files.map((file) => {
      if (Chacktypefun(file)) {
        ElMessage({
          message: "亲，图片格式不支持哦！",
          type: "warning",
        });
        return false;
      }
      if (file.size > 2 * 1024 * 1024) {
        ElMessage({
          message: "亲，图片太大哦，已经超过2M了哦！",
          type: "warning",
        });
        return false;
      }
      return new Promise((rev, rej) => {
        const form = new FormData();
        form.append("file", file);

        axios
          .post("http://localhost:8090/file/upload", form, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
          .then((res) => rev(res))
          .catch((error) => rej(error));
      });
    })
  );

  callback((urls = res.map((item) => item.data.data.url)));
};
</script>
<script>
const language = (
  (navigator.language ? navigator.language : navigator.userLanguage) || "zh"
).toLowerCase();

export default {
  name: "WriteArticle",
  data() {
    return {
      isDark: useDark(),
      lang: localStorage.getItem("lang") || language.split("-")[0] || "en",
      value: "# 真的难顶！！！！受不了了！！",
      toolbarsExclude: ["github"],
    };
  },
  mounted() {
    var height = document.documentElement.clientHeight - 80;
    document.getElementById("editor").style.height = height + "px";
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
      if (e.key === "lang") {
        _this.lang = e.newValue;
      }
    });
  },
  methods: {
    getLang() {
      this.lang =
        localStorage.getItem("lang") || language.split("-")[0] || "en";
      if (this.lang == "en") {
        return "en-US";
      } else {
        return "zh-CN";
      }
    },
  },
};
</script>
<style>
#editor {
  height: 100%;
}
</style>
