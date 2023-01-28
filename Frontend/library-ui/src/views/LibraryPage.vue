<template>
    <div class="library-container">


        <div class="library-header">

            <div class="header-section" id="display-section">
                <div class="section-name"><h3>Display:</h3></div>
                <div class="section-options">
                    <button v-on:click="selectCoverDisplay()">Covers</button>
                    <button v-on:click="selectFullDetails()">List</button>
                    
                </div>
            </div>

            <div class="header-section" id="filter-section">
                <div class="section-name"><h3>Purchase Loctaion:</h3></div>
                <div class="section-options">
                    <div class="list-container">
                        <ul class="filter-list">
                            <li class="location-option">
                                <label for="Garland County Library Bookstore">
                                    <input type="checkbox" value="Garland County Library Bookstore" v-model="filteredPurchaseLocation">Garland County Library
                                </label>
                            </li>

                            <li class="location-option">
                                <label for="Ebay">
                                <input type="checkbox" value="Ebay" v-model="filteredPurchaseLocation">Ebay</label>
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
                        </ul
                        ></div></div></div>

            <div class="header-section" id="filter-section">
                <div class="section-name"><h3>Genre:</h3></div>
                <div class="section-options">
                    <div class="list-container">
                        <ul class="filter-list">
                            <li class="option">
                                <label for="Fiction">
                                <input type="checkbox" value="Fiction" v-model="filteredGenre">Fiction</label></li>
                            <li class="option">
                                <label for="Non-Fiction">
                                <input type="checkbox" value="Non-Fiction" v-model="filteredGenre">Non-Fiction</label></li>
                        </ul>
                    </div></div></div>

            <div class="header-section" id="search-section">
                <div class="searchbar">
                    <input type="text" placeholder="search library" name="search"  v-model="this.search"/>
                    <button for="search">search</button></div>
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
            filteredGenre: []
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
        filteredBooks(){
            let newList = this.$store.state.books;
            if(this.search.length > 0){
                return newList.filter( book => {
                    return book.bookTitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1  || 
                    book.author.toLowerCase().indexOf(this.search.toLowerCase()) > -1
                });
            }
            else if(this.filteredGenre.length > 0){
                return newList.filter(book => this.filteredGenre.includes(book.genre))
            } else if(this.filteredPurchaseLocation.length <= 0){
                return newList;
            } else {
                return newList.filter(book => this.filteredPurchaseLocation.includes(book.purchaseLocation));
            }
        }
    }
}
</script>

<style scoped>

    .library-container{
        width: 100%;
        height: 100vh;
    }
    .library-header{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;
        margin-right: 10px;
        gap: 10px;
    }


    .header-section{
        display: flex;
        flex-direction: row;
        /* border: 3px solid black; */
        width: auto;
        height: 40px;
        justify-content: center;
        align-items: center;
    }

    .section-options{
        margin-left: 10px;
        display: flex;
        flex-direction: row;
    }

    button{
        margin: 1px;
        font-size: 12px;
    }

    ul{
        display: block;
        list-style-type: disc;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        padding-inline-start: 0px;
    }

    li{
        display: inline;
        margin-right: 10px;
    }

    label{
        display: inline-block;
        vertical-align: middle;
        font-size: 12px;
    }

    input{
        vertical-align: middle;
        text-align: center;
    }

    .filter-list{
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
        margin: 1em;
    }

    .cover-card{
        margin-bottom: 20px;
        margin: 5px;
    }

    button:hover{
        cursor: pointer;
    }

    h3{
        display: block;
        font-size: 1em;
        margin-block-start: .1em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
    }
</style>
