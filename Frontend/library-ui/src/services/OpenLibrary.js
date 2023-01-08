import axios from "axios";

const openlibrary = axios.create({
    baseURL:"https://openlibrary.org/"
})

export default{
    getBookInfo(isbn){
        return openlibrary.get(`isbn/${isbn}.json`)
    },

    getAuthorInfo(authorTag){
        return openlibrary.get(`authors/${authorTag}.json`)
    }
}