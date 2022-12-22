import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:3000"
});


export default {

    getAllBooks(){
        return http.get('/');
    },

    addBook(book){
        return http.post('/AddBook', book);
    }
}