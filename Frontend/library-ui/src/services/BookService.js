import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
});


export default {

    getAllBooks(){
        return http.get('/');
    },

    addBook(book){
        return http.post('/', book);
    }
}