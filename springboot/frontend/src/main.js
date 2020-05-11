// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//import VueRouter from 'vue-router'
import BootstrapVue from 'bootStrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import axios from 'axios'
import { store } from './store/store.js'

axios.defaults.headers.common['access_token'] = 'a'

Vue.prototype.$http = axios
Vue.config.productionTip = false
Vue.use(BootstrapVue)
var Paginate = require('vuejs-paginate')
Vue.component('paginate', Paginate)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  render: h=> h(App)
})
