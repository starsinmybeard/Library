<template>
    <div class="library-container">
        <div class="library-header">
            <h3>Display Options:</h3>
            <button v-on:click="selectFullDetails()">Full Details Display</button>
            <button v-on:click="selectCoverDisplay()">Cover Display</button>
            <h3>Filter Options:</h3>
                <div class="location-filter">
                    <ul class="location-list">
                        <li class="location-option">
                            <label for="Garland County Library Bookstore">
                                <input type="checkbox" :checked="filterBooks('GarlandCounty')">Garland County Library Bookstore
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Ebay">
                                <input type="checkbox" :checked="filterBooks('Ebay')">Ebay
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Amazon">
                                <input type="checkbox" :checked="filterBooks('Amazon')">Amazon
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Barnes & Noble">
                                <input type="checkbox" :checked="filterBooks('Barnes & Noble')">Barnes & Noble
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Gift">
                                <input type="checkbox" :checked="filterBooks('Gift')">Gift
                            </label>
                        </li>
                    </ul>
                </div>  
            <div class="searchbar">
                <label for="search">search books</label>
                <input type="text" placeholder="search books" name="search">
                
            </div>
            
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
            <library-column-display v-for="book in $store.state.books" 
                v-bind:key="book.bookId" 
                :title="book.bookTitle"
                :author="book.author"
                :price="book.price"
                :purchaseLocation="book.purchaseLocation"
                :condition="book.condition"
                :notes="book.notes"
                :isbn="book.isbn"></library-column-display>
        </div>

    </div>
</template>


<script>
// import BookCard from "../components/BookCard.vue";
import BookCoverCard from "../components/BookCoverCard.vue";
import BookService from "../services/BookService.js";
import LibraryColumnDisplay from "../components/LibraryColumnDisplay.vue";
export default {
    name: "libraryDisplay",
    data(){
        return{
            fullDetailsDisplay : false,
            coverDisplay : true
        }
    },
    components: {
        BookCoverCard, LibraryColumnDisplay
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
        },
        filterBooks(option){

            if(option === 'GarlandCounty'){
                BookService.boughtFromGarlandCounty().then((response) => 
                this.$store.commit("GET_BOOKS", response.data));

            } else if(option === 'Ebay'){
                BookService.boughtFromEbay().then((response) => 
                this.$store.commit("GET_BOOKS", response.data));

            } else if(option === 'Amazon'){
                BookService.boughtFromAmazon().then((response) => 
                this.$store.commit("GET_BOOKS", response.data));
            }

        }

    },
    created(){
        this.getBooksFromDB();
    }
}
</script>


<style scoped>

    .library-container{
        width: 100%;
    }
    .library-header{
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        margin-right: 10px;
        gap: 10px;
    }

    .location-list{
        list-style: none;
    }

    .library-header > button{
        font-family: 'Coming Soon', cursive;
        width: 150px;
    }

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
        margin: 5px;
    }

    button:hover{
        cursor: pointer;
    }
</style>
