<template>

	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default" style="margin-top: 20px;">
	                <div class="panel-heading">
	                    Fornecedores
	                    <div style="position: absolute; right: 23px; top: 26px;">
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
	                                <th class="hidden-xs">CNPJ</th>
	                                <th class="hidden-xs">Cidade</th>
	                                <th>Telefone</th>
	                                <th class="hidden-xs">Contato</th>
	                                <th>Produtos</th>
	                                <th class="acoes-xs" style="width: 82px;">Ações</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr class="odd gradeX" v-for="item in itens" :key="item.id">
	                                <td class="center hidden-xs">{{item.id}}</td>
	                                <td>{{item.nomeFantasia}}</td>
	                                <td class="center hidden-xs">{{item.cnpj}}</td>
	                                <td class="hidden-xs">{{item.cidade}}</td>
	                                <td class="center">{{item.telafone1}}</td>
	                                <td class="hidden-xs">{{item.contato}}</td>
	                                <td><a v-bind:href="'#/produto/fornecedores/' + item.id + '/produtos'" >{{item.produtos.length}}</a></td>
	                                <td>
	                                	<button type="button" class="btn btn-primary btn-circle" @click="editar(item.id)">
	                                		<i class="fa fa-edit"></i>
                            			</button>
                            			<button type="button" class="btn btn-danger btn-circle" @click="excluir(item.id)">
	                                		<i class="fa fa-minus"></i>
                            			</button>                            			
                            		</td>
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
  name: 'Fornecedores',
  data () {
    return {
      service: genericService,
      restService: 'produto-service/',
      route: 'produto/fornecedores',
      itens: []
    }
  },
  mounted () {
    var me = this
    genericService.setBaseEndPoint(me.restService + me.route)
    me.carregarItens()
  },
  methods: {
	carregarItens () {
        var me = this
        me.service.findAll(function (retorno) {
        	me.itens = retorno;
        })
    },
    editar (id) {
    	var me = this;
    	me.$router.push({ path: '/' + me.route + '/' + id })
    },
    cadastrar () {
    	var me = this;
    	me.$router.push({ path: '/' + me.route + '/' + 'novo' })
    },
    excluir (id) {
    	var me = this;
    	var confirmacao = confirm('Deseja realmente excluir este ítem?');
    	if (confirmacao) {
        	me.service.excluir(id, function (retorno) {
        		alert('Ítem excluído com sucesso!');
        		location.reload();
//         		me.$forceUpdate();
            })
    	}
    },
    listarProdutos (id) {
    	var me = this;
    	me.$router.push({ path: '/' + me.route + '/' + id + '/produtos' })
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
