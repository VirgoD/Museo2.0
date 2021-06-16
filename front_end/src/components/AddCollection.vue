<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Collection</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form id="insertCollection" v-on:submit.prevent>
            <div class="form-group">
              <p>TITOLO:</p>
              <input v-model="collection.titolo" placeholder="titolo" name="titolo">
              <p>ANNO:</p>
              <input v-model="collection.anno" placeholder="anno" name="anno">
              <p>DESCRIZIONE:</p>
              <input v-model="collection.descrizione" placeholder="descrizione" name="descrizione">
              <p>CURATORE ID:</p>
              <input v-model="collection.curatoreId" placeholder="curatoreId" name="curatoreId">
            </div>
            <button
                @click="createCollection"
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
      collection: {
        titolo: "",
        anno: "",
        descrizione: "",
        curatoreId: ""
      },
    };
  },

  methods: {
    createCollection() {
      const form = document.getElementById("insertCollection");
      const formData = new FormData(form);
      axios
          .get("http://localhost:8080/api/v1/addCollezione", {
            params: {
              titolo: formData.get('titolo'),
              anno: formData.get('anno'),
              descrizione: formData.get('descrizione'),
              curatoreId: formData.get('curatoreId')
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