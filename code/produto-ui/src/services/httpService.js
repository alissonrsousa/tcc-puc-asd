import Vue from 'vue'
import fileSaver from 'file-saver'

export default {

  contentType: {json: 'application/json', xml: 'text/xml', file: 'application/octet-stream'},

  get (endPoint, parametros, formato, callback, callbackErro) {
    let errorCallback = callbackErro || callback
    Vue.http.get(endPoint, parametros, {}).then(this.sucessHandler(callback), this.errorHandler(errorCallback))
  },

  post (endPoint, parametros, formato, callback, callbackErro) {
    let errorCallback = callbackErro || callback
    Vue.http.post(endPoint, parametros, {}).then(this.sucessHandler(callback), this.errorHandler(errorCallback))
  },

  downloadFile (endPoint, nomeArquivo, callback) {
	  var me = this
	  let url = (endPoint.indexOf('http') === -1) ? Vue.http.options.root + '/' + endPoint : endPoint

	  let xhr = new XMLHttpRequest()
	  xhr.open('GET', url, true)
	  xhr.setRequestHeader('Content-type', me.contentType['file'])
	  xhr.setRequestHeader('authorization', 'Bearer ' + localStorage.getItem('authorization'))
	  xhr.responseType = 'blob'
	
	  xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4) {
	      if (xhr.status === 200) {
	        var blob = new Blob([xhr.response])
	        fileSaver.saveAs(blob, nomeArquivo)
	        // eslint-disable-next-line
	        callback(true)
	      }
	      else {
	        // eslint-disable-next-line
	        callback(false)
	      }
	    }
	  }
	  xhr.send()
  },

  sucessHandler (callback) {
    return function (response) {
      if (callback) {
        let retorno = response.data !== undefined && response.data !== null ? response.data : response.bodyText
        callback(retorno)
      }
    }
  },

  errorHandler (callback) {
    return function (erro) {
      console.log(erro.data.status + ':' + erro.data.error)
      if (String(erro.data.status) === String(403)) {
    	  alert('Sua sessão expirou. Favor realizar o login novamente.')
    	  location.href = '/#/login';
      }
      else {
    	  alert('Ops...<br/>Ocorreu um erro ao processar uma requisição. Persistindo o erro, favor informar ao administrador da aplicação.')
    	  location.href = '/#/login';    	  
      }
      if (callback) {
        // eslint-disable-next-line
        callback(false)
      }
    }
  }
}
