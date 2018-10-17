<template>
    <Header>
      <div>
        <user-dialog></user-dialog>
      </div>
    </Header>
</template>
<script>
  import UserDialog from '../user/UserDialog'
export default {
    data(){
      return{
        search_content:''
      }
    },
    components:{
      "user-dialog":UserDialog,
    },
  methods:{

  }
}
</script>
<style>
</style>

