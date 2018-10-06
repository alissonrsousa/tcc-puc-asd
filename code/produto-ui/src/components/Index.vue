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
                <a class="navbar-brand" href="index.html">LOGO</a>
                <a class="navbar-brand" href="index.html">Roça Virtual</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            	Olá, faça seu login ou cadastre-se
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#/login"><i class="fa fa-user fa-fw"></i> Entrar</a>
                        </li>
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Cadastrar</a>
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
                            <a href="#"><i class="fa fa-table fa-fw"></i> Produtos Orgânicos<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Verduras</a>
                                </li>
                                <li>
                                    <a href="flot.html">Frutas</a>
                                </li>
                                <li>
                                    <a href="morris.html">Legumes</a>
                                </li>    
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Doces<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Tradicionais</a>
                                </li>
                                <li>
                                    <a href="morris.html">Diet</a>
                                </li>
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>                                                                    
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>                         
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Queijos<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Queijos</a>
                                </li>
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>                                                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Verduras<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Verduras</a>
                                </li>
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>                                                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Frutas<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Frutas</a>
                                </li>  
                                <li>
                                    <a href="morris.html">Promoções</a>
                                </li>                                                             
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Promoções<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Clientes</a>
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

	}
	
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>