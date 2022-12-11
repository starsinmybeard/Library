<template class="container">
    <div class="book">
  
      <h1>{{title}}</h1>
      <h2>{{author}}</h2>
      <h4>{{price}}</h4>
      <h4>{{purchaseLocation}}</h4>
      <h4>{{condition}}</h4>
      <div class="book-cover"><img src="../../test-pictures/beartown-cover.jpg" /></div>
      <p>{{notes}}</p>
  
  
    </div>
  </template>
  
  <script>
  export default {
      name: "book-card-display",
      data(){
          return{
              title: 'Beartown',
              author: 'Frederik Backman',
              notes: 'Top tier sports book.',
              price: 2,
              purchaseLocation: 'Garland County Library',
              condition: 'Like-New'
          }
      }
  
  }
  </script>
  
  <style>
      .container{
          display: flex;
          flex-direction: row;
          justify-content: space-evenly;
          
      }
  
  
      .book{
          justify-content: space-between;
          text-align: center;
          background-color: #89abc6;
          width: 25%;
          border: 12px gold solid;
          border-radius: 60px;
          margin-bottom: 5px;
          font-size: 20px;
      }
  
      div > img{
          text-align: center;
          scale: 75%;
      }
  
  </style>