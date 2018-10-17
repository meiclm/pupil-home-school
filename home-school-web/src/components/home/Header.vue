<template>
    <Header>
      <div>
        <user-dialog v-show="visible1" @changeFlag = 'changeFlag'></user-dialog>
        <user-logout v-show="!visible1"></user-logout>
      </div>
    </Header>
</template>
<script>
  import store from '../../vuex/store'
  import LogOut from '../user/Logout'
  import UserDialog from '../user/UserDialog'
export default {
    data(){
      return{
        search_content:'',
        visible1:true,
      }
    },
    components:{
      "user-dialog":UserDialog,
      "user-logout":LogOut
    },
   methods:{
    changeFlag:function () {
      /*visible*/
      this.visible1=store.state.flag;
      console.log("查看状态："+this.visible1)
    }
  },

}
</script>
<style>
</style>

