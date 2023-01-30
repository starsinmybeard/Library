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

            <div class="header-section" id="display-section">
                <div class="section-name"><h3>Sort:</h3></div>
                <div class="section-options">
                    <button v-on:click="selectCoverDisplay()">Title (A-Z)</button>
                    <button v-on:click="selectFullDetails()">Author (A-z)</button>
                </div>
            </div>

            <div class="header-section" id="filter-location">
                <div class="section-name"><h3>Filters:</h3></div>
                <div class="section-options">
                    <div class="list-container">
                        <div class="filter-dropdown">
                            <button class="filter-button">Purchase Location</button>
                            <div class="dropdown-content">
                                <ul class="filter-list">
                                    <li class="location-option">
                                        <label for="Garland County Library Bookstore">
                                            <input type="checkbox" value="Garland County Library Bookstore" v-model="filteredPurchaseLocation">Garland County Library</label></li>

                                    <li class="location-option">
                                        <label for="Ebay">
                                            <input type="checkbox" value="Ebay" v-model="filteredPurchaseLocation">Ebay</label></li>

                                    <li class="location-option">
                                        <label for="Amazon">
                                            <input type="checkbox" value="Amazon" v-model="filteredPurchaseLocation">Amazon</label> </li>

                                    <li class="location-option">
                                        <label for="Barnes & Noble">
                                        <input type="checkbox" v-model="filteredPurchaseLocation" value="Barnes & Noble">Barnes & Noble </label></li>

                                    <li class="location-option">
                                        <label for="Gift">
                                        <input type="checkbox" value="Gift" v-model="filteredPurchaseLocation">Gift </label></li>
                                </ul>
                             </div></div></div></div>
                <div class="section-options">
                    <div class="list-container">
                        <div class="filter-dropdown">
                            <button class="filter-button">Genre</button>
                            <div class="dropdown-content">
                                <ul class="filter-list">
                                    <li class="option">
                                        <label for="Fiction">
                                            <input type="checkbox" value="Fiction" v-model="filteredGenre">Fiction</label></li>
                                    <li class="option">
                                        <label for="Non-Fiction">
                                            <input type="checkbox" value="Non-Fiction" v-model="filteredGenre">Non-Fiction</label></li>
                                </ul>
                            </div></div></div></div>

                
            </div>

            
            <div class="header-section" id="search-section">
                <div class="searchbar">
                    <input type="text" placeholder="search library" name="search"  v-model="this.search"/>
                    <button for="search" id="search-button">search</button></div>
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
        height: 100%;
        background: linear-gradient( #ffffff,#dcceec, #dcceec, #c5b0e1 ,#c3a9e4, #ceb7eb, #c3a7e9);
        margin-top: 10px;
        overflow: scroll;
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
        font: inherit;
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
        margin-right: 5px;
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

    .searchbar{
        display: flex;
    }

    #search-button{
        padding-right: 10px;
        padding-left: 10px;
        margin-left: 3px;
    }


    button {
        background-color: #b88cf0;
        font-size: 1em;
    }

    /* The container <div> - needed to position the dropdown content */
    .filter-dropdown {
        position: relative;
        display: inline-block;
    }

    /* Dropdown Content (Hidden by Default) */
    .dropdown-content {
        position: absolute;
        display: none;
        min-width: 160px;
        background-color: #f9f9f9;
        z-index: 1;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    }

    
    /* Links inside the dropdown */
    .dropdown-content li {
        color: black;
        padding: 2px 2px;
        text-decoration: none;
        display: block;
    }

    /* Change color of dropdown links on hover */
    .dropdown-content li:hover {
        background-color: #f1f1f1
    }
        
    /* Show the dropdown menu on hover */
    .filter-dropdown:hover .dropdown-content {
        display: block;
    }

    /* Change the background color of the dropdown button when the dropdown content is shown */
    .filter-dropdown:hover .filter-button {
        background-color: #cebee2;
    }

    button:hover{
        background-color: #cebee2;
    }
</style>
