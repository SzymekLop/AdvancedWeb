<template>
    <div id=authors-table>
        <table>
            <thead>
                <tr>
                    <th> ID </th>
                    <th> First Name </th>
                    <th> Last Name </th>
                    <th> Action </th>
                </tr>
            </thead>
            <tbody>
                <author-component v-for="author in authorsSource" 
                :key="author.id"
                :author="author"
                @onDelete="onDelete"
                @onUpdate="onUpdate"/>
            </tbody>
        </table>
    </div>
</template>

<script>
import AuthorComponent from "./AuthorComponent"
export default {
    name: 'authors-table',
    props: {
        authorsSource: Array
    },
    components:{
        AuthorComponent
    },
    methods:{
        onDelete(id) {
            this.$emit("onDelete", id)
        },
        onUpdate(author){
            this.$emit("onUpdate", author)
        }
    }
}
</script>

<style scoped>
    #authors-table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #authors-table td, #authors-table th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #authors-table tr:nth-child(even){background-color: #e8c7ae;}
    #authors-table tr:hover {background-color: #91755e}

    #authors-table th {
        padding-top: 10px;
        padding-bottom: 10px;
        text-align: left;
        background-color:#91755e;
        color: white;
    }

</style>