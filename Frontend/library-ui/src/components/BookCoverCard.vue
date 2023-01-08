<template class="container">
    <div>
        <div class="cover">
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${isbn}-L.jpg`" class="book"/>
        </div>
    </div>
  </template>
  
  <script>
//   import BookService from '@/services/BookService';
  export default {
      name: "book-cover-display",
      data(){
        return{correctPrice:""}
      },
      props:["isbn"],
  }
  </script>
  
  <style scoped>
      .book{
          text-align: center;
          width: 136px;
          height: 206px;
          box-shadow: 2px 2px 10px black;
      }
  </style>