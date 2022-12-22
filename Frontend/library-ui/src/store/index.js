import { createStore } from 'vuex'

export default createStore({
  state: {
    books:[],
  },
  getters: {

  },
  mutations: {
    GET_BOOKS(state, data){
      state.books = data;
    }
  },
  actions: {
  },
  modules: {
  }
})
