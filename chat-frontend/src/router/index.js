import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import chat from '../views/chat.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', component: HomePage ,props: true,},
    { path: '/chat', component: chat, props: true, },
  ],
})

export default router
