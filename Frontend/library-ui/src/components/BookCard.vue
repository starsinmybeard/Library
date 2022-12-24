<template class="container">
    <div class="book-details">
        
        <div id="title">
            <h1>{{title}}</h1>
        </div>

        <div id="author">
            <h2>By: {{author}}</h2>
        </div>
      
        <div class="book-cover">
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${isbn}-L.jpg`"/>
        </div>

        <div id="price">
            <h4>Purchase Price: <br>${{this.correctPrice}}</h4>
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
            correctPrice:""
        }
      },
      props:[
          "title",
          "author",
          "price",
          "purchaseLocation",
          "condition",
          "notes",
          "isbn"
      ],
      methods:{
        displayPrice(){
            this.correctPrice = this.$props.price / 100;
        }
      }, 
      created(){
       this.displayPrice();
      }
  }
  </script>
  
  <style>
      .container{
          display: flex;
          flex-direction: row;
          justify-content: space-evenly;
      }
  
      .book-details{
          justify-content: space-between;
          text-align: center;
          background-color: #89abc6;
          width: 25%;
          border: 12px gold solid;
          border-radius: 60px;
          margin-bottom: 5px;
          font-size: 20px;
          padding: 25px;
      }

      div > img{
          text-align: center;
          width: 272px;
          height: 412px;
      }
  </style>