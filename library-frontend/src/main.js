
import { createApp } from "vue/dist/vue.esm-bundler";
import router from './router'
import MainLayout from './MainLayout.vue'


const app = createApp(MainLayout)
app.use(router)
app.mount('#app')