<template>
  <Form :model="user" :label-width="80">
    <FormItem label="工号">
      <Input v-model="user.username" placeholder="Enter username..."></Input>
    </FormItem>
    <FormItem label="密码">
      <Input v-model="user.password" placeholder="Enter password..."></Input>
    </FormItem>
    <FormItem label="确认密码">
      <Input v-model="user.password" placeholder="Enter password..."></Input>
    </FormItem>
    <FormItem label="电话">
      <Input v-model="user.phone" placeholder="Enter password..."></Input>
    </FormItem>
  </Form>
</template>
<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  export default {
    data () {
      return {
        user: {
          username: '',
          password:'',
          phone: '',
        }
      }
    },
    methods:{
      signUp(){
        let that=this;
        if (that.user.username.empty||that.user.password.empty||that.user.phone.empty){
          alert("每一项不能为空！");
        }else if (that.user.password.length<6||that.user.password.length>12) {
          alert("密码只能设置长度为6-12");
        }else if (that.user.phone.length!=11){
          alert("电话号码不正确！");
        } else{
          //注册
          Axios.post(Api.userSignUp(that.user.username,that.user.password,that.user.phone),
            {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function (response) {
            console.log("注册返回的数据:"+response.data);
          }).catch(error => {
            console.log(error);
          });
        }
      }
    }
  }
</script>

