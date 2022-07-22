// \src\store\state.ts
export type State = {
    language: string;
  };
   
  export const state: State = {
    language: sessionStorage.getItem("localeLang") || "zhCn",
  };