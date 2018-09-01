<template>

	<div id="page-wrapper">
<!-- 	    <div class="row"> -->
<!-- 	        <div class="col-lg-12"> -->
<!-- 	            <h1 class="page-header">Fornecedores</h1> -->
<!-- 	        </div> -->
<!-- 	        /.col-lg-12 -->
<!-- 	    </div> -->
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default" style="margin-top: 20px;">
	                <div class="panel-heading">
	                    Fornecedores
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
	                                <th>Código</th>
	                                <th>Nome</th>
	                                <th>CNPJ</th>
	                                <th>Cidade</th>
	                                <th>Telefone</th>
	                                <th>Contato</th>
	                                <th>Ações</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr class="odd gradeX" v-for="item in itens" :key="item.id">
	                                <td class="center">{{item.id}}</td>
	                                <td>{{item.nomeFantasia}}</td>
	                                <td class="center">{{item.cnpj}}</td>
	                                <td>{{item.cidade}}</td>
	                                <td class="center">{{item.telafone1}}</td>
	                                <td>{{item.contato}}</td>
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
import fornecedorService from '@/services/fornecedorService'

export default {
  name: 'Fornecedores',
  data () {
    return {
      itens: []
    }
  },
  mounted () {
    var me = this
    me.carregarItens()
  },
  methods: {
	carregarItens () {
        var me = this
        fornecedorService.findAll(function (retorno) {
        	me.itens = retorno;
        })
    },
    editar (id) {
    	var me = this;
    	me.$router.push({ path: '/produto/fornecedores/' + id })
    },
    cadastrar () {
    	var me = this;
    	me.$router.push({ path: '/produto/fornecedores/novo' })
    },
    excluir (id) {
    	var me = this;
    	var confirmacao = confirm('Deseja realmente excluir este ítem?');
    	if (confirmacao) {
        	fornecedorService.excluir(id, function (retorno) {
        		alert('Ítem excluído com sucesso!');
        		location.reload();
//         		vm.$forceUpdate();
            })
    	}
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
