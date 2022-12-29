<template>
  <div class="registration-page">
    <div class="registration-header">
        <h1>Your Bookshelf awaits...</h1>
        <h3>Register an account for free below.</h3>
        <h5>Already have an account? Login <a href="">CHANGE TO ROUTER LINK TO LOGIN PAGE</a></h5>
    </div>

    <div class="registration-form">
        <form>

            <div id="form-item">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" v-model="user.firstName" required>
            </div>

            <div id="form-item">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" v-model="user.lastName" required>
            </div>


            <div id="form-item">
                <label for="email">Email Address:</label>
                <input type="text" id="emailAddress" v-model="user.emailAddress" required>
            </div>
            
            <div id="form-item">
                <label for="userName">User Name:</label>
                <input type="text" id="userName" v-model="user.userName" required>
            </div>


            <div id="form-item">
                <label for="password">Password:</label>
                <input type="password" id="password" v-model="user.password" required>
            </div>

            <div id="form-item">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="password" v-model="user.confirmPassword" required>
            </div>
        </form>

    </div>
  </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";

export default {
    data(){
        return{
            user:{
                firstName: "",
                lastName : "",
                emailAddress : "",
                userName : "",
                password : "",
                confirmPassword : "",
                role: user
            }, 
            registrationErrors: false,
            errorMessage: "",
        }
    }, 

    methods: {
        registerUser(user){
            if(this.user.firstName = ""){
                this.registrationErrors = true;
                this.errorMessage = "Please enter your first name.";
            } else if(this.user.lastName = ""){
                this.registrationErrors = true;
                this.errorMessage = "Please enter your last name.";
            } else if(this.user.confirmPassword != this.user.password){
                this.registrationErrors = true;
                this.errorMessage = "passwords do not match.";
            }



            ProfileService.register(user)
        }
    }
}
</script>

<style>

</style>