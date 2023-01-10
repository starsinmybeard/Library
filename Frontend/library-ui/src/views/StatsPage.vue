<template>
  <div class="profile-container">
    <div class="profile-header">
        <h1>Profile Page</h1>
    </div>
    <div class="profile-body">
        <h4>Stats:</h4>
       <h1>Number of Books: {{ totalBooks }}</h1> 
       <h1>Number of Authors:</h1>
       <h1>Average Price Spent:</h1>
       <h1>Total Money saved by buying used: </h1>
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
      harcoverCount:'',
      paperbackCount:'',
      totalFromAuthor:'',
      totalFromGenre:'',
      daysWithMostBuys:'',
    }
  }, 
  methods:{
    bookCount(){
      StatsService.bookCount().then((response) => 
            this.totalBooks = response.data);
    },
    
    

  }, 
  created(){
    this.bookCount();
  }
}
</script>

<style>

</style>