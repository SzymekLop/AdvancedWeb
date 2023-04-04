<template>
  <div>
    <div class="adding-author-form-container">
      <form @submit.prevent="handleSubmit" class="adding-author-form">
        <div class="form-field">
          <label> First Name: </label>
          <input
            v-model="author.name"
            type="text"
            name="name"
            :class="{ 'has-error': submitting && invalidTitle }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Last Name: </label>
          <input
            v-model="author.surname"
            type="text"
            name="surname"
            :class="{ 'has-error': submitting && invalidAuthor }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <p v-if="error && submitting" class="error-message">
            Wypelnij wszystkie pola formularza
          </p>
        </div>
        <div class="form-field">
          <button type="submit" class="page-button button-small shadow-box">
            Add
          </button>
        </div>
      </form>
    </div>

    <div class="adding-author-form-container">
      <form @submit.prevent="handleSubmitUpdate" class="adding-author-form">
        <div class="form-field">
          <label> Id: </label>
          <input
            v-model="authorU.id"
            :class="{ 'has-error': submitting && invalidIdU }"
            type="text"
            name="authorid"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> First Name: </label>
          <input
            v-model="authorU.name"
            type="text"
            name="name"
            :class="{ 'has-error': submitting && invalidFirstNameU }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Last Name: </label>
          <input
            v-model="authorU.surname"
            type="text"
            name="surname"
            :class="{ 'has-error': submitting && invalidLastNameU }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <p v-if="errorU && submittingU" class="error-message">
            Wypelnij wszystkie pola formularza
          </p>
        </div>
        <div class="form-field">
          <button
            type="submitUpdate"
            class="page-button button-small shadow-box"
          >
            Update
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "adding-author-form",
  props: {
    authorsSource: Array,
  },
  data() {
    return {
      submitting: false,
      error: false,
      submittingU: false,
      errorU: false,
      success: false,
      author: {
        id: "",
        name: "",
        surname: "",
      },
      authorU: {
        id: "",
        name: "",
        surname: "",
      },
    };
  },
  methods: {
    clearStatus() {
      this.error = false;
      this.errorU = false;
      this.success = false;
    },

    handleSubmit() {
      this.submitting = true;
      this.clearStatus();
      if (this.invalidFirstName || this.invalidLastName) {
        this.error = true;
        return;
      }
      this.$emit("add:author", this.author);

      this.author = {
        id: "",
        name: "",
        surname: "",
      };
      this.error = false;
      this.success = true;
      this.submitting = false;
    },

    handleSubmitUpdate() {
      this.submittingU = true;
      this.clearStatus();
      if (this.invalidFirstNameU || this.invalidLastNameU) {
        this.errorU = true;
        return;
      }

      this.$emit("update:author", this.authorU);

      this.authorU = {
        id: "",
        name: "",
        surname: "",
      };
      this.errorU = false;
      this.success = true;
      this.submittingU = false;
    },
  },
  computed: {
    invalidFirstNameU() {
      return this.authorU.name === "";
    },
    invalidLastNameU() {
      return this.authorU.surname === "";
    },

    invalidFirstName() {
      return this.author.name === "";
    },
    invalidLastName() {
      return this.author.surname === "";
    },
  },
};
</script>

<style scoped>
.adding-author-form-container {
  margin-bottom: 30px;
}
</style>