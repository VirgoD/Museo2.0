<template>
  <form v-on:submit.prevent>
    <div class="form-group">
      <p>ID:</p>
      <input v-model="artist.id" placeholder="nome">
    <button
        @click="deleteArtist"
        type="submit"
        class="btn btn-primary btn-sm mt-3"
    >
      Create
    </button>
    </div>
  </form>
</template>

<script>
export default {
  name: "deleteArtist"
}
</script>

<style scoped>

</style>