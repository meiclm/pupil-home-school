<template>
    <div class="user-signIn">
      <Form ref="user" :model="user" :rules="ruleInline">
        <br/>
        <br/>
        <br/>
        <FormItem prop="user">
          <Input type="text" style="height: 46px" v-model="user.username" placeholder="Username">
            <Icon type="ios-contact" size="30" slot="prepend"></Icon>
          </Input>
        </FormItem>
        <br/>
        <FormItem prop="password" style="height: 46px">
          <Input class="my-input" style="height: 46px" type="password" v-model="user.password" placeholder="Password">
            <Icon type="ios-lock" size="30" slot="prepend"></Icon>
          </Input>
        </FormItem>
        <br/>
      </Form>
    </div>
</template>

<script>
import Api from '../../server/api'
import Axios from 'axios'
    export default {
      data () {
        return {
          user: {
            username: '',
            password: '',
            info:'1'
          },
          // 规则
          ruleInline: {
            username: [
              { required: true, message: 'Please fill in the username', trigger: 'blur' }
            ],
            password: [
              { required: true, message: 'Please fill in the password.', trigger: 'blur' },
              { type: 'string', min: 6, message: 'The password length cannot be less than 6 bits', trigger: 'blur' }
            ]
          }
        }
      },
      methods: {
        signIn(){
          Axios.get()
        }
      }
    }
</script>

<style>
.ivu-input,.ivu-input-default{
  height: 46px !important;
}
.ivu-form-item-content{
  text-align: center;
}
</style>
