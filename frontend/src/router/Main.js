import { createRouter, createWebHistory } from 'vue-router'
import Main from '../components/Home_Main.vue'
import Home from '../views/Home.vue'
import Dashboard from '../views/Dashboard.vue'
import Details from '../views/Details.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    { 
      path: '/dashboard', 
      name: 'Dashboard', 
      component: Dashboard,
    },
    {
      path: '/model/:modelNo',
      name: 'Details',
      component: Details
    }
  ]
})

export default router
