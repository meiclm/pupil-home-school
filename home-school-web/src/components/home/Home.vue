<template>
<div>
  <app-header/>
  <router-view></router-view>
</div>
</template>

<script>
  import Header from './Header'
    export default {
        name: "Home",
      components:{
        "app-header":Header
      },
      created(){
      }
    }
</script>

<style scoped>

</style>
