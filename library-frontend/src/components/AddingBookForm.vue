<template>
  <div>
    <div class="adding-book-form-container">
      <form @submit.prevent="handleSubmit" class="adding-book-form">
        <div class="form-field">
          <label> Title: </label>
          <input
            v-model="book.title"
            type="text"
            name="title"
            :class="{ 'has-error': submitting && invalidTitle }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Author: </label>

          <input
            v-model="book.authorId"
            type="text"
            name="authorId"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Pages: </label>
          <input
            v-model="book.pages"
            type="text"
            name="pages"
            :class="{ 'has-error': submitting && invalidPages }"
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

    <div class="adding-book-form-container">
      <form @submit.prevent="handleSubmitUpdate" class="adding-book-form">
        <div class="form-field">
          <label> Book id: </label>
          <input
            v-model="bookU.id"
            type="text"
            name="title"
            :class="{ 'has-error': submittingU && invalidIdU }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Title: </label>
          <input
            v-model="bookU.title"
            type="text"
            name="title"
            :class="{ 'has-error': submittingU && invalidTitleU }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Author: </label>

          <input
            v-model="bookU.authorId"
            type="text"
            name="authorId"
            :class="{ 'has-error': submittingU && invalidIndex }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <label> Pages: </label>
          <input
            v-model="bookU.pages"
            type="text"
            name="pages"
            :class="{ 'has-error': submittingU && invalidPagesU }"
            @focus="clearStatus"
            @keypress="clearStatus"
          />
        </div>
        <div class="form-field">
          <p
            v-if="errorU && submittingU && !invalidIndex"
            class="error-message"
          >
            Wypelnij wszystkie pola formularza
          </p>

          <p v-if="errorU && invalidIndex" class="error-message">
            Taki autor nie istnieje!
          </p>
        </div>
        <div class="form-field">
          <button type="submit" class="page-button button-small shadow-box">
            Update
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "adding-book-form",
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
      book: {
        id: "",
        title: "",
        authorId: "",
        pages: "",
      },
      bookU: {
        id: "",
        title: "",
        authorId: "",
        pages: "",
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
      if (this.invalidTitle || this.invalidPages) {
        this.error = true;
        return;
      }

      this.$emit("add:book", this.book);

      console.log(this.book);

      this.book = {
        id: "",
        title: "",
        authorId: "",
        pages: "",
      };
      this.error = false;
      this.success = true;
      this.submitting = false;
    },

    handleSubmitUpdate() {
      this.submittingU = true;
      this.clearStatus();
      if (this.invalidTitleU || this.invalidPagesU || this.invalidIndex) {
        this.errorU = true;
        return;
      }

      this.$emit("update:book", this.book);

      this.bookU = {
        id: "",
        title: "",
        authorId: "",
        pages: "",
      };
      this.errorU = false;
      this.success = true;
      this.submittingU = false;
    },
  },
  computed: {
    invalidTitle() {
      return this.book.title === "";
    },
    invalidPages() {
      return this.book.pages === "";
    },

    invalidTitleU() {
      return this.bookU.title === "";
    },
    invalidPagesU() {
      return this.bookU.pages === "";
    },
    invalidIdU() {
      return this.bookU.id === "";
    },

    invalidIndex() {
      return !this.authorsSource.includes((a) => a.id == this.bookU.authorId);
    },
  },
};
</script>

<style scoped>
.adding-book-form-container {
  margin-bottom: 30px;
}
</style>