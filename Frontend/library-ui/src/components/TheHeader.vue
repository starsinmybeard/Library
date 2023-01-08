<template>
    <div class="header-container">
        <div class="links">

            <div class="link" id="lib">
                <div class="img-container">
                    <router-link v-bind:to="{name: 'Library'}" class="img-container">
                    <img src="../assets/library.png" id="library-img"/>
                    <div class="img-desc" id="library-desc"><h6>View Your Library</h6></div>
                    </router-link>
                    
                </div>
            </div>

            <div class="link">
                <div class="img-container">
                    <router-link v-bind:to="{name: 'Profile'}" class="img-container">
                    <img src="../assets/stats.png" id="stats-img"/>
                    <div class="img-desc" id="stats-desc"><h6>View Your Stats</h6></div>
                    </router-link>
                    
                </div>
            </div>

            <div class="link">
                <div class="img-container">
                    <router-link v-bind:to="{name: 'BookClub'}" class="img-container">
                    <img src="../assets/friends.png" id="friends-img"/>
                    <div class="img-desc" id="friends-desc"><h6>View Your Friends</h6></div>
                    </router-link>
                    
                </div>
            </div>

        
            <div class="link">
                <router-link v-bind:to="{name: 'AddBook'}" class="img-container">
                    <img id="add-book-img" src="../assets/addBook.png"/>
                    <div class="img-desc">
                        <h6>Add Book</h6>
                    </div>
                </router-link>
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
        margin-bottom: -10px;
    }

    img{
        height: 100px;
        width: 100px;
    }

    #add-book-img{
        margin-top: 5px;
        scale: 80%;
    }

    #library-img{
        margin-top: -15px;
    }

    #stats-img{
        scale: 80%;
        margin-bottom: -15px;
    }
    #friends-img{
        scale: 75%;
        margin-bottom: -5px;
    }

    .img-desc{
        position: absolute; /* position based on boundery created by nearest relative ancestor */
        transform: translate(115%, -110%);
        opacity: 0;
        height: 100px;
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-left: -3px;
        justify-content: center;
    }

    #library-desc{
        transform: translate(100%, -100%);
    }

    #stats-desc{
        transform: translate(90%, -100%);
    }

    #friends-desc{
        transform: translate(90%, -100%);
    }

    .img-container:hover .img-desc {
        opacity: 1;
    }
</style>