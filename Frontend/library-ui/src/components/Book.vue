<template>
  <div>
    <h1>{{book.title}}</h1>
    <h3>{{book.author}}</h3>
    <h3>{{book.purchase_location}}</h3>

  </div>
</template>

<script>
import BookService from '../services/BookService.js'
export default {

    data(){
        return{
            book: []
        }
    }

}
</script>

<style>

</style>