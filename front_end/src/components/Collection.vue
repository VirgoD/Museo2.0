<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Collections</h2>
    <div class="" style="text-align:right">
      <form id="collection-search" v-on:submit.prevent>
        <input type="text" placeholder="Ricerca collezione" name="titolo"/>
        <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchCollection">Ricerca</button>
      </form>

      <router-link class="btn btn-outline-success btn-sm" to="/addCollection">Inserisci Collezione
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/modificaCollection">Modifica Collezione
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/deleteCollection">Elimina Collezione
      </router-link>
    </div>
    <hr/>

    <div cass="container px-5">
      <div class=" row ">
        <div
            v-for="collection in collections"
            :key="collection.id">
          {{collection.titolo}}    {{collection.anno}}   {{collection.descrizione}}   {{collection.curatoreId}}

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CollectionService from '../services/collection.service';
import axios from "axios";
import authHeader from "@/services/auth-header";


export default {
  data() {
    return {
      collections: [],
      id_value: 0,
    };
  },
  mounted() {
    CollectionService.getAllCollections().then(
        response => {
          this.collections = response.data;
        },
        error => {
          this.content =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
        }
    );
  },

  methods : {
    searchCollection() {
      const form = document.getElementById('collection-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/collezioneSpecifico", {
            params: {
              titolo: formData.get('titolo')
            }, headers: authHeader()
          })
          .then((response) => {
            this.collections = response.data;
          });
    },
    deleteCollection(id, event) {
      console.log(id);
      axios.delete("http://localhost:8080/api/v1/delete" + id).then((response) => {
        console.log(response);
      });
      event.target.parentElement.parentElement.parentElement.className =
          "animate__animated animate__bounceOutUp";
      setTimeout(function() {
        event.target.parentElement.parentElement.remove();
      }, 1000);
    },
    updateCollection(id) {
      this.$router.push({ path: "/collectionUpdate/" + id });
    },
  }
}
</script>

<style scoped>

</style>