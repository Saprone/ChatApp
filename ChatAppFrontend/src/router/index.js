import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/chatroom',
    name: 'Chatroom',
    component: () => import('../pages/ChatroomPage.vue')
  },
  {
    path: '/dashboardchatroom',
    name: 'Dashboardchatroom',
    component: () => import('../pages/DashboardChatroomPage.vue')
  },
  {
    path: '/dashboardusers',
    name: 'Dashboardusers',
    component: () => import('../pages/DashboardUsersPage.vue')
  },
  {
    path: '/',
    name: 'Login',
    component: () => import('../pages/LoginPage.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router