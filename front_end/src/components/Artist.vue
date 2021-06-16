<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Artists</h2>
    <div class="" style="text-align:right">
      <div v-if="showAdminBoard" class="navbar-nav ml-auto">
        <form id="artist-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca artista" name="artistName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchArtist">Ricerca</button>
        </form>

        <router-link class="btn btn-outline-success btn-sm" to="/addArtist">Inserisci Artista
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/modificaArtist">Modifica Artista
        </router-link>
        <router-link class="btn btn-outline-success btn-sm" to="/deleteArtist">Elimina Artista
        </router-link>
      </div>
    </div>
    <hr/>

    <div class="container px-5">
      <div class=" row ">
        <div
            v-for="artist in artists"
            :key="artist.id"
        >
          {{artist.nome}}    {{artist.id}}   {{artist.luogoNascita}}   {{artist.dataNascita}}    {{artist.luogoMorte}}        {{artist.dataMorte}}        {{artist.natzionalita}}

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ArtistService from '../services/artist.service';
import axios from "axios";
import authHeader from "@/services/auth-header";


export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }

      return false;
    },
  },
  data() {
    return {
      artists: [],
      id_value: 0,
    };
  },
  mounted() {
    ArtistService.getAllArtists().then(
        response => {
          this.artists = response.data;
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
    searchArtist() {
      const form = document.getElementById('artist-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/artistaSpecifico", {
            params: {
              nome: formData.get('artistName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.artists = response.data;
            console.log("ARTISTI", this.artists)
          });
    },


    deleteArtist(id, event) {
      console.log(id);
      axios.delete("http://localhost:8080/api/v1/deleteArtist/" + id).then((response) => {
        console.log(response);
      });
      event.target.parentElement.parentElement.parentElement.className =
          "animate__animated animate__bounceOutUp";
      setTimeout(function() {
        event.target.parentElement.parentElement.remove();
      }, 1000);
    },
    updateArtist(id) {
      this.$router.push({ path: "/artistUpdate/" + id });
    },
  }
}
</script>

<style scoped>

</style>