<template>
  <div class="card" v-bind:class="{read: book.read}">
      <h2 class="book-title">{{book.title}}</h2>
    <!-- Please leave <img> commented out until directed to remove open and close comment tags in the README. -->
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    
    <h3 class="book-author">{{book.author}}</h3>
    <button v-bind:class="book.read?'mark-unread':'mark-read'" v-on:click="toggleRead">{{book.read?'Mark Unread':'Mark Read'}}</button>
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        toggleRead() {
            this.$store.commit('TOGGLE_READ', this.book);
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>