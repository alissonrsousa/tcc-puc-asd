<template>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="text-align: center;">LOGO</h3><br/>
                        <h3 class="panel-title" style="text-align: center;">Roça Virtual</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" v-model="usuario" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" v-model="senha" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Lembrar usuário
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a class="btn btn-lg btn-success btn-block" @click="login">Login</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script>
import segurancaService from '@/services/segurancaService'

export default {
  name: 'Login',
  data () {
    return {
      usuario: "",
      senha: ""
    }
  },
  methods: {
	login () {
		var me = this;
		segurancaService.login(me.usuario, me.senha);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
