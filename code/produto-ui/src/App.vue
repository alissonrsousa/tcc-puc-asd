<template>
	<div id="app">
	  <router-view></router-view>
	</div>
</template>

<script>
import jquery from '@/static/jquery/jquery.min.js'
import bootstrap from '@/static/bootstrap/js/bootstrap.min.js'
import metisMenu from '@/static/metisMenu/metisMenu.min.js'
import sb_admin from '@/static/sb-admin-2/js/sb-admin-2.js'

export default {
  name: 'App'
};
</script>

<style>
	@import 'static/bootstrap/css/bootstrap.min.css';
	@import 'static/metisMenu/metisMenu.min.css';
	@import 'static/morrisjs/morris.css';
	@import 'static/font-awesome/css/font-awesome.min.css';
	@import 'static/sb-admin-2/css/sb-admin-2.css';
  	@import 'static/datatables-plugins/dataTables.bootstrap.css';
 	@import 'static/datatables-responsive/dataTables.responsive.css';
</style>
