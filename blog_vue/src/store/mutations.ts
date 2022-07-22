// \src\store\mutations.ts
import { MutationTree } from "vuex";
import { State } from "./state";
 
export const mutations: MutationTree<State> = {
  // 修改语言
  CHANGE_LANGUAGE(state, value: string) {
    state.language = value;
    sessionStorage.setItem("localeLang", value);
  },
};