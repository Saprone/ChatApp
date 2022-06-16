import Vue from 'vue'
import VueRouter from 'vue-router'
import Chatroom from '../pages/Chatroom.vue'
import Dashboardchatroom from '../pages/DashboardChatroom.vue'
import Dashboardusers from '../pages/DashboardUsers.vue'
import Login from '../pages/Login.vue'
import Register from '../pages/Register.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/chatroom',
    name: 'Chatroom',
    component: Chatroom
  },
  {
    path: '/dashboardchatroom',
    name: 'Dashboardchatroom',
    component: Dashboardchatroom
  },
  {
    path: '/dashboardusers',
    name: 'Dashboardusers',
    component: Dashboardusers
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes,
  linkActiveClass: 'active'
})

export default router