<template>
  <div id="app">

    <div id="header">
        <MainHeader/>
    </div>

    <b-container cols="8">
      <router-view />
    </b-container>
    <!--
    <div id="footer">
      <MainFooter/>
    </div>
    -->
  </div>
</template>



<script>
import MainHeader from './components/Header.vue'
import MainFooter from './components/Footer.vue'
export default {
   name: 'App',
   components : {
     MainHeader,
     MainFooter
   }
}
</script>

<style>
  .container{margin-top:5%;}
  html,body{height: 100%;}
</style>
