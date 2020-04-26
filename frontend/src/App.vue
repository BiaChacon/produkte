<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Produkte</a>
      </div>
    </nav>

    <div class="container">

      <ul>
        <li v-for="(erro, index) of errors" :key="index">
            campo <b>{{ erro.field }}</b> - {{ erro.defaultMessage }}
        </li>
      </ul>
      
      <form @submit.prevent="speichern">

          <label>Name</label>
          <input type="text" placeholder="Name" v-model="produkt.name">
          <label>Menge</label>
          <input type="number" placeholder="Menge" v-model="produkt.menge">
          <label>Wert</label>
          <input type="text" placeholder="Wert" v-model="produkt.wert">

          <button class="waves-effect waves-light btn-small">Speichern<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NAME</th>
            <th>MENGE</th>
            <th>WERT</th>
            <th>OPTIONEN</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="produkt of produkte" :key="produkt.id">

            <td>{{produkt.name}}</td>
            <td>{{produkt.menge}}</td>
            <td>{{produkt.wert}}</td>
            <td>
              <button @click="edit(produkt)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="deletar(produkt)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import Produkt from './services/produkte'

export default{

  data(){
    return {
      produkt: {
        name: '',
        menge: '',
        wert: ''
      },
      produkte: []
    }
  },

  mounted(){
      this.liste()
  },

  methods:{

    liste(){
      Produkt.liste().then(response => {
        this.produkte = response.data
      })
    },

    speichern(){

      if(!this.produkt.id){

        Produkt.speichern(this.produkt).then(response => {
          window.console.log(response)
          this.produkt = {}
          this.liste()
          this.errors = {}
        }).catch(e => {
          this.errors = e.response.data.errors
        }) 

      }else{
        Produkt.update(this.produkt).then(response => {
          window.console.log(response)
          this.produkt = {}
          this.liste()
          this.errors = {}
        }).catch(e => {
          this.errors = e.response.data.errors
        }) 
      }
       
    },

    deletar(produkt){
      Produkt.deletar(produkt).then(response =>{
        window.console.log(response)
        this.liste();
        this.errors = {}
      }).catch(e => {
        this.errors = e.response.data.errors
      })
    },

    edit(produkt){
      this.produkt = produkt
    }
      
  }

}

</script>

<style>

</style>