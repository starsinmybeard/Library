<template>
    <div class="book-display">
        <book-card v-for="book in $store.state.books" 
         v-bind:key="book.bookId" 
         :title="book.bookTitle"
         :author="book.author"
         :price="book.price"
         :purchaseLocation="book.purchaseLocation"
         :condition="book.condition"
         :notes="book.notes"
         :isbn="book.isbn" 
         ></book-card>
    </div>
</template>


<script>
import BookCard from "../components/BookCard.vue";
import BookService from "../services/BookService.js";
export default {
    name: "libraryDisplay",
    components: {
        BookCard, 
    },
    methods: {
        getBooksFromDB(){
            BookService.getAllBooks().then((response) => 
            this.$store.commit("GET_BOOKS", response.data))
        },
    },
    created(){
        this.getBooksFromDB();
    }
}
</script>



<style>
    .book-display{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: stretch;
    }
</style>
