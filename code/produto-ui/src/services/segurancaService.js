import Vue from 'vue'
import HttpService from '@/services/httpService'

export default {

	login (usuario, senha) {
	      var me = this
	      var formData = new FormData();
	      formData.append('username', usuario);
	      formData.append('password', senha);
	      formData.append('grant_type', 'password');

	      Vue.http.post(process.env.AUTHORIZATION_SERVER + '/oauth/token', formData, {})
	      .then((response) => {
	          localStorage.setItem('authorization', JSON.stringify(response.body.access_token));

//	           ir para a home do sistema
	          location.href = '/#/admin';
//	           this.$router.push({name: 'index'});
	        }, err => {
//	           console.log(err);
	          alert('erro ao realizar o login');
	        }
	      );
	},
	    
	sair () {
	    localStorage.setItem('authorization', '');
	    location.href = '#/login';
	},
	
	findDadosUsuario (callback) {
	    let endPoint = process.env.CONTEXTO + '/api/user'
	    HttpService.get(endPoint, null, 'json', callback)
	}

}
