<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Opere</h2>
    <div style="text-align:right">
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
            :key="opere.id">
          {{opere.titolo}}    {{opere.anno}}   {{opere.descrizione}}   {{opere.artista}}

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OpereService from '../services/opere.service';

export default {
  data() {
    return {
      operas: [],
      id_value: 0,
    };
  },
  mounted() {
    OpereService.getAllOperas().then(
        response => {
          this.operes = response.data;
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