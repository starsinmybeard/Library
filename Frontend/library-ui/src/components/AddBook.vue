<template>
    <div class="add-book-form">
        <form action="submit">
            <div class="form-component">
                <label for="title">Book Title:</label>
                <input type="text" id="title" v-model="book.bookTitle">
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
                <select id="location" v-model="book.purchaseLocation">
                    <option value="">--place of purchase--</option>
                    <option value="Garland County Library Bookstore">Garland County Library Bookstore</option>
                    <option value="Habitat for Humanity Re-Store">Habitat for Humanity Re-Store</option>
                    <option value="Ebay">Ebay</option>
                    <option value="Amazon">Amazon</option>
                    <option value="Barnes & Noble">Barnes & Noble</option>
                    <option value="Gift/Present">Gift/Present</option>
                </select>
            </div>

            <div class="form-component">
                <label for="price">Price:</label>
                <input type="text" list="price" v-model.number="priceBeforeCoversion">
                    <datalist id="price">
                        <option value=".25">$.25</option>
                        <option value=".50">$.50</option>
                        <option value="1.00">$1.00</option>
                        <option value="2.00">$2.00</option>
                        <option value="3.00">$3.00</option>
                    </datalist>
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

            <div class="form-component">
                <label for="isbn">isbn:</label>
                <input type="text" v-model="book.isbn">
            </div>

            <div class="form-component">
                <label for="read_status">Read status:</label>
                    <select name="read" v-model="book.readStatus">
                        <option value="Read">Read</option>
                        <option value="Haven't Read Yet">Haven't Read Yet!</option>
                    </select>
            </div>

            <div class="form-component">
                <textarea name="notes" cols="60" rows="10" v-model="book.notes"></textarea>
            </div>

            <button v-on:click.prevent="convertPrice(), addBookToDB()">submit</button>
        </form>
    </div>
</template>

<script>
import BookService from '@/services/BookService';
export default {
    name:"add-book",
    data(){
        return{
            priceBeforeCoversion:"",
            book:{
                bookTitle: '',
                author:'',
                genre:'',
                isbn:'',
                condition:'',
                price:'',
                format: '',
                purchaseLocation:'',
                purchaseDate:'',
                readStatus:'',
                notes:''
            }
        }
    },
    methods:{ 
        addBookToDB(){
            BookService.addBook(this.book);
        }, 
        convertPrice(){
            this.book.price = this.priceBeforeCoversion * 100;
        }
    }
}

</script>

<style>
    .add-book-form{
        display: flex;
        justify-content: center;
    }
    .card-container{
        display: flex;
        flex-direction: column;
    }

    .exit-button{
        display: flex;
        flex-direction: row;
        align-content: flex-end;
    }

    div.form-component {
        margin-top: 10px;
    }
    div.form-component > label {
        display: block;
    }

    div.form-component > input,
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
    }
</style>