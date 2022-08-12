<template>
  <div>
    <div>
      <el-input v-model="blog.title" placeholder="Please input the title" style="width:86%;margin:10px;"/>
      <el-button type="primary" plain style="margin-top:-5px;" @click="saveOrUpdate">{{$t("md.saveDraft")}}</el-button>
    <el-button type="success" plain style="margin-right:0;margin-top:-5px;">{{$t("md.publishArticle")}}</el-button>
    </div>
    <div>
      <MdEditor
        v-model="blog.content"
        :theme="Boolean(isDark) === true ? 'dark' : 'light'"
        :language="getLang()"
        codeTheme="a11y"
        no-iconfont="true"
        id="editor"
        @onUploadImg="onUploadImg"
        @onChange="onChange"
        @onSave="onSave"
        :toolbarsExclude="toolbarsExclude"
      />
    </div>
  </div>
</template>
<script setup>
import { useDark } from "@vueuse/core";
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
import '@/assets/iconfont';
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
      blog:{
        title:'西游记',
        content:"一天，孙悟空骑着白龙马去拯救了唐三藏……",
      },
      // title:'',
      isDark: useDark(),
      lang: localStorage.getItem("lang") || language.split("-")[0] || "en",
      // value: "# 西游记",
      toolbarsExclude: ["github"],
    };
  },
  mounted() {
    var height = document.documentElement.clientHeight - 120;
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
    onSave(){
      if(this.blog.content === '' && this.blog.title === ''){
        return false
      }
      this.saveOrUpdate();
    },
    onChange(){
      if(this.blog.content === '' && this.blog.title === ''){
        return false
      }
      this.$http.post("blog/saveOrUpdate",this.blog).then(res => {
        if(res.data.code === '200'){
          this.blog = res.data.data
        }
      })
    },
    saveOrUpdate(){
      this.$http.post("blog/saveOrUpdate",this.blog).then(res => {
        if(res.data.code === '200'){
          this.blog = res.data.data
          this.$message.success("保存成功")
        }
      })
    },
    // 获取本地语言修改md
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
