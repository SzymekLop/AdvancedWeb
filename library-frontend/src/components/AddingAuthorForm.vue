<template>
    <div class="adding-author-form-container">
        <form @submit.prevent="handleSubmit" class="adding-author-form">      
            <div class="form-field">
                <label> Id: </label>
                <input v-model="author.id"
                 type="text"
                 name="authorid"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 
            </div>   
            <div class="form-field">

                <label> First Name: </label>
                <input v-model="author.name"
                 type="text"
                 name="name"

                 :class="{ 'has-error': submitting && invalidTitle}"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 

            </div>
            <div class="form-field">
                <label> Last Name: </label>
                <input v-model="author.surname"
                 type="text"
                 name="surname"
                 :class="{ 'has-error': submitting && invalidAuthor}"
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
    name: "adding-author-form",
    data(){
        return {
            submitting: false,
            error: false,
            success: false,
            author: {
                id: '',
                name: '',
                surname: ''
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
            if(this.invalidFirstName || this.invalidLastName){
                this.error = true
                return
            }

            if (this.author.id == "") {
                this.author.id = Math.floor(Math.random() * 1000)
                this.$emit('add:author', this.author)
            }

            
            this.$emit('update:author', this.author)

            this.author = {
                id: '',
                name: '',
                surname: ''
            }
            this.error = false;
            this.success = true;
            this.submitting = false;
        }
    },
    computed: {
        invalidFirstName(){
            return this.author.name === ''
        },
        invalidLastName(){
            return this.author.surname === ''
        },
    }
}

</script>

<style scoped>

.adding-author-form-container{
    margin-bottom: 30px;
}


</style>