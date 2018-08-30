import Vue from 'vue';
import App from './App';
import router from './router';
import VueResource from 'vue-resource'

Vue.config.productionTip = false;

Vue.router = router
Vue.use(VueResource)

Vue.http.options.root = process.env.CONTEXTO
let urlLogin = process.env.CONTEXTO + '/auth/token'
let urlUser = process.env.CONTEXTO + '/auth/user'
let urlRefresh = process.env.CONTEXTO + '/auth/refresh'
Vue.use(require('@websanova/vue-auth'), {
  auth: require('@websanova/vue-auth/drivers/auth/bearer.js'),
  http: require('@websanova/vue-auth/drivers/http/vue-resource.1.x.js'),
  router: require('@websanova/vue-auth/drivers/router/vue-router.2.x.js'),
  rolesVar: 'roles',
  loginData: {url: urlLogin, method: 'POST', redirect: '/visitas?origem=login', fetchUser: true},
  fetchData: {url: urlUser, method: 'GET'},
  refreshData: {url: urlRefresh, method: 'POST', atInit: true},
  parseUserData: (data) => data
})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App),
});
