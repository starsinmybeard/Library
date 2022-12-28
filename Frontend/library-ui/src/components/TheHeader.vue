<template>
    <div class="header-container">
        <div class="links">

            <div class="link" id="lib">
                <div class="img-container">
                    <router-link v-bind:to="{name: 'Library'}" id="img-container">
                    <img src="../assets/book.png"/>
                    <div class="img-desc">
                        <h6>To the Library</h6>
                    </div>
                    </router-link>
                    
                </div>
            </div>

            <div class="link">
                <router-link v-bind:to="{name: 'Profile'}">Profile Page</router-link>
            </div>

            <div class="link">
                <router-link v-bind:to="{name: 'BookClub'}">Book Club</router-link>
            </div>
            
            <div class="link">
                <router-link v-bind:to="{name: 'AddBook'}">Add Book</router-link>
            </div>
            
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

    .img-container{
        position: relative;
    }

    img{
        height: 100px;
        width: 100px;
    }

    .img-desc{
        position: absolute; /* position based on boundery created by nearest relative ancestor */
        transform: translate(120%, -125%);
        opacity: 0;
        height: 100px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .img-container:hover .img-desc {
        opacity: 1;
    }
</style>