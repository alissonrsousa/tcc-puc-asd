<template>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Roça Virtual</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> {{usuario.nome}}</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#" @click="sair()"><i class="fa fa-sign-out fa-fw"></i> Sair</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Produto<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Categorias</a>
                                </li>
                                <li>
                                    <router-link to="/produto/fornecedores">Fornecedores</router-link>
                                </li>
                                <li>
                                    <a href="morris.html">Produtos</a>
                                </li>    
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Segurança<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Módulo</a>
                                </li>
                                <li>
                                    <a href="morris.html">Função</a>
                                </li>    
                                <li>
                                    <a href="morris.html">Grupo Usuários</a>
                                </li>
                                <li>
                                    <a href="morris.html">Usuários</a>
                                </li>                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>                         
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Cliente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Clientes</a>
                                </li>                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Loja<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Formas Pagamento</a>
                                </li>
                                <li>
                                    <a href="morris.html">Vendedores</a>
                                </li>    
                                <li>
                                    <a href="morris.html">Pedidos</a>
                                </li>
                                <li>
                                    <a href="morris.html">Propagandas</a>
                                </li> 
                                <li>
                                    <a href="morris.html">Dúvidas</a>
                                </li>                                                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>                                                
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <router-view></router-view>

    </div>
    <!-- /#wrapper -->

</template>

<script>
import segurancaService from '@/services/segurancaService'

export default {
  name: 'Index',
  data () {
    return {
      usuario: {},
    }
  },
  mounted () {
    var me = this
    me.atualizarDadosUsuario()
  },  
  methods: {
	sair () {
      var me = this;
      console.log('sair');
      segurancaService.sair();
	},
	
	atualizarDadosUsuario () {
	  var me = this;
	  segurancaService.findDadosUsuario(function (retorno) {
		  if(!retorno || retorno == "") {
			  me.$router.push({ path: '/login'});
		  }
		  else {
			  me.usuario = {nome : retorno};
		  }
	  });
	}
	
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
