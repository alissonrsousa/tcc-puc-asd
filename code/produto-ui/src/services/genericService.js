
import HttpService from '@/services/httpService'

export default {

  baseEndPoint: '',

  setBaseEndPoint (pBaseEndPoint) {
	this.baseEndPoint = pBaseEndPoint;  
  },
  findById (id, callback) {
    let endPoint = this.baseEndPoint + id
    HttpService.get(endPoint, null, 'json', callback)
  },
  findAll (callback) {
    let endPoint = this.baseEndPoint
    HttpService.get(endPoint, null, 'json', callback)	  
  },
  salvar (item, callback) {
    let endPoint = this.baseEndPoint
    HttpService.post(endPoint, item, 'json', callback)
  },
  excluir (id, callback) {
    let endPoint = this.baseEndPoint + '/' + id
    HttpService.delete(endPoint, null, 'json', callback)
  }
}
