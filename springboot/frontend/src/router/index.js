import Vue from 'vue'
import Router from 'vue-router'
//import HelloWorld from '@/components/HelloWorld'
//import Header from '@/components/Header'

import board_router from '@/router/board_router'
import login_router from '@/router/login_router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    ...board_router,
    ...login_router
  ] 
})
