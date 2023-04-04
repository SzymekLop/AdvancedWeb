<template>
  <tr>
    <td>{{ book.id }}</td>
    <td>{{ book.title }}</td>
    <td>{{ book.author.name + " " + book.author.name + " (" + book.author.id + ")"}}</td>
    <td>{{ book.pages }}</td>
    <td>
      <button class="page-button button-small shadow-box" @click="onDelete">
        Delete
      </button>
    </td>
  </tr>
</template>

<script>
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
  },
};
</script>