<template>
    <div>
      <Form :model="thisUser" :label-width="180">
        <FormItem label="接收人">
          <Input v-model="thisUser.p_id" placeholder="电话"></Input>
        </FormItem>
        <FormItem label="内容：">
          <Input element-id="txt" v-model="thisUser.message" type="textarea" ></Input>
        </FormItem>
        <FormItem label="">
        <div align="center">
          <Button style="width: 120px;height: 40px" type="primary" @click="sendMessage">发送</Button>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <Button style="width: 120px;height: 40px">取消</Button>
        </div>
        </FormItem>
      </Form>
      <!--<form v-model="thisUser" style="font-size: 16px" >-->
        <!--<br>-->
        <!--接收人的电话：<Input v-model="thisUser.p_id"></Input>-->
        <!--<br><br>-->
        <!--内容：<Input element-id="txt" v-model="thisUser.message" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入留言信息" ></Input>-->
        <!--<input hidden placeholder="发送人id" v-model="thisUser.t_id"/>-->
        <!--<input hidden placeholder="发送时间" v-model="thisUser.send_time"/>-->
        <!--<input hidden placeholder="发送时间" v-model="thisUser.send_reci"/>-->
        <!--<br><br>-->
        <!--<div align="center">-->
          <!--<Button style="width: 120px;height: 40px" type="primary" @click="sendMessage">发送</Button>-->
          <!--&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-->
          <!--<Button style="width: 120px;height: 40px">取消</Button>-->
        <!--</div>-->
      <!--</form>-->
      <Divider>家长留言板显示</Divider>
      <div>
        <ul>
          <li v-for="leave_word in leave_words" style="list-style: circle">
            <Card :bordered="false">
              <p slot="title">{{leave_word.parents.name}}：{{leave_word.send_time}}+{{leave_word.parents.phone}}</p>
              <div>
                <p>{{leave_word.message}}</p>
                <Button type="primary" @click="replyParent(leave_word.parents.phone)" style="margin-left: 70%">回复</Button>
              </div>
            </Card>
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
          },
          remark:'',
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
            console.log("获取留言信息："+response.data);
            that.leave_words=response.data;
          })
        },
        replyParent(phone){
          this.thisUser.p_id=phone;
          this.thisUser.t_id=store.state.id;
          //1代表发送者，2代表接收者
          this.thisUser.send_reci=1;
          //文本框获得焦点
          document.getElementById("txt").focus();
          console.log("接收人的电话："+this.thisUser.p_id);
        },
        sendMessage(){
          // console.log(this.thisUser.send_reci+"老师写好的信息："+this.thisUser.message);
          let that=this;
          this.thisUser.t_id=store.state.username;
          Axiox.post(Api.addMessage(that.thisUser.t_id,that.thisUser.p_id,that.thisUser.message),{
            header:{
              'Content-Type': 'application/x-www-form-urlencoded',
              // 'Access-Control-Allow-Origin': '*'
            }
          }).then(function (response) {
            console.log(response.data==1);
            if (response.data==1) {
              that.$Message.info("回复成功！");
            }
          })
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
