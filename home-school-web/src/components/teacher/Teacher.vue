<template>
  <div class="layout">
    <div style="float: left">
      <app-sidebar v-on:id="getTeacher"
                   v-on:class_no="getClassOrStudents"
                   v-on:s_no="getAllStudents"
                   v-on:new_message="getParentsMessage"></app-sidebar>
    </div>
    <div style="margin:0 auto 0 245px;padding: 15px">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
  import Sidebar from './Sidebar'
  import store from '../../vuex/store'

  export default {
    components:{
      'app-sidebar':Sidebar
    },
    data(){
      return{
        myTeacher:{
        }
      }
    },
    methods:{
      getTeacher(){
        console.log("取得该老师的全部基本信息");
        this.$router.push({name:'information'});
      },
      //未完成
      getClassOrStudents(){
        console.log("与这个老师相关的班级："+store.state.id);
        this.$router.push({
          name: 'classNo',
          params: {
            id:store.state.id
          }
        });
      },
      //未完成
      getAllStudents(){
        console.log("该老师的全部学生展示:");
        this.$router.push({
          name:'student',
          // 0 代表得到该老师的全部的学生
          params:{
            id:0
          }
        })
      },
      getParentsMessage(){
        this.$router.push({name:'message'});
      }
    },
    mounted(){
        // var userId = this.$store.state.id;
        console.log('VUEX',store);
        this.getTeacher();
    }
  }
</script>
<style>
.ivu-menu-item-group-title{
  font-size: 18px;
  font-weight: bold;
}
</style>
