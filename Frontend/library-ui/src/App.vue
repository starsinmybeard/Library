<template>

  <div class="app">
    <div id="nav">
      <header>
        <ul>
          <li><router-link v-bind:to="{name: 'home'}">Home</router-link></li>
          <li><router-link v-bind:to="{name: 'library'}">Library</router-link></li>
          <li><router-link v-bind:to="{name: 'profile'}">Profile</router-link></li>
        </ul>
      </header>
    </div>
  </div>

</template>

<script>



export default {
  name: 'App',
}
</script>

<style>

  .bookshelf{
    display: flex;
    flex-direction: row;
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