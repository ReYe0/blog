<template>
  <div id="bar">
    <el-menu  mode="horizontal"  :default-active="activeIndex" router>
      <el-menu-item index="0">{{ $t("nav.logo") }}</el-menu-item>
      <el-input
        placeholder="Type something"
        style="width: 16%; height: 80%; margin-top: 5px; margin-left: 50%"
      >
        <template #prefix>
          <el-icon class="el-input__icon">
            <search />
          </el-icon>
        </template>
      </el-input>
      <div class="flex-grow" />
      <el-menu-item index="1">{{$t('home.homepage')}}</el-menu-item>
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
      <el-menu-item index="/writeArticle">admin</el-menu-item>
      <el-select v-model="value" class="m-2"  size="large" :change="changeLang(value)">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        />
      </el-select>
    </el-menu>
  </div>
</template>
<script>
import { getCurrentInstance } from "vue";
import { useI18n } from "vue-i18n"; //要在js中使用国际化
import { ref } from "vue";
export default {
  name: "MyNavigation",
  setup() {
    const { proxy } = getCurrentInstance();
    function change(type) {
      console.log("type:",type)
      // proxy.$i18n.locale = type;
      if(type != ''){
        localStorage.setItem('lang',type);
      }
      proxy.$i18n.locale = localStorage.getItem('lang');
    }
    const { t } = useI18n();
    console.log(t("home.name"));
    return { change };
  },
  data() {
    return {
      value: ref(""),
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
    };
  },
  methods:{
    changeLang(value){
        this.change(value)
    },
  },
};
</script>

<style>
.flex-grow {
  flex-grow: 0;
}

#bar {
  box-sizing: border-box;
  box-shadow: 0 2px 5px rgb(0 0 0 / 6%);
}

#bar > .el-menu {
  height: 50px;
  border-bottom-style: none;
  width: 100%;
  margin: 0;
  padding: 0;
}
</style>
