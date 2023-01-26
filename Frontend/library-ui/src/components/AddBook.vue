<template>
    <div class="add-book-form">
        <form action="submit">
            <div class="form-component" id="isbn_container">
                <label for="isbn">isbn:</label>
                <input type="text" v-model="book.isbn" @keyup="getDetailsFromOpenLibrary">
                <button id="callbutton" @click.prevent="fillForm">auto-fill</button>
            </div>

            <div class="form-component">
                <label for="title">Book Title:</label>
                <input type="text" id="title" v-model="book.bookTitle">
            </div>

            <div class="form-component">
                <label for="subtitle">Subtitle:</label>
                <input type="text" id="subtitle" v-model="book.subtitle">
            </div>
    
            <div class="form-component">
                <label for="author">Author:</label>
                <input type="text" id="author" v-model="book.author">
            </div>

            <div class="form-component">
                <label for="genre">Genre:</label>
                    <select name="genre" v-model="book.genre">
                        <option value="Fiction">Fiction</option>
                        <option value="Non-Fiction">Non-Fiction</option>
                        <option value="Classics">Classics</option>
                        <option value="Humour">Humour</option>
                        <option value="Sci-Fi">Sci-Fi</option>
                        <option value="Fantasy">Fantast</option>
                        <option value="Philosophy">Philosophy</option>
                        <option value="Biography">Biography</option>
                        <option value="History">History</option>
                        <option value="Mystery">Mystery</option>
                        <option value="Horror">Horror</option>
                        <option value="Poetry">Poetry</option>
                        <option value="Science">Science</option>
                        <option value="Mythology">Mythology</option>
                        <option value="Anthology">Anthology</option>
                    </select>
            </div>

            <div class="form-component">
                <label for="genre">Condition:</label>
                    <select name="genre" v-model="book.condition">
                        <option value="New">New</option>
                        <option value="Like New">Like-New</option>
                        <option value="Excellent">Excellent</option>
                        <option value="Great">Great</option>
                        <option value="Very-Good">Very-Good</option>
                        <option value="Good">Good</option>
                        <option value="Solid">Solid</option>
                        <option value="Decent">Decent</option>
                        <option value="Okay">Okay</option>
                        <option value="Acceptable">Acceptable</option>
                    </select>
            </div>

            <div class="form-component">
                <label for="purchaseLocation">Purchased at:</label>
                <input type="text" list="location" v-model="book.purchaseLocation">
                <datalist id="location">
                    <option value="">--place of purchase--</option>
                    <option value="Garland County Library Bookstore">Garland County Library Bookstore</option>
                    <option value="Habitat for Humanity Re-Store">Habitat for Humanity Re-Store</option>
                    <option value="Ebay">Ebay</option>
                    <option value="Amazon">Amazon</option>
                    <option value="Barnes & Noble">Barnes & Noble</option>
                    <option value="Gift/Present">Gift/Present</option>
                    <option value="Bought for School/Class">Bought for School/Class</option>
                </datalist>
            </div>

            <div class="form-component">
                <label for="price">Price:</label>
                <input type="text" list="price" v-model.number="priceBeforeConversion">
                    <datalist id="price">
                        <option value=".25">.25</option>
                        <option value=".50">.50</option>
                        <option value="1.00">1.00</option>
                        <option value="2.00">2.00</option>
                        <option value="3.00">3.00</option>
                    </datalist>
            </div>

            <div class="form-component">
                <label for="coverPrice">Price on Back Cover:</label>
                <input type="text" list="coverPrice" v-model.number="coverPriceBeforeConversion">
            </div>

            <div class="form-component">
                <label for="hardcoverOrSoftcover">Hardcover or Softcover:</label>
                <select id="location" v-model="book.format">
                    <option value="">--format--</option>
                    <option value="Hardcover">Hardcover</option>
                    <option value="Softcover">Paperback</option>
                </select>
            </div>

            <div class="form-component">
                <label for="purchase_date">Purchase date:</label>
                <input type="date" v-model="book.purchaseDate" id="date" name="purchase_date"
                    min="2020-01-01" max="2025-12-31">
            </div>

            <!-- <div class="form-component">
                <label for="isbn">isbn:</label>
                <input type="text" v-model="book.isbn" @keyup="getDetailsFromOpenLibrary">
            </div> -->

            <div class="form-component">
                <label for="read_status">Read status:</label>
                    <select name="read" v-model="book.readStatus">
                        <option value="Read">Read</option>
                        <option value="Haven't Read Yet" >Haven't Read Yet!</option>
                    </select>
            </div>

            <div class="form-component">
                <label for="notes">Notes:</label>
                <textarea name="notes" cols="60" rows="10" v-model="book.notes" placeholder="add notes here if you wish!"></textarea>
            </div>

            <div class="submit-button">
                <button v-on:click.prevent="convertPrice(), addBookToDB()">submit</button>
            </div>

            
        </form>
    </div>
