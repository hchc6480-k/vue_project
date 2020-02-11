<template>
  <div id="app">
    <div id="header">
        <MainHeader/>
    </div>
    <router-view/>
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

</style>
