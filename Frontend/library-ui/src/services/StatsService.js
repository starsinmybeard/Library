import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000/stats"
});

export default {
    bookCount(){
        return http.get('/BookCount')
    }, 

    authorCount(){
        return http.get('/AuthorCount')
    },

    moneySpent(){
        return http.get('/MoneySpent')
    },
    

}