</template>

<script>
import BookService from '@/services/BookService';
import OpenLibrary from '@/services/OpenLibrary';
import GoogleBooksService from '@/services/GoogleBooksService';
export default {
    name:"add-book",
    data(){
        return{
            priceBeforeConversion:"",
            coverPriceBeforeConversion:"",
            book:{
                bookTitle: '',
                subtitle:'',
                author:'',
                genre:'',
                isbn:'',
                condition:'',
                price:'',
                coverPrice:'',
                format: '',
                purchaseLocation:'',
                purchaseDate:'',
                readStatus:'',
                notes:'',
                pageCount:'',
                edition: '',
                publishDate:'',
            },
            openLibraryBook: [],
            googleBookCall: [],
            authorInfo:[],
        }
    },
    methods:{ 
        getDetailsFromOpenLibrary(){
          console.log("line 50");
          OpenLibrary.getBookInfo(this.book.isbn).then((response) => 
          this.openLibraryBook = response.data);
        },
        addBookToDB(){
            console.log(this.book);
            BookService.addBook(this.book);
        }, 
        fillForm(){
            console.log(this.book.isbn);
            GoogleBooksService.getBookDetails(this.book.isbn).then((response) => 
            this.googleBookCall = (response.data.items));
            // OpenLibrary.getAuthorInfo(this.openLibraryBook.authors.key).then((response) => 
            // this.authorInfo = response.data);


            // this.book.bookTitle = this.openLibraryBook.title;
            // this.book.author = this.openLibraryBook.author;
            // this.book.coverPrice
            // this.book.format
            // this.book.purchaseLocation
            // this.book.purchaseDate
            // this.book.readStatus
            // this.book.pageCount = this.openLibraryBook.number_of_pages;
            // this.book.edition = this.openLibraryBook.edition_name;
            // this.book.publishDate = this.openLibraryBook.publish_date;
        },
        convertPrice(){
            this.book.price = this.priceBeforeConversion * 100;
            this.book.coverPrice = this.coverPriceBeforeConversion * 100;
        }
    }, 
    created(){ 
    }
    
}

</script>

<style scoped>
    .add-book-form{
        display: flex;
        justify-content: center;
    }

    #isbn_container{
        display: flex;
        flex-direction: column;
        margin-bottom: 10px;
    }

    #callbutton{
        margin-top: 5px;
        align-self: flex-end;  
    }

    div.form-component {
        margin-top: 10px;
    }
    div.form-component > label {
        display: block;
    }

    button{
        width:100px;
        text-align: center;
        padding: 3px;
    }

    .submit-button{
        display: flex;
        margin-top: 10px;
        margin-bottom: 20px;
        justify-content: center;
        padding: 10px;

    }
    





    /* div.form-component > input,
    div.form-component > select {
        height: 30px;
        width: 300px;
    }

    div.form-component > textarea {
        height: 60px;
        width: 300px;
    }
    form > input[type="button"] {
        width: 100px;
    }
    form > input[type="submit"] {
        width: 100px;
        margin-right: 10px;
    } */
</style>