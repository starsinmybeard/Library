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
          <div class="book-detail" id="title">
            <h1>{{ this.$store.state.book.bookTitle }}</h1>
              <h2 v-if="this.$store.state.book.subtitle">{{ this.$store.state.book.subtitle }}</h2>
                <h6>by</h6>
                  <h2>{{ this.$store.state.book.author }}</h2>
          </div>

          <div class="book-detail">
            <h3>Pages:</h3>
            <h2> &nbsp;{{ this.$store.state.book.pages}}</h2>
          </div>

          <div class="book-detail">
            <h3>Purchase Price:</h3>
            <h2> &nbsp;${{ this.$store.state.book.price /100}}</h2>
          </div>

          <div class="book-detail">
            <h3>Price on cover:</h3>
            <h2> &nbsp;${{ this.$store.state.book.coverPrice /100}}</h2>
          </div>

          <div class="book-detail">
            <h3>Place of purchase:</h3>
            <h2> &nbsp;{{ this.$store.state.book.purchaseLocation}}</h2>
          </div>

          <div class="book-detail">
            <h3>isbn:</h3>
            <h2> &nbsp;{{ this.$store.state.book.isbn}}</h2>
          </div>
          
          <div class="book-detail"></div>
          <div class="book-detail"></div>
          <div class="book-detail"></div>
          <div class="book-detail"></div>
          <div class="book-detail"></div>
          <div class="book-detail"></div>
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
   .stats-page{
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: row;
        align-items: flex-start;
        margin-top: 10px;
        padding-top: 100px;
        padding-bottom: 200px;
        background: linear-gradient( #ffffff, #e9e5ef, #ccbbe3 ,#c3a9e4, #ceb7eb, #c3a7e9);
      }

      .stats-page > div {
        width: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .cover-side{
      }

      .info-side{
       
      }

      .stats-card{
        display: flex;
        flex-direction: column;
        width: 80%;
        box-shadow: 1px 1px 20px 2px black;
        background: inherit;
        padding: 20px;
      }

      .stats-card > div {
        display: flex;
        flex-direction: row;
        align-items: center;
      }

      #title{
        flex-direction: column;
        align-items: center;
      }

      h1{
        text-align: center;
        font-size: 3em;
        display: block;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
      }

      h2{
        display: block;
        font-size: 1.6em;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
      }

      h6{
        display: block;
        font-size: 1em;
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

      .edit-book{
        position: absolute;
        flex-wrap: wrap;
        height: auto;
        background-color: white;
        margin-top: 20px;
        padding: 20px;
        border: 12px solid black;
        backdrop-filter: blur(500px);
      }
      

      

</style>

