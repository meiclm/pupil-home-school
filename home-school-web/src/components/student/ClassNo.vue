<template>
  <div>
    <Collapse v-model="value1">
      <Panel name="1" v-for="c in classList" >
        <span @click="getThisClassStudent(c.classNo)">{{c.classNo}}</span>
        <div slot="content">
          <ul>
            <li id="students-list" v-for="student in students" style="list-style: disc" @click="getStudent(student.id)">
              <!--  -->
              <div style="display: inline-block;width: 200px">学号：{{student.id}}</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div style="display: inline-block;width: 200px">姓名：{{student.name}}</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <div style="display: inline-block;width: 200px">性别：{{student.sex}} </div>
            </li>
          </ul>
        </div>
      </Panel>
    </Collapse>
  </div>
</template>

<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  import store from '../../vuex/store'
    export default {
        data(){
          return{
            classList:'',
            msg:'',
            value1:'',
            students:''
          }
        },
      methods:{
          getAllClass(s_id){
            let that=this;
            Axios.get(Api.findAllClass(s_id),{
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function (response) {
              if (response.data==null){
                that.msg="您没有教学的班级！"
              } else {
                that.classList=response.data;
              }
            })
          },
        getThisClassStudent(c_id){
          let that=this;
          Axios.get(Api.findThisClassStus(c_id),{
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }).then(function (response) {
            console.log("这个班级的学生"+response.data);
            that.students=response.data;
          })
        },
        getStudent(id){
            this.$router.push({
              name: 'student',
              params:{
                id:id
              }
            })
        }
      },
      mounted(){
          this.getAllClass(store.state.id);
      }
    }
</script>

<style>
#students-list:hover{
  background-color: rgba(56,80,151,0.25);
  cursor: pointer;
}
</style>
