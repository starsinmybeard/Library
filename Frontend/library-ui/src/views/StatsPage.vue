<template>
  <div class="container">
    <div class="card">
      <div class="description"><h4>Total number of books</h4></div>
      <div class="stat">{{ totalBooks }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Number of Hard-Covers:</h4></div>
      <div class="stat">{{ hardcoverCount }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Average Book Price:</h4></div>
      <div class="stat">$1{{ averageCost }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Money Saved buying used:</h4></div>
      <div class="stat">${{ moneySaved }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Most Expensive Book:</h4></div>
      <div class="stat">{{ mostExpensive }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Number of Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>

    

    <!-- <div class="profile-body">
        <h4>Stats:</h4>
       <h1>Number of Books: {{ totalBooks }}</h1> 
       <h1>Number of Hard-Covers: {{ hardcoverCount }}</h1>
       <h1>Number of Paper-Backs: {{ paperbackCount }}</h1>
       <h1>Number of Authors:</h1>
       <h1>Average Price of Book: ${{ averageCost }}</h1>
       <h1>Total Money saved by buying used: </h1>
    </div> -->
    
  </div>
</template>

<script>
import StatsService from '@/services/StatsService';
export default {
  data(){
    return{
      totalBooks:'',
      totalAuthors:'',
      moneySpent:'',
      moneySaved:'',
      averageCost:'',
      averagePageCount:'',
      hardcoverCount:'',
      paperbackCount:'',
      totalFromAuthor:'',
      totalFromGenre:'',
      daysWithMostBuys:'',
      mostExpensive: '',
    }
  }, 
  methods:{
    bookCount(){
      StatsService.bookCount().then((response) => 
            this.totalBooks = response.data);
    },

    totalHardcover(){
      StatsService.hardcoverCount().then((response) => {
        this.hardcoverCount = response.data
      })
    },

    totalPaperbacks(){
      StatsService.paperbackCount().then((response) => {
        this.paperbackCount = response.data
      })
    },

    averagePrice(){
      StatsService.averagePrice().then((response) => {
        this.averageCost = response.data / 100
      })
    },
    
    totalMoneySaved(){
      StatsService.moneySaved().then((response) => {
        this.moneySaved = (response.data / 100 * -1) 
      })
    },

    priciestBook(){
      StatsService.priciestBook().then((response) => {
        this.mostExpensive = (response.data[0].bookTitle);
      })
      
    },
     
    cheapestBook(){
      StatsService.moneySaved().then((response) => {
        this.moneySaved = (response.data / 100 * -1) 
      })
    },
    

  }, 
  created(){
    this.bookCount();
    this.totalHardcover();
    this.totalPaperbacks();
    this.averagePrice();
    this.totalMoneySaved();
    this.priciestBook();
  }
}
</script>

<style>
    .container{
      display: flex;
      flex-direction: row;
      height: 100vh;
      flex-wrap: wrap;
    }

    .card{
      display: flex;
      flex-direction: column;
      border: 3px solid yellow;
      margin: 10px;
      padding: 20px;
      align-items: center;
    }

    .description{

    }

    .stat{
      border: 4px solid black;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 160px;
      width: 120px;
      font-size: 2.6em;
      padding: 15px;
      text-align: center;

    }



</style>