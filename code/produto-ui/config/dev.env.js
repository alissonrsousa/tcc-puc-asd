'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  PATH_WEB: '""', //Descomentar para WEB e comentar para a APK
  //CONTEXTO: '"http://localhost:8070/api"'
  CONTEXTO: '"http://localhost:8080/api"'
})
