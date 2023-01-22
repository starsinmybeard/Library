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
                                <input type="checkbox" value="Garland County Library Bookstore" v-model="filteredPurchaseLocation">Garland County Library Bookstore
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Ebay">
                                <input type="checkbox" value="Ebay" v-model="filteredPurchaseLocation">Ebay
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Amazon">
                                <input type="checkbox" value="Amazon" v-model="filteredPurchaseLocation">Amazon
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Barnes & Noble">
                                <input type="checkbox" v-model="filteredPurchaseLocation" value="Barnes & Noble">Barnes & Noble
                            </label>
                        </li>

                        <li class="location-option">
                            <label for="Gift">
                                <input type="checkbox" value="Gift" v-model="filteredPurchaseLocation">Gift
                            </label>
                        </li>
                    </ul>
                </div>  
            <div class="searchbar">
                <input type="text" placeholder="search books" name="search"  v-model="search"/>
                <label for="search">search books</label>
                
                
            </div>
            
        </div>

        <div class="cover-display" v-if="coverDisplay">
            <book-cover-card 
                v-for="book in filteredBooks" 
                v-bind:key="book.bookId" 
                :isbn="book.isbn" 
                class="cover-card"
                v-on:click="goToBook(book.bookId)"
                ></book-cover-card>
        </div>

        <div class="full-details-display" v-if="fullDetailsDisplay">
            <library-column-display v-for="book in filteredBooks" 
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
            search:'',
            fullDetailsDisplay : false,
            coverDisplay : true,
            filteredPurchaseLocation : [],
            filteredList : []
        }
    },
    components: {
        BookCoverCard, LibraryColumnDisplay
    },
    methods: {
        getBooksFromDB(){
            console.log("97");
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
        filterBooksByPurchaseLocation(){

        },
        filterBooksByPrice(){

        },
        filterBooksByCondition(){

        },
        filterBooksByGenre(){

        },
    },
    created(){
        this.getBooksFromDB();
       
    },
    computed:{
        searchList(){
            this.filteredList == this.$store.state.books;
             console.log("Line 133")
             return this.filteredList.filter((book) => {
                return book.includes.toLowerCase().includes(this.search.toLowerCase())
             });
        },
        filteredBooks(){
            console.log("139")
            let newList = this.$store.state.books;
            if(this.search.length > 0){
                return newList.filter( book => {
                    return book.title.toLowerCase.indexOf(this.search.toLowerCase) != -1;
                })
            }
             else if(this.filteredPurchaseLocation.length <= 0){
                console.log("Line 141");
                return newList;
            } else {
                console.log("Line 144");
                return newList.filter(book => this.filteredPurchaseLocation.includes(book.purchaseLocation));
            }
        }
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
