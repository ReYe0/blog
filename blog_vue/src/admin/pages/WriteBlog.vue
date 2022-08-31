<template>
  <div>
    <div>
      <!-- <el-input v-model="blog .title" placeholder="Please input the title" style="width:86%;margin:10px;margin-top:0;"/>
      <el-button type="primary" plain style="margin-top:-5px;" @click="saveOrUpdate">{{$t("md.saveDraft")}}</el-button>
      <el-button type="success" plain style="margin-right:0;margin-top:-5px;">{{$t("md.publishArticle")}}</el-button> -->
        <el-form
          ref="ruleFormRef"
          :model="blog"
          :rules="rules"
          label-width="50px"
          class="demo-ruleForm"
          :size="formSize"
          status-icon
          label-position="left"
        >
          <el-form-item label="标题" prop="title" required>
            <el-input v-model="blog.title" placeholder="默认内容第一张图片为封面" />
          </el-form-item>
          
          
          <el-form-item label="内容" prop="content" required>
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
            >
           
            </MdEditor>
          </el-form-item>
          <el-form-item label="描述" prop="description" required>
            <el-input v-model="blog.description" placeholder="默认内容第一张图片为封面"/>
          </el-form-item>
          <el-form-item label="分类" required >
            <el-col :span="11">
              <el-form-item prop="date1">
                <el-input v-model="blog.description" />
              </el-form-item>
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="12">
              <el-form-item prop="date2" label="标签">
                <el-input v-model="blog.description" />
              </el-form-item>
            </el-col>
          </el-form-item>
           <el-form-item>
            <el-button type="primary" @click="onSubmit">立即发布</el-button>
            <el-button>保存草稿</el-button>
          </el-form-item>
        </el-form>

   
    </div>
    <div>
      
    </div>
  </div>
</template>
  
