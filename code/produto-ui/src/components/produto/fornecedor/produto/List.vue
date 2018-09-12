<template>

	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default" style="margin-top: 20px;">
	                <div class="panel-heading">
	                    Fornecedor: {{item.nomeFantasia}}
	                    <div style="position: absolute; right: 23px; top: 6px;">
                        	<button type="button" class="btn btn-primary btn-circle" @click="cadastrar()">
                            	<i class="fa fa-plus"></i>
                        	</button>	                    
	                    </div>
	                </div>
	                <!-- /.panel-heading -->
	                <div class="panel-body">
	                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
	                        <thead>
	                            <tr>
	                                <th class="hidden-xs">Código</th>
	                                <th>Nome</th>
	                                <th class="hidden-xs">Preço</th>
	                                <th class="hidden-xs">Prazo Entrega</th>
	                                <th>Estoque</th>
	                                <th class="hidden-xs">Valor Frete</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr class="odd gradeX" v-for="item in item.produtos" :key="item.id">
	                                <td class="center hidden-xs">{{item.id}}</td>
	                                <td>{{item.nomeProduto}}</td>
	                                <td class="center hidden-xs">{{item.preco}}</td>
	                                <td class="hidden-xs">{{item.prazoEntrega}}</td>
	                                <td class="center">{{item.estoque}}</td>
	                                <td class="hidden-xs">{{item.valorFrete}}</td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	</div>
	<!-- /#page-wrapper -->
        
</template>

<script>
import genericService from '@/services/genericService'

export default {
  name: 'ProdutosFornecedor',
  data () {
    return {
      item: {nomeFantasia: '', produtos: [{id: ''}]},
      service: genericService,
      restService: 'produto-service/',
      route: 'produto/fornecedores/'
    }
  },
  mounted () {
    var me = this
    genericService.setBaseEndPoint(me.restService + me.route)
    me.carregarItens()
  },
  methods: {
	carregarItens () {
        var me = this;
        var id = me.$route.params.id;
        
       	me.service.findById(id, function (retorno) {
        	me.item = retorno;
        	console.log(me.item.nomeFantasia);
        });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

	@media (max-width:767px) {
		.hidden-xs {
			display:none !important
		}
		.acoes-xs {
			width: 30px !important
		}
	}

</style>
