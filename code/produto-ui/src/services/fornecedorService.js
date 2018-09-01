
import HttpService from '@/services/httpService'

export default {

  itens: [],

  findById (id, callback) {
    let endPoint = 'produto/fornecedores/' + id
    HttpService.get(endPoint, null, 'json', callback)
  },
  findAll (callback) {
    let endPoint = 'produto/fornecedores'
    HttpService.get(endPoint, null, 'json', callback)	  
  },
  salvar (item, callback) {
    let endPoint = 'produto/fornecedores'
    HttpService.post(endPoint, item, 'json', callback)
  },
  excluir (id, callback) {
    let endPoint = 'produto/fornecedores/' + id
    HttpService.delete(endPoint, null, 'json', callback)
  },  
  exportarPdf (idPedido, callback) {
    let endPoint = 'pedido/exportar.pdf/' + idPedido
    HttpService.downloadFile(endPoint, 'Pedido_' + idPedido + '.pdf', callback)
  }
}
