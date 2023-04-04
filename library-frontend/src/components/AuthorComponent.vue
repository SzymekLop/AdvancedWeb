<template>
  <tr>
    <td>{{ author.id }}</td>
    <td>{{ author.name }}</td>
    <td>{{ author.surname }}</td>
    <td>
      <button class="page-button button-small shadow-box" @click="onDelete">
        Delete
      </button>
    </td>
  </tr>
</template>

<script>
export default {
  name: "AuthorComponent",
  props: {
    author: {
      type: Object,
    },
  },
  methods: {
    onDelete() {
      this.$emit("onDelete", this.author.id);
    },
  },
};
</script>