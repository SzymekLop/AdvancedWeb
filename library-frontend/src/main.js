
import { createApp } from "vue/dist/vue.esm-bundler";
import App from './App.vue'
import Authors from './Authors.vue'
import Books from './Books.vue'
import NotFound from './NotFound.vue'

const routes = {
  '/': App,
  '/authors': Authors,
  '/books': Books
}

const app = createApp({
  data() {
    return {
      currentRoute: window.location.pathname
    }
  },
  computed: {
    ViewComponent() {
      return routes[this.currentRoute] || NotFound
    }
  },
  mounted() {
    window.addEventListener('popstate', () => {
      this.currentRoute = window.location.pathname
    })
  },
  template: '<component :is="ViewComponent" />'
})

app.mount('#app')