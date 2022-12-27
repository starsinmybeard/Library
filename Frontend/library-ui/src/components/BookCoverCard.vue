<template class="container">
    <div class="book">
        <div class="cover">
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${isbn}-L.jpg`"/>
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
  
  <style>
      .book{
          text-align: center;
          width: 272px;
          height: 412px;
          box-shadow: 2px 2px 10px black;
      }

      div > img{
          text-align: center;
          width: 272px;
          height: 412px;
      }
  </style>