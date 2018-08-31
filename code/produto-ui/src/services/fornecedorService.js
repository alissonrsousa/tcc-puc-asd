
import HttpService from '@/services/httpService'

export default {

  itens: [],

  findById (id, callback) {
    let endPoint = 'pedido/pedidoByData/' + idCliente + '/' + new Date()
    HttpService.get(endPoint, null, 'json', callback)
  },
  findAll (callback) {
    let endPoint = 'produto/fornecedores'
    HttpService.get(endPoint, null, 'json', callback)	  
//	  var me = this;
//	  me.itens = ['aaaaa','bbbbb'];
//	  callback(me.itens);
  },
  salvarCheckin (checkin, callback) {
    let endPoint = 'visita/salvar'
    HttpService.post(endPoint, checkin, 'json', callback)
  },
  salvarPedido (idCliente, isProspect, indVendaDistancia, isEnviarEmail, callback) {
    var me = this
    let endPoint = 'pedido/salvar'
    me.getPedidoFormatado(me.pedidos[idCliente], isProspect, indVendaDistancia, isEnviarEmail, function (pedidoFormatado) {
      HttpService.post(endPoint, pedidoFormatado, 'json', function (retorno) {
        me.pedidos[retorno.cliente.id] = me.pedidos[idCliente]
        me.pedidos[idCliente] = retorno
        callback(retorno)
      })
    })
  },
  exportarPdf (idPedido, callback) {
    let endPoint = 'pedido/exportar.pdf/' + idPedido
    HttpService.downloadFile(endPoint, 'Pedido_' + idPedido + '.pdf', callback)
  }
}
