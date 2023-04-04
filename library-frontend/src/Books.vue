<template>
  <div>
    <div id="page-header" class="content-box shadow-box">
            <h1 class="page-header-item"><a class="page-button" href="/">Library App</a></h1>
            <a class="page-button button shadow-box" href="books">Książki</a>
            <a class="page-button button shadow-box" href="authors">Autorzy</a>
        </div>
    <div id="page-content" class="content-box shadow-box">
      <adding-book-form
        @add:book="addBook"
        @update:book="updateBook"
        :authorsSource="authors"
      ></adding-book-form>
      <books-table @onDelete="deleteBook" :booksSource="books"></books-table>
    </div>
  </div>
</template>

<script>
import AddingBookForm from "./components/AddingBookForm.vue";
import BooksTable from "./components/BooksTable.vue";
import axios from "axios";

export default {
  name: "BooksView",
  components: {
    AddingBookForm,
    BooksTable,
  },
  data() {
    return {
      books: [],
      authors: [],
    };
  },
  methods: {

    getAuthors() {
      axios
        .get("http://localhost:8080/authors")
        .then((data) => {
          this.authors = data.data;
        })
        .catch((e) => alert(e));
    },
    addBook(book) {
      axios
        .put("http://localhost:8080/books", {
          title: book.title,
          authorId: book.authorId,
          pages: book.pages,
        })
        .then(() => {
          this.getBooks();
        })
        .catch((e) => alert(e));
    },

    getBooks() {
      console.log("got objects");
      axios
        .get("http://localhost:8080/books")
        .then((data) => {
          this.books = data.data;
        })
        .catch((e) => alert(e));
      this.books.map((obj) => console.log(obj));

      console.log(this.books.length);
    },

    deleteBook(id) {
      axios
        .delete(`http://localhost:8080/books/${id}`)
        .then(() => {
          this.getBooks();
        })
        .catch((e) => alert(e));
    },

    updateBook(book) {
      console.log("updating with /bookid");
      axios
        .put(`http://localhost:8080/books/${book.id}`, {
          id: book.id,
          title: book.title,
          authorId: book.authorId,
          pages: book.pages,
        })
        .then(() => {
          this.getBooks();
        })
        .catch((e) => alert(e));
    },
  },
  mounted() {
    this.getBooks(),
    this.getAuthors();
  },
};
</script>

<style>
</style>
