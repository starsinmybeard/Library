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

    moneySaved(){
        return http.get('/MoneySaved')
    },

    priciestBook(){
        return http.get('/Priciest')
    },

    cheapestBook(){
        return http.get('/Cheapest')
    },

    pageCount(){
        return http.get('/AvgPageCount')
    },

    fictionCount(){
        return http.get('/FictionCount')
    },

    nonFictionCount(){
        return http.get('/NonFictionCount')
    }
}