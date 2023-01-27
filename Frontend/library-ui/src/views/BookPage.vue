<template class="container">
    <!-- <div class="book-card">

        <div class="book-cover"> 
          <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${this.$store.state.book.isbn}-L.jpg`"/>
        </div>

        <div class="book-details">
          <div class="detail" id="title"> 
            <h1 class="book-title">{{ this.$store.state.book.bookTitle }}</h1>
            <h5>by:</h5>
            <h2 class="book-author">{{this.$store.state.book.author}}</h2>
          </div>

          <div class="detail" id="subtitle" v-if="(this.$store.state.book.subtitle)"> 
            <h5>subtitle:</h5>
            <h4>{{this.$store.state.book.subtitle}}</h4>
          </div>

          <div class="detail" id="author">
            <h5>author:</h5>
            <h4>{{this.$store.state.book.author}}</h4>
          </div>

          <div class="detail" id="format">
            <h5>format:</h5>
            <h4>{{this.$store.state.book.format}}</h4>
          </div>

          <div class="detail" id="genre">
            <h5>genre:</h5>
            <h4>{{this.$store.state.book.genre}}</h4>
          </div>

          <div class="detail" id="format">
            <h5>Date purchased: </h5>
            <h4>{{this.$store.state.book.purchaseDate}}</h4>
          </div>

          <div class="detail" id="price">
            <h5>Purchase price:</h5>
            <h4>${{this.$store.state.book.price / 100}}</h4>
          </div>

          <div class="detail" id="coverPrice">
            <h5>cover price:</h5>
            <h4>${{this.$store.state.book.coverPrice}}</h4>
          </div>

          <div class="detail" id="condition">
            <h5>condition:</h5>
            <h4>{{this.$store.state.book.condition}}</h4>
          </div>

          <div class="detail" id="notes" v-if="((this.$store.state.book.notes))">
            <h5>notes:</h5>
            <h6>{{this.$store.state.book.notes}}</h6>
          </div>

          <div class="detail" id="edit-button">
            <button v-on:click="editBook = !editBook">Edit Book</button>
            <button v-on:click="this.getDetailsFromOpenLibrary">See More Details</button>
          </div>

        
        </div>
        

        <div class="edit-book" v-if="editBook">
          <edit-book></edit-book>
        </div>

        
        

    </div> -->
    <div class="stats-page">
      <div class="cover-side">
        <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${this.$store.state.book.isbn}-L.jpg`"/>
      </div>

      <div class="info-side">
        <div class="stats-card">

          <h1 class="title">
            {{ this.$store.state.book.bookTitle }}
          </h1>

          <h2 class="subtitle" v-if="(this.$store.state.book.subtitle)">{{this.$store.state.book.subtitle}}</h2>
    
          <h4>by:</h4>
          <h2 class="book-author">{{this.$store.state.book.author}}</h2>
          <h1>cover price</h1> <h3 class="price">{{this.$store.state.book.price /100}}</h3>



        </div>
        
      </div>

    </div>


    <div class="edit-book" v-if="editBook">
          <edit-book></edit-book>
    </div>
    
  </template>
  

  <script>
  import BookService from '@/services/BookService';
  import OpenLibrary from '@/services/OpenLibrary';
  import EditBook from '../components/EditBook.vue'
  export default {
      name: "book-card-display",
      data(){
        return{
            book:[],
            openLibraryBook: [],
            openLibraryAuthor:[],
            editBook : false,
        }
        
      },
      components:{
        EditBook
      },
      methods:{
        getBook(){
            BookService.getBook(this.$route.params.bookId).then((response) => 
            this.$store.commit("GET_BOOK", response.data));
            this.book = this.$store.state.book;
        },
        getDetailsFromOpenLibrary(){
          OpenLibrary.getBookInfo(this.$store.state.book.isbn).then((response) => 
          this.openLibraryBook = response.data)
        },
        getAuthorDetails(){
          OpenLibrary.getAuthorInfo(this.book.author)
        }
      }, 
      created(){
        this.getBook();
        this.getAuthorDetails();
      }, 
  }
  </script>
  
  <style scoped> 

  .book-card{
    background: linear-gradient( rgb(255, 255, 255),  rgb(210, 205, 246),rgb(200, 192, 245), rgb(191, 182, 245), rgb(191, 182, 245));
  }

  
    
    /* .book-card{
      width: 100%;
      height: 100vh;
      padding-top: 100px;
      display: flex;
      flex-direction: row;
      justify-content: space-evenly;
      border: 50px solid purple;
    }

      .book-details{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        font-size: 18px;
        height: auto;
        width: 400px;
        background-color: rgb(191, 182, 245);
        border: 10px solid blue;
        box-shadow: 1px 1px 40px 1px black;
      }

      .book-cover{
        height: 520px;
      }

      .detail{
        display: flex;
        flex-direction: row;
        align-items: center;
        height: auto;
        padding-left: 14px;
        background-color: rgb(191, 182, 245);
        border: 1px solid yellow;
      }

      div > img{
        text-align: center;
        width: 340px;
        height: 515px;
        box-shadow: 1px 1px 40px 1px black;
      }

      .edit-book{
        position: absolute;
        background:  white;
        border: 2px solid orange;
        scale: 75%;
      }

      h5{
        margin-right: 10px;
        text-decoration: underline;
      }

      h4, h5, h6, h3{
        background-color: rgb(191, 182, 245);
        margin: 10px;
      }

      #edit-button{
        width: 100%;
        display: flex;
        justify-content: center;
        padding-left: 0px;
      }

      button{
        color: black;
        background-color: rgb(244, 244, 171);
        border: 2px solid purple;
        margin-right: 10px;
        border-radius: 31px;
        transition : 0ms;
        transform: translateY(0);
        display: flex;
        flex-direction: row;
        align-items: center;
        cursor: pointer;
        
      }

      button:hover{
        transition : 0ms;
        padding: 10px 16px;
        transform : translateY(-0px);
        background-color: purple;
        color: white;
        border: solid 2px rgb(234, 234, 55);
      }

      #title.detail{
        display: flex;
        flex-direction: column;
        padding-left: 0px;
        align-items: center;
      }

      h1{
        display: block;
        font-size: 2em;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
        border: 1px solid red;
      } */



      .stats-page{
        width: 100%;
        height: 100vh;
        display: flex;
        flex-direction: row;
        border: 2px solid black;
      }

      .stats-page > div {
        width: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
      }


      .cover-side{
        border: 2px solid blue;
      }

      .info-side{
        border: 2px solid red;
      }

      .stats-card{
        display: flex;
        flex-direction: column;
        width: 100%;
        border: 1px solid yellow;

        box-shadow: 1px 1px 40px 1px black;
      }

      .title{
        text-align: center;
        font-size: 4em;
        border: 1px solid red;

        display: block;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
      }

      .subtitle{
        text-align: center;
        font-size: 2em;
        font-style: italic;
        border: 1px solid white;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        margin-top: 0em;
      }

      .author{

      }

      div > img{
        width: 340px;
        height: 515px;
        box-shadow: 1px 1px 40px 1px black;
      }

      

</style>

