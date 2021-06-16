<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Artist</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertArtist" v-on:submit.prevent>
            <div class="form-group">
              <p>ID:</p>
              <input v-model="artist.id" placeholder="id" name="id">
              <p>NOME:</p>
              <input v-model="artist.nome" placeholder="nome" name="nome">
              <p>Luogo Nascita:</p>
              <input v-model="artist.luogoNascita" placeholder="luogo Nascita" name="luogoNascita">
              <p>data Nascita:</p>
              <input v-model="artist.dataNascita" placeholder="data Nascita" name="dataNascita">
              <p>luogo Morte:</p>
              <input v-model="artist.luogoMorte" placeholder="luogo Morte" name="luogoMorte">
              <p>data Morte:</p>
              <input v-model="artist.dataMorte" placeholder="data Morte" name="dataMorte">
              <p>natzionalita:</p>
              <input v-model="artist.natzionalita" placeholder="natzionalita" name="nazionalita">
            </div>
            <button
                @click="createArtist"
                type="submit"
                class="btn btn-primary btn-sm mt-3"
            >Create</button>
          </form>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import authHeader from "@/services/auth-header";

export default {
  name: "AddArtist",
  data() {
    return {
      artist: {
        nome: "",
        luogoNascita: "",
        dataNascita: "",
        luogoMorte: "",
        dataMorte: "",
        natzionalita: "",
      },
    };
  },

  methods: {
    createArtist() {
      const form = document.getElementById("insertArtist");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/addArtista", {
            params: {
              id: formData.get('id'),
              nome: formData.get('nome'),
              luogoNascita: formData.get('luogoNascita'),
              dataNascita: formData.get('dataNascita'),
              luogoMorte: formData.get('luogoMorte'),
              dataMorte: formData.get('dataMorte'),
              nazionalita: formData.get('nazionalita')
            }, headers: authHeader()}) //TODO Append dei parametri da far passare
          .then((response) => {
            console.log(response);
          });

      this.$router.push("/home");

      return false;
    }

}
}
</script>

<style scoped>

</style>