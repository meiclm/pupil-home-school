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
        <TabPane label="登陆" name="first">
          <Form ref="user" :model="user_in" :rules="ruleInline">
            <br/>
            <br/>
            <br/>
            <FormItem prop="user">
              <Input type="text" style="height: 46px" v-model="user_in.username" placeholder="Username">
                <Icon type="ios-contact" size="30" slot="prepend"></Icon>
              </Input>
            </FormItem>
            <br/>
            <FormItem prop="password" style="height: 46px">
              <Input class="my-input" style="height: 46px" type="password" v-model="user_in.password" placeholder="Password">
                <Icon type="ios-lock" size="30" slot="prepend"></Icon>
              </Input>
            </FormItem>
            <br/>
          </Form>
        </TabPane>
        <TabPane label="注册" name="second">
          <Form :model="user_up" :label-width="80" :rules="ruleInline">
            <FormItem label="工号">
              <Input v-model="user_up.username" placeholder="Enter username..."></Input>
            </FormItem>
            <FormItem label="密码">
              <Input v-model="user_up.password" placeholder="Enter password..."></Input>
            </FormItem>
            <FormItem>
              <RadioGroup v-model="user_up.sex">
                <Radio label="1">女</Radio>
                <Radio label="0">男</Radio>
              </RadioGroup>
            </FormItem>
            <FormItem label="电话">
              <Input v-model="user_up.phone" placeholder="Enter password..."></Input>
            </FormItem>
          </Form>
        </TabPane>
      </Tabs>
    </Modal>
  </div>
</template>

<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  import store from '../../vuex/store'
    export default {
      data() {
        return {
          modal1: false,
          user: {},
          activeName: '',
          user_in: {
            id: '',
            username: '',
            password: '',
            flag: false
          },
          user_up: {
            username: '',
            password: '',
            phone: '',
            sex:''
          },
          // 规则
          ruleInline: {
            username: [
              {required: true, message: 'Please fill in the username', trigger: 'blur'}
            ],
            password: [
              {required: true, message: 'Please fill in the password.', trigger: 'blur'},
              {type: 'string', min: 6, message: 'The password length cannot be less than 6 bits', trigger: 'blur'}
            ]
          }
        }
      },
      methods: {
        ok() {
          let that = this;
          if (this.activeName === 'first') {
            //  登陆
            that.login();
          } else {
            that.register();
          }
        },
        cancel() {
          this.$Message.info('Clicked cancel' + this.modal1);
        },
        login() {
          var that = this;
          console.log("登陆请求！")
          Axios.post(Api.userSignIn(that.user_in.username, that.user_in.password), {
            /*表单提交的方式*/
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }).then(function (response) {
            if (response.data == 1) {
              that.user_in.id = that.user_in.username;
              store.commit('initCurrent', that.user_in);
              console.log('状态改变：', store.state, that.user_in);
              that.$emit("changeFlag", 1);
              that.$Message.info("登陆成功！");
              that.$router.push({name: 'teacher'});
            } else {
              that.$Message.info("密码或账户错误！");
            }
          });
        },
        register() {
          let that = this;
          console.log("男或者女："+this.user_up.sex);
          if (that.user_up.username.empty || that.user_up.password.empty || that.user_up.phone.empty) {
            alert("每一项不能为空！");
          } else if (that.user_up.password.length < 6 || that.user_up.password.length > 12) {
            alert("密码只能设置长度为6-12");
          } else if (that.user_up.phone.length != 11) {
            alert("电话号码不正确！");
          } else {
            //注册
            console.log("注册");
            Axios.post(Api.userSignUp(that.user_up.username, that.user_up.password, that.user_up.phone),
              {
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                }
              }).then(function (response) {
              console.log("注册返回的数据:" + response.data);
              that.$Message.info("注册成功！");
            }).catch(error => {
              console.log(error);
            });
          }
        }
      },
      created() {
        this.activeName = 'first';
      }
    }
</script>

<style>
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
.ivu-input,.ivu-input-default{
  height: 46px !important;
}
.ivu-form-item-content{
  text-align: center;
}
.ivu-radio-group{
  margin-left: 2px;
}
</style>
