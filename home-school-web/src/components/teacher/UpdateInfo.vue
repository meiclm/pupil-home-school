<template>
    <div>
      <form v-model="myTeacherId">
        <ul>
          <li>工号：<Input v-model="myTeacherId.id" disabled /></li>
          <li>姓名：<Input v-model="myTeacherId.name" /></li>
          <li>电话：<Input v-model="myTeacherId.telephone" /></li>
          <li>微信：<Input v-model="myTeacherId.wechat" /></li>
          <li>email：<Input v-model="myTeacherId.email" /></li>
        </ul>
        <br>
        <Button type="success" style="width: 200px;height: 40px;font-size: 16px;margin: 5px 30%;" @click="updateBtn(false)">更新</Button>
      </form>
    </div>
</template>

<script>
  import Axios from'axios'
  import Api from '../../server/api'
    export default {
      data(){
        return{
          myTeacherId:''
        }
      },
        methods:{
          updateBtn(){
            // alert("更新成功！");
            var that=this;
            Axios.post(Api.updateTeacher(that.myTeacherId.id,that.myTeacherId.name,
                                         that.myTeacherId.telephone,that.myTeacherId.wechat,
                                         that.myTeacherId.email),{
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function (response) {
              if (response.data==1){
                that.$Message.info('更新成功！');
                that.$router.push({
                  name:'information'
                })
              }
            }).catch(error => {
              console.log(error)
            });
          },
        },
      mounted(){
        this.myTeacherId=this.$route.params.teacher;
        // console.log("获取个人信息页面的老师对象:"+this.myTeacherId.name);
      }
    }
</script>

<style scoped>
li{
  font-size: 18px;
  list-style: none;
  padding-top: 10px;
}
</style>
