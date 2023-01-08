<template class="container">
    <div class="book-card">
        <div class="book-cover"> 
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${this.$store.state.book.isbn}-L.jpg`"/>
        </div>

        <div class="book-details">
            <div id="title"><h1>{{this.$store.state.book.bookTitle}}</h1></div>
            <div id="author"><h2>By: {{this.$store.state.book.author}}</h2> </div>
            <div id="format"><h2>Format: {{this.$store.state.book.format}}</h2> </div>
            <div id="genre"><h2>Genre: {{this.$store.state.book.genre}}</h2> </div>
            <div id="date"><h2>Purchase Date: {{this.$store.state.book.purchaseDate}}</h2> </div>
            <div id="price"> <h4>Purchase Price: ${{this.$store.state.book.price / 100}}</h4> </div>
            <div id="coverPrice"> <h4>Cover Price: ${{this.$store.state.book.coverPrice / 100}}</h4> </div>
            <div id="purchaseLocation"> <h4>Purchased from: {{this.$store.state.book.purchaseLocation}}</h4></div>
            <div id="condition"><h4>Condition: {{this.$store.state.book.condition}}</h4></div>
            <div id="notes"><h4>Notes: <br>{{this.$store.state.book.notes}}</h4></div>
        </div>

    </div>
    
  </template>
  

  <script>
  import BookService from '@/services/BookService';
  import OpenLibrary from '@/services/OpenLibrary';
  export default {
      name: "book-card-display",
      data(){
        return{
            book:[],
            openLibraryBook: [],
            openLibraryAuthor:[],
        }
        
      },
      methods:{
        getBook(){
            BookService.getBook(this.$route.params.bookId).then((response) => 
            this.$store.commit("GET_BOOK", response.data));
            this.book = this.$store.state.book;
        },
        getDetailsFromOpenLibrary(){
          console.log("line 50");
          OpenLibrary.getBookInfo(this.book.isbn).then((response) => 
          this.openLibraryBook = response.data)
        },
        getAuthorDetails(){
          OpenLibrary.getAuthorInfo(this.openLibraryBook.author)
        }
      }, 
      created(){
        this.getBook();
        this.getDetailsFromOpenLibrary();
      }, 
  }
  </script>
  
  <style>
    
    .book-card{
        display: flex;
        flex-direction: row;
        justify-content: center;
        width: 100%;
    }
      .book-details{
        display: flex;
        flex-direction: column;
        
        background-color: #89abc6;
        border: 12px gold solid;
        border-radius: 60px;
        margin-bottom: 5px;
        font-size: 18px;
        text-align: end;
      }

      div > img{
          text-align: center;
          width: 544px;
          height: 824px;
      }
  </style>