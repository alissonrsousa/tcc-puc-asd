import Vue from 'vue';
import App from './App';
import router from './router';
import VueResource from 'vue-resource'

Vue.config.productionTip = false;

Vue.router = router
Vue.use(VueResource)

Vue.http.options.credentials = true;
Vue.http.interceptors.push((request, next) => {
	if (request.url.indexOf('/oauth/') != -1) {
		request.headers.set('Authorization', 'Basic Y3VybF9jbGllbnQ6dXNlcg==');
	}
	else {
		request.headers.set('Authorization', 'Bearer ' + JSON.parse(localStorage.getItem('authorization')));
	}
	request.headers.set('Accept', 'application/json');
	next()
})

Vue.http.options.root = process.env.CONTEXTO
//let urlLogin = 'http://localhost:9092/oauth/token'
//let urlUser = 'http://localhost:9092/oauth/user'
//let urlRefresh = 'http://localhost:9092/oauth/refresh'

//Vue.use(require('@websanova/vue-auth'), {
//  auth: require('@websanova/vue-auth/drivers/auth/bearer.js'),
//  http: require('@websanova/vue-auth/drivers/http/vue-resource.1.x.js'),
//  router: require('@websanova/vue-auth/drivers/router/vue-router.2.x.js'),
//  rolesVar: 'roles',
//  loginData: {url: urlLogin, method: 'POST', redirect: '/visitas?origem=login', fetchUser: true},
//  fetchData: {url: urlUser, method: 'GET'},
//  refreshData: {url: urlRefresh, method: 'POST', atInit: true},
//  parseUserData: (data) => data
//})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App),
});
