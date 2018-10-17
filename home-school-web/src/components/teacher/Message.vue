<template>
    <div>
      <form v-model="thisUser" style="font-size: 16px">
        <br>
        接收人的电话：<Input v-model="thisUser.p_id"></Input>
        <br><br>
        内容：<Input element-id="txt" v-model="thisUser.message" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入留言信息" ></Input>
        <input hidden placeholder="发送人id" v-model="thisUser.t_id"/>
        <input hidden placeholder="发送时间" v-model="thisUser.send_time"/>
        <br><br>
        <div align="center">
          <Button style="width: 120px;height: 40px" type="primary">发送</Button>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <Button style="width: 120px;height: 40px">取消</Button>
        </div>
      </form>
      <div>
        <ul>
          <li v-for="leave_word in leave_words">
            <span>名字+（孩子）+时间</span>
            <p>内容{{leave_word,message}}</p>
            <div> <Button @click="replyParent(leave_word.phone)">回复</Button></div>
          </li>
        </ul>
      </div>
    </div>
</template>

<script>
  import store from '../../vuex/store'
  import Axiox from'axios'
  import Api from '../../server/api'
    export default {
      data(){
        return{
          thisUserId:'',
          thisUser:{
            t_id:'',
            p_id:'',
            message:'',
            send_time:'',
            send_reci:''
          },
          leave_words:[]
        }
      },
      methods: {
        getAllMessage(){
          var that=this;
          Axiox.get(Api.getMessage(that.thisUserId),{
            headers:{
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }).then(function (response) {
            console.log("获取留言信息："+response.data)
          })
        },
        replyParent(phone){
          this.thisUser.p_id=phone;
          this.thisUser.t_id=store.state.id;
          //1代表发送者，2代表接收者
          this.thisUser.send_reci=1;
          //文本框获得焦点
          document.getElementById("txt").focus();
        }
      },
      mounted(){
        this.thisUserId=store.state.id;
        this.getAllMessage();
      }
    }
</script>

<style scoped>

</style>
