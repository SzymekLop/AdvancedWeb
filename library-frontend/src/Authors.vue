<template>
    <div id="app">
        <div id="page-header" class="content-box shadow-box">
            <h1 class="page-header-item"><a class="page-button" href="/">Book Service</a></h1>
            <a class="page-button button shadow-box" href="books">Books</a>
            <a class="page-button button shadow-box btn-active" href="authors">Authors</a>
        </div>
        <div id="page-content" class="content-box shadow-box">
            <adding-author-form @add:author="addAuthor"></adding-author-form>
            <authors-table :authorsSource="authors" @onDelete="deleteAuthor" @onUpdate="updateAuthor"></authors-table>
        </div>
    </div>
</template>

<script>
import AddingAuthorForm from './components/AddingAuthorForm.vue'
import AuthorsTable from './components/AuthorsTable.vue'
import axios from "axios"

export default {
    name: 'App',
    components: {
        AddingAuthorForm,
        AuthorsTable,
    },
    data() {
        return {
            authors: [],
        }
    },
    methods: {
        addAuthor(author) {
            axios.put('http://localhost:8080/authors', {
                    id: Math.floor(Math.random() * 1000),
                    name: author.firstName,
                    surname: author.lastName
                })
                .then(() => { this.getAuthors() })
                .catch(e => alert(e))
        },

        getAuthors() {
            axios.get('http://localhost:8080/authors').then(data => { this.authors = data.data }).catch(e => alert(e))
        },

        deleteAuthor(id) {
            axios.delete(`http://localhost:8080/authors/${id}`).then(() => { this.getAuthors() }).catch(e => alert(e))
        },

        updateAuthor(author) {
            axios.put(`http://localhost:8080/books/${author.id}`, {
              id: author.id,
                name: author.firstName,
                surname: author.lastName
            }).then(() => { this.getAuthors() }).catch(e => alert(e))
        },
    },
    mounted() {
        this.getAuthors()
    }
}
</script>

<style>

</style>
