import HttpService from '@/services/httpService'

export default {

	login () {
	      var me = this
	      var formData = new FormData();
	      formData.append('username', me.usuario);
	      formData.append('password', me.senha);
	      formData.append('grant_type', 'password');

	      Vue.http.post('http://localhost:9092/oauth/token', formData, {})
	      .then((response) => {
	          localStorage.setItem('authorization', JSON.stringify(response.body.access_token));

//	           ir para a home do sistema
	          location.href = '/';
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
	    let endPoint = process.env.CONTEXTO + '/user'
	    HttpService.get(endPoint, null, 'json', callback)
	}

}
