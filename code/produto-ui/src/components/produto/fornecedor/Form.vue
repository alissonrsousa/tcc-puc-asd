<template>

   <div id="page-wrapper">
       <!-- /.row -->
       <div class="row">
           <div class="col-lg-12">
               <div class="panel panel-default" style="margin-top: 20px;">
                   <div class="panel-heading">
                       Fornecedor: Fazenda da Mata
                   </div>
                   <div class="panel-body">
                       <div class="row">
                           <div class="col-lg-6">
                               <form role="form">
                                   <div class="form-group">
                                       <label>CNPJ/CPF</label>
                                       <input class="form-control" v-model="item.cnpj">
                                       <label>Nome Fantasia</label>
                                       <input class="form-control" v-model="item.nomeFantasia"> 
                                       <label>Razão Social</label>
                                       <input class="form-control" v-model="item.razaoSocial">  
                                       <label>Email</label>
                                       <input class="form-control" v-model="item.email"> 
                                       <label>Contato</label>
                                       <input class="form-control" v-model="item.contato"> 
                                       <label>Função Contato</label>
                                       <input class="form-control" v-model="item.funcaoContato">                                                                             
                                   </div>                                 
                                   <button type="submit" class="btn btn-default" @click="salvar()">Salvar</button>
                                   <button type="reset" class="btn btn-default" @click="cancelar()">Cancelar</button>
                               </form>
                           </div>
                           <!-- /.col-lg-6 (nested) -->
                       </div>
                       <!-- /.row (nested) -->
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
  name: 'EditFornecedor',
  data () {
    return {
      item: {}
    }
  },
  mounted () {
    var me = this
    me.carregarItem()
  },
  methods: {
	carregarItem () {
        var me = this;
        var id = me.$route.params.id;
        
        if (id != 'novo') {
            fornecedorService.findById(id, function (retorno) {
            	me.item = retorno;
            })
        }
    },
    cancelar () {
    	var me = this;
    	me.$router.push({ path: '/produto/fornecedores'})
    },
    salvar () {
    	var me = this;
        fornecedorService.salvar(me.item, function (retorno) {
			var acao = me.item.id ? 'atualizado' : 'cadastrado';
        	alert('Fornecedor ' + acao + ' com sucesso!');
        	me.$router.push({ path: '/produto/fornecedores'})
        })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
