import Auth from "@okta/okta-vue";
import Vue from 'vue';
import Router from 'vue-router';
import Home from './components/Home.vue';
import Login from './components/Login.vue';
import Register from './components/Register.vue';

Vue.use(Auth, {
  issuer: 'https://localhots:8080/oauth2/default',
  client_id: 'dev-29924156.okta.com',
  redirect_uri: window.location.origin + '/implicit/callback',
  scope: 'openid profile email'
});

Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/profile',
      name: 'profile',
      // lazy-loaded
      component: () => import('./components/Profile.vue')
    },
    {
      path: '/default',
      name: 'default',
      // lazy-loaded
      component: () => import('./components/BoardDefault.vue')
    },
    {
      path: '/artist',
      name: 'artist',
      component: () => import('./components/Artist.vue')
    },
    {
      path: '/addArtist',
      name: 'addArtist',
      component: () => import('./components/AddArtist.vue')
    },
    {
      path: '/collection',
      name: 'collection',
      component: () => import('./components/Collection.vue')
    },
    {
      path: '/opere',
      name: 'opere',
      component: () => import('./components/Opere.vue')
    },
    {
      path: '/deleteArtist',
      name: 'deleteArtist',
      component: () => import('./components/DeleteArtist.vue')
    },
    {
      path: '/implicit/callback',
      component: Auth.handleCallback(),
    },
  ]
});

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/home', '/artist', '/collection','/opere'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  Vue.prototype.$auth.authRedirectGuard();
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('/login');
  } else {
    next();
  }
});