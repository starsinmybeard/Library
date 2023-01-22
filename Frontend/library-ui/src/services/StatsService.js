import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000/stats"
});

export default {
    bookCount(){
        return http.get('/BookCount')
    }, 

    hardcoverCount(){
        return http.get('/HardcoverCount')
    },

    paperbackCount(){
        return http.get('/PaperbackCount')
    },

    authorCount(){
        return http.get('/AuthorCount')
    },

    moneySpent(){
        return http.get('/MoneySpent')
    },

    averagePrice(){
        return http.get('/AveragePrice')
    },

}