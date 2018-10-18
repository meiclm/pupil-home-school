<template>
    <div class="my-second-btn">
      <Dropdown >
        <a href="javascript:void(0)">
          <span style="color: white;font-size: 16px">{{user.username}}</span>
          <Icon type="ios-arrow-down"></Icon>
        </a>
        <DropdownMenu slot="list">
          <DropdownItem><span @click="logout">注销</span></DropdownItem>
        </DropdownMenu>
      </Dropdown>
    </div>
</template>

<script>
  import store from '../../vuex/store'
    export default {
        data(){
          return{
            user:{}
          }
        },
      methods:{
          logout(){
            console.log("清空，路由跳转");
            store.commit("cleanCurrent");
            this.$router.push({
              name:'first',
            });
          },
      },
      mounted(){
          this.user=store.state;
      }
    }
</script>

<style>
.my-second-btn{
  float: right;
}
</style>
