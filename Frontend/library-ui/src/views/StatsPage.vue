<template>
  <div class="container">
    <div class="card">
      <div class="description"><h4>Total number of books</h4></div>
      <div class="stat">{{ totalBooks }}</div>
    </div>

    <div class="card">
      
      <div class="description"><h4>Hard-Covers:</h4></div>
      <div class="stat">{{ hardcoverCount }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Paper-Backs:</h4></div>
      <div class="stat">{{ paperbackCount }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Average Book Price:</h4></div>
      <div class="stat">${{ averageCost }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Money Spent:</h4></div>
      <div class="stat">${{ moneySpent }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Money Saved buying used:</h4></div>
      <div class="stat">${{ moneySaved * -1 }} </div>
    </div>

    <div class="card">
      <div class="description"><h4>Most Expensive Purchase:</h4></div>
      <div class="stat" id="most_expensive">{{ mostExpensive }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Average Page Count:</h4></div>
      <div class="stat">{{ averagePageCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Fiction Books:</h4></div>
      <div class="stat">{{ fictionCount }}</div>
    </div>


    <div class="card">
      <div class="description"><h4>Non-Fiction Books:</h4></div>
      <div class="stat">{{ nonFictionCount }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Longest Book:</h4></div>
      <div class="stat" id="longest">{{ longestBookName }}</div>
    </div>

    <div class="card">
      <div class="description"><h4>Shortest Book:</h4></div>
      <div class="stat" id="shortest">{{ shortestBookName }}</div>
    </div>

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
      fictionCount: '',
      nonFictionCount: '',
      longestBookName: '',
      shortestBookName:''
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
        this.averageCost = (response.data / 100)
      })
    },
    
    totalMoneySaved(){
      StatsService.moneySaved().then((response) => {
        this.moneySaved = (response.data / 100 * -1) 
      })
    },

    totalMoneySpent(){
      StatsService.moneySpent().then((response) => {
        this.moneySpent = (response.data / 100) 
      })
    },

    priciestBook(){
      StatsService.priciestBook().then((response) => {
        this.mostExpensive = (response.data.bookTitle);
      })
    },
     
    cheapestBook(){
      StatsService.moneySaved().then((response) => {
        this.moneySaved = (response.data / 100 * -1) 
      })
    },

    pageCount(){
      StatsService.pageCount().then((response) => {
        this.averagePageCount = (response.data) 
      })
    },

    totalFiction(){
      StatsService.fictionCount().then((response) => {
        this.fictionCount = (response.data) 
      })
    },

    totalNonFiction(){
      StatsService.nonFictionCount().then((response) => {
        this.nonFictionCount = (response.data) 
      })
    },

    longestBook(){
      StatsService.longestBook().then((response) => {
        this.longestBookName = (response.data.bookTitle);
      })
    },

    shortestBook(){
      StatsService.shortestBook().then((response) => {
        this.shortestBookName = (response.data.bookTitle);
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
    this.totalMoneySpent();
    this.pageCount();
    this.totalFiction();
    this.totalNonFiction();
    this.longestBook();
    this.shortestBook();
  }
}
</script>

<style>
    .container{
      display: flex;
      flex-direction: row;
      height: 100%;
      flex-wrap: wrap;
      justify-content: center;
      align-content: flex-start;
      align-items: center;
      margin-top: 20px;
      padding-bottom: 100px;
      background: linear-gradient( #ffffff,#dcceec, #dcceec, #c5b0e1 ,#c3a9e4, #ceb7eb, #c3a7e9);
    }

    .card{
      display: flex;
      flex-direction: column;
      margin: 0px;
      padding: 0px;
      align-items: center;
      height: 300px;
      width: 300px;
    }

    .description{
      font-size: 1.4em;
    }

    .stat{
      border: 4px solid black;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 180px;
      width: 120px;
      font-size: 2.6em;
      padding: 15px;
      text-align: center;
      overflow: auto;
    }

    #most_expensive{
      font-size: 2em;
      overflow: scroll;
    }  

    #shortest, #longest{
      font-size: 2em;
    }

    


</style>