import Vue from 'vue';
import Router from 'vue-router';
import Index from '@/components/Index';
import Login from '@/components/Login';
import ListFornecedores from '@/components/produto/fornecedor/List';
import EditFornecedor from '@/components/produto/fornecedor/Form';
import ListProdutosFornecedor from '@/components/produto/fornecedor/produto/List';

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
	      name: 'ListFornecedores',
	      component: ListFornecedores
	    },
	    {
		  path: '/produto/fornecedores/:id',
		  name: 'EditFornecedor',
		  component: EditFornecedor
		},
	    {
		  path: '/produto/fornecedores/:id/produtos',
		  name: 'ListProdutosFornecedor',
		  component: ListProdutosFornecedor
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
