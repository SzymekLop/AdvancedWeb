import { createRouter, createWebHistory } from 'vue-router'

import NotFound from './NotFound.vue'
import Authors from './Authors.vue'
import Books from './Books.vue'
import HomePage from './HomePage.vue'


const routes = [
  {
    path: '/',
    component: HomePage,
  },
  {
    path: '/authors',
    component: Authors,
  },
  {
    path: '/books',
    component: Books,
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