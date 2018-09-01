<template>

	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header">Fornecedores</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    DataTables Advanced Tables
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
  computed: {
    user () {
      return this.$auth.user()
    }
  },
  methods: {
	  carregarItens () {
        var me = this
        fornecedorService.findAll(function (retorno) {
        	me.itens = retorno;
          console.log(retorno)
        })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
