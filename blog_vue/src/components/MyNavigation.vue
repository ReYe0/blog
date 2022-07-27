<template>
  <div id="bar">
    <el-menu :default-active="activeIndex" mode="horizontal" router>
      <el-menu-item index="0">{{ $t("home.name") }} BLOG </el-menu-item>
      <!-- <div @click="change('zhCn')">中文</div>
      <div @click="change('en')">English</div> -->
      <!-- <el-button type="primary" @click="changeLnag('en')">语言切换</el-button> -->
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
      <el-menu-item index="1">首页</el-menu-item>
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
      <el-select v-model="value" class="m-2"  size="large" :change="test(value)">
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
// import { useI18n } from 'vue-i18n'
// import {  ref } from "vue";
// import { getCurrentInstance } from "@vue/runtime-core";

// import { useStore } from "vuex";
// const store = useStore();
// const { locale } = useI18n();
import { getCurrentInstance } from "vue";
import { useI18n } from "vue-i18n"; //要在js中使用国际化
import { ref } from "vue";
export default {
  name: "MyNavigation",
  setup() {
    const { proxy } = getCurrentInstance();
    function change(type) {
      proxy.$i18n.locale = type;
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
          value: "zhCn",
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
    test(value){
        this.change(value)
    }
  }
  // setup(){
  //     const { t } = useI18n();
  //     let { ctx } = getCurrentInstance();

  // const lang_menu = ref([
  //   { name: "中文", id: "zh" },
  //   { name: "英文", id: "en" },
  // ]);
  // const curren_lang = ref("英文");

  // // const tran_txt = computed(() => {
  // //   return {
  // //     hello: t("index.hello"),
  // //   };
  // // });

  // // 切换语言
  // const changeLang = (item) => {
  //   curren_lang.value = item.name;
  //   ctx.$i18n.locale = item.id;
  // };

  // return {
  //   t,
  // //   tran_txt,
  //   curren_lang,
  //   lang_menu,
  //   changeLang,
  // };
  // }
  // compoent: {
  //     // Search
  // },
  // data() {
  //     // store:userStore()
  //     // locale:I18n
  //     // Search
  // },
  // methods:{
  //     changeLnag(lang){
  //         locale.value = lang;
  //         store.commit("CHANGE_LANGUAGE",lang);
  //     }
  // },
  // setup(){

  // }
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
