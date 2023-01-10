<template class="container">
    <div class="book-details">
        <div id="title">
            <h1>{{title}}</h1>
        </div>

        <div id="author">
            <h2>By: {{author}}</h2>
        </div>
      
        <div id="price">
            <h4>Purchase Price: <br>${{this.formattedPurchasePrice}}</h4>
        </div>

        <div id="coverPrice">
            <h4>Cover Price: <br>${{this.formattedCoverPrice}}</h4>
        </div>

        <div id="purchaseLocation">
            <h4>Purchased from: <br>{{purchaseLocation}}</h4>
        </div>

        <div id="condition">
            <h4>Condition: <br>{{condition}}</h4>
        </div>

        <div id="notes">
            <p>Notes: <br>{{notes}}</p>
        </div>
      
    </div>
  </template>
  
  <script>
//   import BookService from '@/services/BookService';
  export default {
      name: "book-card-display",
      data(){
        return{
            formattedPurchasePrice:"",
            formattedCoverPrice:""
        }
      },
      props:[
          "title",
          "author",
          "price",
          "purchaseLocation",
          "condition",
          "notes",
          "isbn",
          "coverPrice"
      ],
      methods:{
        displayPurchasePrice(){
            this.formattedPurchasePrice = this.$props.price / 100;
        },
        displayCoverPrice(){
            this.formattedCoverPrice = this.$props.coverPrice / 100;
        }
      }, 
      created(){
       this.displayPurchasePrice();
      }
  }
  </script>
  
  <style>
      .container{
          display: flex;
          flex-direction: row;
          justify-content: space-evenly;
          align-items: center;
      }
  
      .book-details{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
          background-color: #89abc6;
          width: 25%;
          border: 12px gold solid;
          border-radius: 60px;
          margin-bottom: 5px;
          font-size: 20px;
          padding: 25px;
      }

      .cover{
          text-align: center;
          width: 272px;
          height: 412px;
      }
  </style>