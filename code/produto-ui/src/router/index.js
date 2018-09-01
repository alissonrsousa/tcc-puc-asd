import Vue from 'vue';
import Router from 'vue-router';
import Index from '@/components/Index';
import Login from '@/components/Login';
import Fornecedores from '@/components/produto/Fornecedores';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children: [
	    {
	      path: '/produto/fornecedores',
	      name: 'Fornecedores',
	      component: Fornecedores
	    }
	  ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    }
  ],
});
