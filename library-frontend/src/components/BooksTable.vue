<template>
    <div id=books-table>
        <table>
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Title </th>
                    <th> Author </th>
                    <th> Pages </th>
                    <th> Actions </th>
                </tr>
            </thead>
            <tbody>
                <book-component v-for="book in booksSource" 
                :key="book.id"
                :book="book"
                @onDelete="onDelete"
                @onUpdate="onUpdate"/>
            </tbody>
        </table>
    </div>
</template>

<script>
import BookComponent from './BookComponent'

export default {
    name: 'books-table',
    components:{
        BookComponent
    },
    props: {
        booksSource: Array
    },
    methods: {
        onDelete(id) {
            this.$emit("onDelete", id)
        },
        onUpdate(book){
            this.$emit("onUpdate", book)
        }
    }
}
</script>

<style scoped>
    #books-table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #books-table td, #books-table th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #books-table tr:nth-child(even){background-color: #e8c7ae;}
    #books-table tr:hover {background-color: #91755e}

    #books-table th {
        padding-top: 10px;
        padding-bottom: 10px;
        text-align: left;
        background-color:#91755e;
        color: white;
    }

</style>