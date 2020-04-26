import {http} from './config'

export default {

    liste:() => {
        return http.get('produkte')
    },

    speichern:(produkt) => {
        return http.post('produkt', produkt)
    },

    deletar:(produkt) =>{
        return http.delete('produkt', produkt)
    },

    update:(produkt) => {
        return http.put('produkt', produkt)
    }

}