<template>
  <div class="profile-container">
    <div class="profile-header">
        <h1>Profile Page</h1>
    </div>
    <div class="profile-body">
        <h4>Stats:</h4>
       <h1> Number of Books: {{ num }}</h1> 
       <h1>Number of Authors:</h1>
       <h1>Average Price Spent:</h1>
       <h1>Total Money saved by buying used: </h1>
    </div>
    

  </div>
</template>

<script>
import BookService from '@/services/BookService';
export default {
  data(){
    return{
      num:'',
    }
  }, 
  methods:{
    getNumber(){
      BookService.numOfBooks().then((response) => 
            this.num = response.data);
    }
  }, 
  created(){
    this.getNumber();
  }
}
</script>

<style>

</style>