import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/chatroom',
    name: 'Chatroom',
    component: () => import('../views/Chatroom.vue')
  },
  {
    path: '/dashboardchatroom',
    name: 'Dashboardchatroom',
    component: () => import('../views/DashboardChatroom.vue')
  },
  {
    path: '/dashboardusers',
    name: 'Dashboardusers',
    component: () => import('../views/DashboardUsers.vue')
  },
  {
    path: '/',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router