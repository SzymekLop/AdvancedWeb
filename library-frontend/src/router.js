import { createRouter, createWebHistory } from 'vue-router'
import MainLayout from './MainLayout.vue'
import App from './App.vue'
import Authors from './Authors.vue'
import Books from './Books.vue'
import NotFound from './NotFound.vue'

const routes = [
  {
    path: '/',
    component: MainLayout,
    children: [
      {
        path: '',
        component: App,
      },
      {
        path: 'authors',
        component: Authors,
      },
      {
        path: 'books',
        component: Books,
      },
    ],
  },
  {
    path: '/:catchAll(.*)',
    component: NotFound,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router