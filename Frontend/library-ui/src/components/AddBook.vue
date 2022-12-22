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
                    </select>
            </div>

            <div class="form-component">
                <label for="genre">Condition:</label>
                    <select name="genre" v-model="book.condition">
                        <option value="New">New</option>
                        <option value="Like New">Like-New</option>
                        <option value="Amazing">Excellent</option>
                        <option value="Good">Good</option>
                        <option value="Solid">Solid</option>
                        <option value="Decent">Decent</option>
                        <option value="Okay">Okay</option>
                        <option value="Acceptable">Acceptable</option>
                    </select>
            </div>

            <div class="form-component">
                <label for="purchaseLocation">Purchased at:</label>
                <select id="location">
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
                <input type="text" list="price" v-model.number="book.price">
                    <datalist id="price">
                        <option value="$0.25"></option>
                        <option value="$.50"></option>
                        <option value="$1.00"></option>
                        <option value="$2.00"></option>
                        <option value="$3.00"></option>
                    </datalist>
            </div>

            <div class="form-component">
                <label for="hardcoverOrSoftcover">Hardcover or Softcover:</label>
                <select id="location" v-model="book.format">
                    <option value="">--format--</option>
                    <option value="Hardcover">Hardcover</option>
                    <option value="Softcover">Softcover</option>
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
                        <option value="Haven't Read Yet">Haven't Read Yet</option>
                    </select>
            </div>

            <div class="form-component">
                <textarea name="notes" cols="60" rows="10" v-model="book.notes"></textarea>
            </div>

            <div class="form-component">
                <input type="checkbox" name="read_status" value="Read" v-model="book.read_status" />
            </div>

            <button v-on:click.prevent="addBookToDB()">submit</button>
        </form>
    </div>
</template>

<script>
import BookService from '@/services/BookService';
export default {
    name:"add-book",
    data(){
        return{
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