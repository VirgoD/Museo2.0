<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Artists</h2>
    <div class="" style="text-align:right">
      <router-link class="btn btn-outline-success btn-sm" to="/artist-create"
      >Create New Artist
      </router-link
      >
      <router-view></router-view>
    </div>
    <hr/>

    <div class="container px-5">
      <div class=" row ">
        <div
            v-for="artist in artists"
            :key="artist.id"
        >
          {{artist.nome}}    {{artist.id}}   {{artist.ltuogoNascita}}   {{artist.dataNascita}}    {{artist.luogoMorte}}        {{artist.dataMorte}}        {{artist.natzionalita}}

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ArtistService from '../services/artist.service';


export default {
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
  }
}
</script>

<style scoped>

</style>