<script setup>
import { useDark } from "@vueuse/core";
import MdEditor from "md-editor-v3";
import "md-editor-v3/lib/style.css";
import "@/assets/iconfont";
import axios from "axios";
import { ElMessage } from "element-plus";
// import type { FormInstance, FormRules } from 'element-plus'
import { reactive, ref } from 'vue'
const formSize = ref('default')
// const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  name: 'Hello',
  region: '',
  count: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})
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
  name: "WriteBlog",
  data() {
    return {
      blog: {
        title: "",
        content: "# 字符效果\n\n* ~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n* *斜体字* _斜体字_\n* **粗体** __粗体__\n* ***粗斜体*** ___粗斜体___\n\n* 上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n* ==高亮==\n\n* `Inline Code`\n\n> 引用：如果想要插入空白换行（即 `<br>` 标签），在插入处先键入两个以上的空格然后回车即可\n\n\n#  超链接\n* [普通链接](https://www.cnblogs.com/zhiyiYo/)\n* [*斜体链接*](https://www.cnblogs.com/zhiyiYo/)\n* [**粗体链接**](https://www.cnblogs.com/zhiyiYo/)\n\n# 脚注\n这是一个简单的脚注 [^1] 而这是一个更长的脚注 [^bignote].\n\n[^1]: 这是第一个脚注.\n\n[^bignote]: 这是一个非常长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的脚注.\n\n\n# 图像\n下面是一张我家硝子的壁纸?:\n![硝子1](https://i.niupic.com/images/2022/03/11/9Wl7.jpg)\n再来一张好了?：\n![硝子2](https://i.niupic.com/images/2022/03/12/9Wme.jpg)\n\n# 代码\n\n## 行内代码\n在 VS Code 中按下 <kbd>Alt</kbd> + <kbd>T</kbd> + <kbd>R</kbd> 执行命令：`npm install marked`\n\n## 代码片\n\n### Python 代码\n```python\nclass Animal:\n    \"\"\" 动物类 \"\"\"\n\n    def __init__(self, age: int, name: str):\n        self.age = age\n        self.name = name\n\n    def getInfo(self) -> str:\n        \"\"\" 返回信息 \"\"\"\n        return f'age: {self.age}; name: {self.name}'\n\n\nclass Dog(Animal):\n    \"\"\" 狗狗类 \"\"\"\n\n    def __init__(self, age: int, name: str, gender='female', color='white'):\n        super().__init__(age, name)\n        self.gender = gender\n        self.__color = color\n\n    def bark(self):\n        \"\"\" 狗叫 \"\"\"\n        print('lololo')\n\n    @property\n    def color(self):\n        return self.__color\n\n    @color.setter\n    def color(self, color: str):\n        if color not in ['red', 'white', 'black']:\n            raise ValueError('颜色不符合要求')\n        self.__color = color\n\n\nif __name__ == '__main__':\n    dog = Dog(16, '啸天', gender='male')\n    # 狗叫\n    dog.bark()\n    # 设置狗狗毛色\n    dog.color = 'blue'\n```\n\n### HTML 代码\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```\n\n\n\n# 列表\n\n## 无序列表\n\n* 福建\n  * 厦门\n  * 福州\n* 浙江\n* 江苏\n## 有序列表\n\n1. 动物\n   1. 人类\n   2. 犬类\n2. 植物\n3. 微生物\n\n## 任务列表\n\n- [x] 预习计算机网络\n- [ ] 复习现代控制理论\n- [ ] 刷现代控制理论历年卷\n    - [ ] 2019 年期末试卷\n    - [ ] 2020 年期末试卷\n\n\n\n# 表格\n\n| 项目   |  价格 | 数量  |\n| ------ | ----: | :---: |\n| 计算机 | $1600 |   5   |\n| 手机   |   $12 |  12   |\n| 管线   |    $1 |  234  |\n\n----\n\n# 特殊符号\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n# Emoji表情 :satisfied:\n* 马：:horse:\n* 星星：:star2:\n* 笑脸：:smile:\n* 跑步：:running:\n\n# 数学公式\n\n行间公式：\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n行内公式 $E=mc^2$\n\n# 绘图\n## 时序图\n\n```mermaid\nsequenceDiagram\n\n  Alice->>John: Hello John, how are you?\n  loop Healthcheck\n      John->>John: Fight against hypochondria\n  end\n  Note right of John: Rational thoughts!\n       John-->>Alice: Great!\n       John->>Bob   : How about you?\n       Bob-->>John  : Jolly good!\n```\n\n\n## 状态图\n\n```mermaid\nstateDiagram\n\n    [*]-->Active\n    state Active {\n        [*]-->NumLockOff\n        NumLockOff-->NumLockOn : EvNumLockPressed\n        NumLockOn-->NumLockOff : EvNumLockPressed\n        --\n        [*]-->CapsLockOff\n        CapsLockOff-->CapsLockOn : EvCapsLockPressed\n        CapsLockOn-->CapsLockOff : EvCapsLockPressed\n        --\n        [*]-->ScrollLockOff\n        ScrollLockOff-->ScrollLockOn : EvCapsLockPressed\n        ScrollLockOn-->ScrollLockOff : EvCapsLockPressed\n            }\n```",
        description:""
      },
      // title:'',
      isDark: useDark(),
      lang: localStorage.getItem("lang") || language.split("-")[0] || "en",
      // value: "# 西游记",
      toolbarsExclude: ["github"],
    };
  },
  mounted() {
    var height = document.documentElement.clientHeight - 120 - 250;
    if(height < 300){
      height = 300
    }
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
    onSave() {
      if (this.blog.content === "" && this.blog.title === "") {
        return false;
      }
      this.saveOrUpdate();
    },
    onChange() {
      if (this.blog.content === "" && this.blog.title === "") {
        return false;
      }
      this.$http.post("blog/saveOrUpdate", this.blog).then((res) => {
        if (res.data.code === "200") {
          this.blog = res.data.data;
        }
      });
    },
    saveOrUpdate() {
      this.$http.post("blog/saveOrUpdate", this.blog).then((res) => {
        if (res.data.code === "200") {
          this.blog = res.data.data;
          this.$message.success("保存成功");
        }
      });
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
