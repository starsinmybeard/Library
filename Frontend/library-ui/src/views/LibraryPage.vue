<template>
    <div class="book-diplay">
        <book-card v-for="book in this.$store.state.books" v-bind:key="book.bookID"></book-card>
    
    </div>
</template>



<script>
import BookCard from "../components/BookCard.vue";
export default {
    name: "libraryDisplay",
    components: {
        BookCard
    }
}
</script>



<style>
    .book-display{
        display: flex;
        font: 15px solid black;
    }
</style>
