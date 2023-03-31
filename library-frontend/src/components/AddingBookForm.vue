<template>
    <div class="adding-book-form-container">
        <form @submit.prevent="handleSubmit" class="adding-book-form">         
            <div class="form-field">

            <label> Book id: </label>
                <input v-model="book.id"
                 type="text"
                 name="title"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 
            </div>
            <div class="form-field">
                <label> Title: </label>
                <input v-model="book.title"
                 type="text"
                 name="title"
                 :class="{ 'has-error': submitting && invalidTitle}"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 
            </div>
            <div class="form-field">
                <label> Author: </label>

                <input v-model="book.authorId" 
                type="text"
                 name="authorId"
                 :class="{ 'has-error': submitting && invalidTitle}"
                 @focus="clearStatus"
                 @keypress="clearStatus">
            </div>
            <div class="form-field">
                <label> Pages: </label>
                <input v-model="book.pages"
                 type="text"
                 name="pages"
                 :class="{ 'has-error': submitting && invalidPages}"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 
            </div>
            <div class="form-field">
                <p v-if="error && submitting" class="error-message">
                    Wypelnij wszystkie pola formularza
                </p>
            </div>            
            <div class="form-field">
                <button type="submit" class="page-button button-small shadow-box">Add</button>
            </div>             
        </form>
    </div>
</template>

<script>
export default {
    name: "adding-book-form",
    data(){
        return {
            submitting: false,
            error: false,
            success: false,
            book: {
                id: '',
                title: '',
                authorId: '',
                pages: ''
            }

        }
    },    
    methods: {
        clearStatus(){
            this.error = false;
            this.success = false;
        },

        handleSubmit(){
            this.submitting = true
            this.clearStatus()
            if(this.invalidTitle || this.invalidAuthor || this.invalidPages){
                this.error = true
                return
            }


            if (this.book.id  == '')  {
                this.book.id = Math.floor(Math.random() * 1000)
                this.$emit('add:book', this.book)
            } else {
                this.$emit('update:book', this.book)
            }


            console.log(this.book)
            

            this.book = {
                id: '',
                title: '',
                authorId: '',
                pages: ''
            }
            this.error = false;
            this.success = true;
            this.submitting = false;
        }
    },
    computed: {
        invalidTitle(){
            return this.book.title === ''
        },
        invalidAuthor(){
            return this.book.authorId === ''
        },
        invalidPages(){
            return this.book.pages === ''
        }
    }
}

</script>

<style scoped>

.adding-book-form-container{
    margin-bottom: 30px;
}

</style>