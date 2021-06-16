<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Opere</h2>
    <div style="text-align:right">
      <div v-if="showAdminBoard" class="navbar-nav ml-auto">
        <form id="opere-search" v-on:submit.prevent>
          <input type="text" placeholder="Ricerca opera" name="operaName" />
          <button type="submit" class="btn btn-primary btn-sm mt-3" @click="searchOpera">Ricerca</button>
        </form>

      <router-link class="btn btn-outline-success btn-sm" to="/addOpera">Inserisci Opera
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/modificaOpera">Modifica Opera
      </router-link>
      <router-link class="btn btn-outline-success btn-sm" to="/deleteOpera">Elimina Opera
      </router-link>
    </div>
    <hr/>

    <div cass="container px-5">
      <div class=" row ">
        <div
            v-for="opere in operas"
            :key="opere.anno">
          {{opere.titolo}}    {{opere.anno}}   {{opere.descrizione}}   {{opere.artista}}

        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import axios from "axios";
import authHeader from "@/services/auth-header";
import OpereService from "@/services/opere.service"

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
      operas: [],
      id_value: 0,
    };
  },
  mounted() {
    OpereService.getAllOperas().then(
        response => {
          this.operas = response.data;
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
    searchOpera() {
      const form = document.getElementById('opere-search');
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/operaSpeficifa", {
            params: {
              titolo: formData.get('operaName')
            }, headers: authHeader()
          })
          .then((response) => {
            this.operas = response.data;
          });
    },
    deleteOpera(id, event) {
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
    updateOpera(id) {
      this.$router.push({ path: "/opereUpdate/" + id });
    },
  }
}
</script>

<style scoped>

</style>