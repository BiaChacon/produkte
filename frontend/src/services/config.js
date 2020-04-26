import axios from 'axios'

export const http = axios.create({
    baseURL: 'http://produkte-apirest.herokuapp.com/api/'
})