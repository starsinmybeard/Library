<template class="container">
    <div class="book-card">

        <div class="book-cover"> 
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${this.$store.state.book.isbn}-L.jpg`"/>
        </div>

        <div class="book-details">

          <div class="detail" id="title"> 
            <h5>title:</h5>
            <h4>{{this.$store.state.book.bookTitle}}</h4>
          </div>

          <div class="detail" id="subtitle" v-if="(this.$store.state.book.subtitle != null)"> 
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
            <h5>purchased: </h5>
            <h4>{{this.$store.state.book.purchaseDate}}</h4>
          </div>

          <div class="detail" id="price">
            <h5>cover price:</h5>
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

          <div class="detail" id="notes" v-if="((this.$store.state.book.notes).length > 1)">
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
          OpenLibrary.getAuthorInfo(this.openLibraryBook.author)
        }
      }, 
      created(){
        this.getBook();
      }, 
  }
  </script>
  
  <style scoped> 

  .book-card{
    background: linear-gradient( rgb(255, 255, 255),  rgb(210, 205, 246),rgb(200, 192, 245), rgb(191, 182, 245), rgb(191, 182, 245));
  }

  
    
    .book-card{
      padding-top: 100px;
        display: flex;
        flex-direction: row;
        width: 100%;
        justify-content: space-evenly;
        height: 100vh;
    }
      .book-details{
        display: flex;
        flex-direction: column;
        font-size: 18px;
        align-items: flex-start;
        width: auto;
        height: 515px;
        justify-content: center;
        background-color: rgb(191, 182, 245);
        border: 3px solid purple;
        margin-left: -200px;
        padding-right: 10px;
        margin-bottom: 5px;
        box-shadow: 1px 1px 40px 1px black;
      }

      .book-cover{
        height: 520px;
      }

      .detail{
        display: flex;
        flex-direction: row;
        align-items: center;
        height: 50px;
        padding-left: 14px;
        background-color: rgb(191, 182, 245);
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
      }

      #edit-button{
        width: 99%;
        display: flex;
        justify-content: center;
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



</style>

