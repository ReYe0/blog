<template>
  <header>
    <router-link class="header-title" to="/"
      >{{ $t("nav.logo") }}</router-link
    >
    <div class="header-menu">
      <div v-for="item in menuItems" :key="item.name">
        <router-link :to="item.href" class="header-menu-item">
          <!-- <font-awesome-icon :icon="item.icon" class="header-icon" /> -->
          {{
            $t(item.name)
          }}
        </router-link>
      </div>
      <el-button-group style="margin-left:20px;border-radius:8%;">
        <span @click.stop="toggleDark()"></span>
        <el-button v-show="isDark" icon="Sunny" @click="changeTheme()" />
        <el-button v-show="!isDark" icon="Moon" @click="changeTheme()" />
        <el-button @click="changeLang()">{{
          lang === "en" ? "ZH" : "EN"
        }}</el-button>
      </el-button-group>
    </div>

    <div id="header-menu-button" @click="drawer = !drawer">
      <el-icon><Fold /></el-icon>
    </div>

    <el-drawer
      v-model="drawer"
      direction="rtl"
      :show-close="false"
      :with-header="false"
      size="40%"
    >
    </el-drawer>
  </header>
</template>

<script setup>
import { reactive, ref } from "vue";
import { getCurrentInstance } from "vue";
let drawer = ref(false);
let menuItems = reactive([
  { name: "home.homepage", icon: ["fab", "fort-awesome"], href: "/" },
  {
    name: "nav.backstage",
    icon: ["fas", "box-archive"],
    href: "/writeArticle",
  },
  { name: "分类", icon: ["fas", "folder"], href: "/category" },
  { name: "标签", icon: ["fas", "tags"], href: "/tag" },
  { name: "个人中心", icon: ["fas", "user"], href: "/user/settings" },
]);

// if (store.state.adminAbout.isAdmin) {
//     menuItems.splice(4, 0, {
//         name: "新随笔",
//         icon: ["fas", "pen"],
//         href: "/article/add",
//     });
// }

window.addEventListener("resize", function () {
  let scale = window.devicePixelRatio;
  let width = document.documentElement.clientWidth * scale;
  if (width > 900 * scale) {
    drawer.value = false;
  }
});
const language = (
  (navigator.language ? navigator.language : navigator.userLanguage) || "zh"
).toLowerCase();
import { useDark, useToggle } from "@vueuse/core";

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

<style scoped>
header {
  position: fixed;
  top: 0;
  height: 60px;
  width: 100%;
  z-index: 9999;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 3%;
  box-sizing: border-box;
  box-shadow: 0 2px 5px rgb(0 0 0 / 6%);
  animation: fadeUpIn 1s;
}

.el-button-group>.el-button:not(:first-child):not(:last-child) {
  border-top-left-radius: 8%;
    border-bottom-left-radius: 8%;
}
.header-title {
  font-size: 23px;
  text-decoration: none;
  transition: all 0.2s;
  color: var(--el-menu-text-color);
}

.header-title:hover {
  color: #80c8f8;
}

.header-icon {
  margin-right: 7px;
}

.header-menu {
  display: flex;
  position: relative;
}

.header-menu-item {
  text-decoration: none;
  font-size: 14px;
  margin-left: 25px;
  position: relative;
  top:5px;
  transition: color 0.4s ease-in-out;
  color: var(--el-menu-text-color)
}

.header-menu-item:hover {
  color: var(--el-menu-hover-text-color);
}

.header-menu-item:after {
  content: "";
  width: 0;
  height: 3px;
  background: #80c8f8;
  position: absolute;
  bottom: 0;
  left: 50%;
  transition: all 0.4s ease-in-out;
  border-radius: 2px;
}

.header-menu-item:hover:after {
  left: 0%;
  width: 100%;
}

#header-menu-button {
  display: none;
  color: var(--text-color);
  cursor: pointer;
  position: relative;
  font-size: 20px;
  margin: 0;
}

#header-menu-button:hover {
  color: var(--text-hover-color);
}

:deep(.el-drawer__body) {
  padding: 0;
}

@media screen and (max-width: 900px) {
  .header-menu {
    display: none;
  }

  #header-menu-button {
    display: inline-block;
  }
}

@keyframes fadeUpIn {
  0% {
    -webkit-transform: translateY(-100%);
    transform: translateY(-100%);
    opacity: 100%;
  }
  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
    opacity: 100%;
  }
}
</style>
