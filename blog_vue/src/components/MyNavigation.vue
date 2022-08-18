<template>
<header>
   <!-- <router-link class="header-title" to="/"
            >✨ Kila Kila Blog ✨</router-link
        > -->
  <div class="bar">
    <el-menu mode="horizontal" :default-active="activeIndex" router>
      <el-menu-item>{{ $t("nav.logo") }}</el-menu-item>
      <!-- <div class="flex-grow" /> -->

      <el-input
        placeholder="Type something"
        style="width: 16%; height: 80%; margin-top: 5px"
      >
        <template #prefix>
          <el-icon class="el-input__icon">
            <search />
          </el-icon>
        </template>
      </el-input>
      <el-menu-item index="/">{{ $t("home.homepage") }}</el-menu-item>
      <!-- <el-sub-menu index="2">
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
      </el-sub-menu> -->
      <el-menu-item index="/writeArticle">{{
        $t("nav.backstage")
      }}</el-menu-item>
      <el-button-group style="margin-top: 10px">
        <span @click.stop="toggleDark()"></span>
        <el-button v-show="isDark" icon="Sunny" @click="changeTheme()" />
        <el-button v-show="!isDark" icon="Moon" @click="changeTheme()" />
        <el-button @click="changeLang()">{{
          lang === "en" ? "ZH" : "EN"
        }}</el-button>
      </el-button-group>
    </el-menu>
    <div id="header-menu-button" @click="drawer = !drawer">
            sdf
            <font-awesome-icon :icon="['fas', 'bars']" />
        </div>

        <el-drawer
            v-model="drawer"
            direction="ltr"
            :show-close="false"
            :with-header="false"
            size="40%"
        >
                        <kila-kila-admin-menu />

        </el-drawer>
  </div>
  </header>
</template>

<script setup>
import { getCurrentInstance } from "vue";
import { ref } from "vue";
const language = (
  (navigator.language ? navigator.language : navigator.userLanguage) || "zh"
).toLowerCase();
import { useDark, useToggle } from "@vueuse/core";
let drawer = ref(false);
  window.addEventListener("resize", function () {
            let scale = window.devicePixelRatio;
            let width = document.documentElement.clientWidth * scale;
            if (width > 900 * scale) {
                drawer.value = false;
            }
        });
        
var isDark = useDark();
const toggleDark = useToggle(isDark);
const { proxy } = getCurrentInstance();
function change(type) {
  if (type != "") {
    localStorage.setItem("lang", type);
  }
  proxy.$i18n.locale = localStorage.getItem("lang");
}
let lang = ref(localStorage.getItem("lang") || language.split("-")[0] || "en");
function changeTheme() {
  this.toggleDark();
  localStorage.setItem("isDark", isDark);
}
function changeLang() {
  if (this.lang == "en") {
    this.lang = "zh";
  } else {
    this.lang = "en";
  }
  change(this.lang);
}
</script>
<style lang="css">
/* .flex-grow {
  flex-grow: 0.9;
} */
@media screen and (max-width: 900px) {
    .bar {
        display: none;
    }

    /* #header-menu-button {
        display: inline-block;
    } */
}
/* 
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
@media screen and (max-width: 800px) {
  .flex-grow {
    flex-grow: 1;
  } */
/* } */
</style>
