<template>
  <div class="book-container">
    <book-card :book="book" v-for="book in books" v-bind:key="book.id" />
  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
  components: { BookCard },
    name: 'reading-list',
    computed: {
      books() {
        return this.$store.state.books;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>