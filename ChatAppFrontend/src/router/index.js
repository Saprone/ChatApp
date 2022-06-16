import Vue from 'vue'
import VueRouter from 'vue-router'
/*import Chatroom from './views/Chatroom.vue'
import Dashboardchatroom from './views/DashboardChatroom.vue'
import Dashboardusers from './views/DashboardUsers.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'*/
import Test from '../services/UserService'

Vue.use(VueRouter)

/*const routes = [
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
})*/

export default router