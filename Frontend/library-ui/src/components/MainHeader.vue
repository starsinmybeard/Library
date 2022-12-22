<template>
  <div class="login"></div>

  <div class="add-book-button">
    <button v-on:click="displayAddBook">Add Book</button>
    <button>my library</button>
  </div>

  <div class="my-profile">
    <button v-on:click="this.$router.push('/profile')"></button>
  </div>

</template>

<script>

export default {
    name:"MainHeader",
    showAddBookForm:false,
    methods:{
        displayAddBook(){
            this.showAddBookForm = !this.showAddBookForm;
        }
    }
}
</script>

<style>

</style>