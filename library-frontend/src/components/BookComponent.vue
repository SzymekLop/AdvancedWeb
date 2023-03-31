<template>
  <tr>
    <td>{{ book.id }}</td>
    <td>{{ book.title }}</td>
    <td>{{ book.authorId }}</td>
    <td>{{ book.pages }}</td>
    <td>
      <!--  <button class="book-update-button" @click="onUpdate">Update</button> -->
      <button class="page-button button-small shadow-box" @click="onDelete">
        Delete
      </button>
    </td>
  </tr>
</template>

<script>
// import axios from "axios";
export default {
  name: "BookComponent",
  props: {
    book: {
      type: Object,
    },
  },
  methods: {
    onDelete() {
      this.$emit("onDelete", this.book.id);
    },
    onUpdate() {
      this.$emit("onUpdate", this.book);
    },
    // getAuthor(act_book) {
    //   axios
    //     .get(`authors/${act_book.id}`)
    //     .then((data) => data.data)
    //     .catch((e) => alert(e));
    // },
  },
};
</script>