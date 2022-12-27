import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:3000"
});

const bookCoverHTTP = axios.create({
    baseURL:"https://covers.openlibrary.org/b/isbn/"
});


export default {

    getAllBooks(){
        return http.get('/');
    },

    getBook(bookId){
        return http.get(`/Book/${bookId}`);
    },

    addBook(book){
        return http.post('/AddBook', book);
    },

    getBookCover(isbn){
        return bookCoverHTTP.get(`${isbn}-M.jpg`);
    }
}