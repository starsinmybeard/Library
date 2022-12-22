<template>
    <div class="header-container">
        <div class="links">
            <router-link class="link" v-bind:to="{name: 'Library'}"><img src="../assets/book.png"/></router-link>
            <router-link class="link" v-bind:to="{name: 'Profile'}">Profile Page</router-link>
            <router-link class="link" v-bind:to="{name: 'BookClub'}">Book Club</router-link>
            <router-link class="link" v-bind:to="{name: 'AddBook'}">Add Book</router-link>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
    .header-container{
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 100%;
        padding: 20px;
    }
    .logo{
        display: flex;
        width: 20%;
        border: 10px dotted magenta;
        justify-content: center;
    }
    .links{
        width: 100%;

        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;
        text-align: center;
        
    }
    .link{
        display: flex;
        background-color: rgb(234, 234, 55);
        border: 3px solid purple;
        width: 50vw;
        height: 100%;    
        justify-content: center;
        align-items: center;
        text-decoration: none;
        font-size: 30px;
    }
    img{
        height: 100px;
        width: 100px;
    }
</style>