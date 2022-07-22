<!-- \src\components\MyHeader.vue -->
<template>
  <div class="header">
    <el-dropdown @command="handleCommand">
      <span class="el-dropdown-link">
        {{ langType[language] }}
        <el-icon class="el-icon--right">
          <arrow-down />
        </el-icon>
      </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item command="zhCn">中文</el-dropdown-item>
          <el-dropdown-item command="en">English</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>
 
<script lang="ts" setup name="MyHeader">
import { computed } from "@vue/runtime-core";
import { useStore } from "vuex";
import { langType } from "@/enum/options";
import { useI18n } from "vue-i18n";
 
const store = useStore();
// 改变语言
const language = computed(() => store.state.language);
const { locale } = useI18n();
const handleCommand = (value: string) => {
  locale.value = value;
  store.commit("CHANGE_LANGUAGE", value);
};
</script>
 
<style lang="less">
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}
</style>