import { createStore } from 'vuex'

export default createStore({
  state: {
    books:[],
    book:[],
  },
  getters: {

  },
  mutations: {
    GET_BOOKS(state, data){
      state.books = data;
    },
    GET_BOOK(state, data){
      state.book = data;
    }
  },
  actions: {
  },
  modules: {
  }
})
