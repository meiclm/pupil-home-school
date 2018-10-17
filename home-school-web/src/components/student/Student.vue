<template>

<div class="student-main">
  <p>{{s_no}}&nbsp;{{s_name}}</p>
  <Table :columns="columns1" :data="data1"></Table>
</div>
</template>
<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  export default {
    data () {
      return {
        columns1: [
          {
            title:'科目',
            key:'name'
          },
          {
            title: '成绩',
            key: 'grade'
          },
          {
            title: '学期',
            key: 'term'
          }
        ],
        data1:[],
        s_no:'',
        s_name:''
      }
    },
    methods:{
      getStudentAllScore(id){
        console.log("该学生的id:"+id)
        let that=this;
        Axios.get(Api.findAllScore(id),
        {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function(response){
              console.log("数据展示："+response.data);
              that.data1=response.data;
              // that.s_no=that.data1[0].s_no;
              // that.s_name=that.data1[0].s_no
            })
      },
      //未完成，取得该老师的全部学生
      getAllStudents(t_id){
        var that=this;
        Axios.get(t_id).then(function (response) {
        })
      }
    },
    mounted(){
        // var id=this.$router.param.id;
      let that=this;
      console.log("获取路由参数："+that.$route.params.id);
      var num=that.$route.params.id
      if (num==='0'){

      } else {
        this.getStudentAllScore(that.$route.params.id);
      }

    }
  }
</script>

<style scoped>

</style>
