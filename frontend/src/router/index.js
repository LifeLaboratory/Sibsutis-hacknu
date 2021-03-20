import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '../views/Dashboard.vue'
import UserProfile from "../views/UserProfile";
import OrganizationProfile from "../views/OrganizationProfile";
import Event from "../views/Event";
import Activity from "../views/Activity";
import Authorization from "../views/Authorization";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: 'user',
    name: 'UserProfile',
    component: UserProfile
  },
  {
    path: '/user/:userId',
    name: 'UserProfile',
    component: UserProfile
  },
  {
    path: '/organization',
    name: 'OrganizationProfile',
    component: OrganizationProfile
  },
  {
    path: '/organization/:organizationId',
    name: 'OrganizationProfile',
    component: OrganizationProfile
  },
  {
    path: '/event/:eventId',
    name: 'Event',
    component: Event
  },
  {
    path: '/activity',
    name: 'Activity',
    component: Activity
  },
  {
    path: '/auth',
    name: 'Authorization',
    component: Authorization
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
