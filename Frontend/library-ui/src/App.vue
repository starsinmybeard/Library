<template>
  <div class="app">
    <the-header></the-header>
    <router-view></router-view>
  </div>
</template>



<script>
import TheHeader from './components/TheHeader.vue';
export default {
  name: 'App',
  components:{
    TheHeader
  }
}

</script>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Coming+Soon&display=swap');

    .app{
      font-family: 'Coming Soon', cursive;
      margin-left: 20px;
      margin-top: 20px;
      margin-right: 20px;
      margin-bottom: 20px;
    }
</style>









<!-- 
  <template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view/>
</template>


<style>


/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}  -->