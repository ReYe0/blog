<template>
  <div id="DarkModelPage" class="bar dark">
    <el-menu mode="horizontal" :default-active="activeIndex" router>
      <el-menu-item>{{ $t("nav.logo") }}</el-menu-item>
      <div class="flex-grow" />

      <el-input
        placeholder="Type something"
        style="width: 16%; height: 80%; margin-top: 5px; "
      >
        <template #prefix>
          <el-icon class="el-input__icon">
            <search />
          </el-icon>
        </template>
      </el-input>
      <el-menu-item index="/">{{ $t("home.homepage") }}</el-menu-item>
      <el-sub-menu index="2">
        <template #title>Workspace</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-menu-item index="2-2">item two</el-menu-item>
        <el-menu-item index="2-3">item three</el-menu-item>
        <el-sub-menu index="2-4">
          <template #title>item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="/writeBlog">admin</el-menu-item>
      <!--
      <el-select v-model="value" class="m-2"  size="large" :change="changeLang(value)">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        />
      </el-select>
      -->
      <el-button-group style=" margin-top: 10px;" >
        <span @click.stop="toggleDark()"></span>
        <el-button v-show="isDark" icon="Sunny" @click="changeTheme"/>
        <el-button v-show="!isDark" icon="Moon" @click="changeTheme"/>
        <el-button @click="changeLang(lang)">{{lang.toUpperCase()}}</el-button>
      </el-button-group>
    </el-menu>
  </div>
</template>

<script>
import { getCurrentInstance } from "vue";
// import { useI18n } from "vue-i18n"; //要在js中使用国际化
import { ref } from "vue";
const language = ((navigator.language ? navigator.language : navigator.userLanguage) || "zh").toLowerCase();
import { useDark, useToggle } from '@vueuse/core'

export default {
  name: "MyNavigation",
  setup() {
    const isDark = useDark()
    const toggleDark = useToggle(isDark)
    const { proxy } = getCurrentInstance();
    function change(type) {
      console.log("type:", type);
      // proxy.$i18n.locale = type;
      if (type != "") {
        localStorage.setItem("lang", type);
      }
      proxy.$i18n.locale = localStorage.getItem("lang");
    }
    // const { t } = useI18n();
    // console.log(t("home.name"));
    return { change ,toggleDark};
  },
  data() {
    return {
      lang: ref(localStorage.getItem('lang') || language.split('-')[0] || 'en'),
      options: [
        {
          value: "zh",
          label: "中文",
        },
        {
          value: "en",
          label: "英文",
        },
      ],
      isDark:false,
    };
  },
  methods: {
    changeTheme(){
      this.isDark = !this.isDark
      localStorage.setItem('isDark',this.isDark)
    },
    changeLang(value) {
      if(value == 'en'){
        value = 'zh'
      }else{
        value = 'en'
      }
      // this.useToggle(true);
      this.lang = value;
      this.change(value);
    },
  },
};
</script>
<style lang="css">


.flex-grow {
  flex-grow: 0.9;
}

.bar {
  box-sizing: border-box;
  box-shadow: 0 2px 5px rgb(0 0 0 / 6%);
}

.bar > .el-menu {
  height: 50px;
  border-bottom-style: none;
  width: 100%;
  margin: 0;
  padding: 0;
}
</style>
