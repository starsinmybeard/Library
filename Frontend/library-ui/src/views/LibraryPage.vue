<template>
    <div class="library-container1">
        <div class="library-header">
            <h6>Display Options:</h6>
            <button v-on:click="selectFullDetails()">Full Details Display</button>
            <button v-on:click="selectCoverDisplay()">Cover Display</button>
        </div>

        <div class="cover-display" v-if="coverDisplay">
            <book-cover-card 
                v-for="book in $store.state.books" 
                v-bind:key="book.bookId" 
                :isbn="book.isbn" 
                class="cover-card"
                v-on:click="goToBook(book.bookId)"
                ></book-cover-card>
        </div>

        <div class="full-details-display" v-if="fullDetailsDisplay">
            <book-card v-for="book in $store.state.books" 
                v-bind:key="book.bookId" 
                :title="book.bookTitle"
                :author="book.author"
                :price="book.price"
                :purchaseLocation="book.purchaseLocation"
                :condition="book.condition"
                :notes="book.notes"
                :isbn="book.isbn" >
            </book-card>
        </div>

    </div>
</template>


<script>
import BookCard from "../components/BookCard.vue";
import BookCoverCard from "../components/BookCoverCard.vue";
import BookService from "../services/BookService.js";
export default {
    name: "libraryDisplay",
    data(){
        return{
            fullDetailsDisplay : false,
            coverDisplay : true
        }
    },
    components: {
        BookCard, BookCoverCard,
    },
    methods: {
        getBooksFromDB(){
            BookService.getAllBooks().then((response) => 
            this.$store.commit("GET_BOOKS", response.data))
        },
        selectFullDetails(){
            this.coverDisplay = false;
            this.fullDetailsDisplay = true;
        },
        selectCoverDisplay(){
            this.fullDetailsDisplay = false,
            this.coverDisplay = true;
        },
        goToBook(bookId){
            BookService.getBook(bookId);
            this.$router.push({ name: "Book", params: {bookId} })
        }
    },
    created(){
        this.getBooksFromDB();
    }
}
</script>


<style>
    .full-details-display{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: stretch;
    }

    .cover-display{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        margin: 1em 
    }

    .cover-card{
        margin-bottom: 20px;
    }
</style>
