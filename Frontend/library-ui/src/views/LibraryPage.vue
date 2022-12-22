<template>
    <div class="book-diplay">
        <book-card v-for="book in this.$store.state.books" v-bind:key="book.title"></book-card>
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
        }
    },
    created(){
        this.getBooksFromDB();
    }
}
</script>



<style>
    .book-display{
        display: flex;
        font: 15px solid black;
    }
</style>
