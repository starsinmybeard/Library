<template>
    <div class="row">
        <div class="book-cover">
            <img v-bind:src="`https://covers.openlibrary.org/b/isbn/${isbn}-L.jpg`" class="cover"/>
        </div>

        <div class="title-section">
                <h1>{{title}}</h1>
                <h3>by:</h3>
                <h2>{{author}}</h2>
        </div>

        <div class="purchase-section">
            <div id="price">
                <h4>Purchase Price:</h4>
                <h1>${{this.correctPrice}}</h1>
            </div>

            <div id="purchaseLocation">
                <h4>Purchased from: </h4>
                <h3>{{purchaseLocation}}</h3>
            </div>

            <div id="condition">
                <h4>Condition: <br>{{condition}}</h4>
            </div>
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
  
  <style scoped>
      .row{
          display: flex;
          flex-direction: row;
          width: 100%;
          background-color: #89abc6;
          border: 12px gold solid;
          align-items: center;
      }

      .row > div {
        display: flex;
        flex-direction: column;
        align-items: center;
        flex-wrap: wrap;
        text-align: center;
      }

      div > .title-section{
        width: 25%;
      }

  
      .book-details{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
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

      div#price h4{
        margin-bottom: -20px;
      }

      div#purchaseLocation h4{
        margin-bottom: -20px;
      }
      
      div#purchaseLocation h3{
        font-size: 30px;
      }
  </style>