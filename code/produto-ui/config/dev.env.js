'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  AUTHORIZATION_SERVER: '"http://localhost:9092"',
  CONTEXTO: '"http://localhost:8080"'
})
