<template>
    <div class="adding-author-form-container">
        <form @submit.prevent="handleSubmit" class="adding-author-form">         
            <div class="form-field">

                <label> First Name: </label>
                <input v-model="author.firstName"
                 type="text"
                 name="title"

                 :class="{ 'has-error': submitting && invalidTitle}"
                 @focus="clearStatus"
                 @keypress="clearStatus"> 

            </div>
            <div class="form-field">
                <label> Last Name: </label>
                <input v-model="author.lastName"
                 type="text"
                 name="author"
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
                firstName: '',
                lastName: ''
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

            this.$emit('add:author', this.author)

            this.author = {
                id: '',
                firstName: '',
                lastName: ''
            }
            this.error = false;
            this.success = true;
            this.submitting = false;
        }
    },
    computed: {
        invalidFirstName(){
            return this.author.firstName === ''
        },
        invalidLastName(){
            return this.author.lastName === ''
        },
    }
}

</script>

<style scoped>

.adding-author-form-container{
    margin-bottom: 30px;
}


</style>