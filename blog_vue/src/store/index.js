import { createStore } from 'vuex'

export default createStore({
  state: {
    count: 1,
    num: 10,
    lang:'',
  },
  mutations: {
    increment (state) {
        state.count++
      },
      sum (state, num) {
        state.count += num
      },
      setLang(state,value){
          state.lang=value
        localStorage.setItem('lang',value)

      }
  },
  actions: {
  },
  modules: {
  }
})

