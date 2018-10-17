<template>
    <div>
      <Card :bordered="false">
        <p slot="title" style="font-size: 16px" v-text="myTeacher.name"></p>
        <div>
          <div class="demo-split">
            <Split v-model="split2" mode="vertical">
              <div slot="top" class="demo-split-pane">
                性别：<span v-text="myTeacher.sex==1?'男':'女'"></span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                工号：{{myTeacher.id}}<br><br>
                职位：<span v-if="myTeacher.admin==1">有职位</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                教学科目：<span>{{myTeacher.teaching}}</span>
              </div>
              <div slot="bottom" class="demo-split-pane">
                邮箱：{{myTeacher.email}}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                微信：{{myTeacher.wechat}}
              </div>
            </Split>
          </div>
          <br>
          <div style="padding-left: 600px">
            <Button class="myButton" type="success" @click="updateInfo">修改个人信息</Button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Button class="myButton" type="info" @click="updatePassword">修改密码</Button>
          </div>
        </div>
      </Card>
    </div>


</template>

<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  import store from '../../vuex/store'

    export default {
      data(){
        return{
          myTeacher:{},
          split2: 0.5
        }
      },
      methods:{
        showInfo(){
          let that = this;
          Axios.get(Api.findTeacher(store.state.id),
            {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function (response) {
            that.myTeacher = response.data;
            console.log(that.myTeacher);
          }).catch(function (error) {
            console.log(error)
          })
        },
        updateInfo(){
          var that=this;
          this.$router.push({
            name:'updateInfo',
            params:{
              teacher:that.myTeacher
            }
          })
        },
        updatePassword(){

        }
      },
      mounted(){
        this.showInfo();
      }
    }
</script>

<style>
  .demo-split{
    height: 200px;
    border: 1px solid #dcdee2;
  }
  .demo-split-pane{
    padding: 10px;
    font-size: 16px;
  }
  .myButton{
    width: 120px;
    font-size: 15px;
    height: 40px;
  }
</style>
