import axios from "axios";

//GOOGLE API KEY
//AIzaSyA8ilQB35qsEdquClLOoCZzkptDsiwgyzg



const googleAPI = axios.create({
    baseURL:"https://www.googleapis.com"
})

export default{
    getBookDetails(isbn){
        return googleAPI.get(`/books/v1/volumes?q=isbn:${isbn}`)
    }
}