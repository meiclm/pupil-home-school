<template>
  <div>
    <div class="my-button" style="cursor: pointer">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <Icon type="md-contacts" style="color: white" size="23" />
      <span  class="my-login"  @click="modal1 = true">教职工登陆入口</span>
    </div>

    <Modal
      v-model="modal1"
      title="中北小学系统登陆|注册"
      @on-ok="ok"
      @on-cancel="cancel"
      v-bind:ok-text="activeName==='first'?'登陆':'注册'"
      >
      <Tabs type="card" v-model="activeName">
        <TabPane label="登陆" name="first"><user-sign-in ref="childrenIn"></user-sign-in></TabPane>
        <TabPane label="注册" name="second"><user-sign-up ref="childrenUp"></user-sign-up></TabPane>
      </Tabs>
    </Modal>
  </div>
</template>

<script>
  import UserSignIn from './UserSignIn'
  import UserSignUp from './UserSignUp'
    export default {
        name: "UserDialog",
      data () {
        return {
          modal1: false,
          user:{},
          activeName:''
        }
      },
      components:{
         UserSignIn,
        UserSignUp
      },
      methods:{
        ok () {
          let that=this;
          if (this.activeName==='first'){
          //  登陆
            this.$refs.children.signIn;
          }else {
            this.$refs.childrenUp.signUp;
          }
          this.$Message.info((that.activeName=='first'?'登陆':'注册'));
        },
        cancel () {
          this.$Message.info('Clicked cancel'+this.modal1);
        },
      },
      created() {
        this.activeName = 'first';
      }
    }
</script>

<style scoped>
.my-login{
  /*background-color: rgba(4,151,25,0.78);*/
  /*border-color: rgba(4,151,25,0.78);*/
  font-size: 14px;
  color:  #fff;
  /*padding: 8px 23px;*/
}
  .my-button{
    float: right;
  }
.my-button:hover{
  text-underline-style: single;
}
</style>
