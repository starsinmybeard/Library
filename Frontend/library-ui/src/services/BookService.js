import axios from 'axios';

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
    },

    editBook(id, book){
        return http.put(`/Book/${id}`, book);
    },


//Filter Books Based off Purchase Location
    boughtFromGarlandCounty(){
        return http.get('/GarlandCounty');
    },
    boughtFromEbay(){
        return http.get('/Ebay');
    },
    boughtFromAmazon(){
        return http.get('/Amazon');
    },
    gotForFree(){
        return http.get('/freebooks');
    },
    boughtForSchool(){
        return http.get('/schoolbooks')
    },


    numOfBooks(){
        return http.get('/numofbooks')
    }
}