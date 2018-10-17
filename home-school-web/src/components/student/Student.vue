<template>

<div class="student-main">
  <p>学生的姓名：{{student_data.name}}</p>
</div>
</template>
<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  export default {
    data () {
      return {
        student_data:'',
      }
    },
    methods:{
      getStudentAllScore(id){
        console.log("该学生的id:"+id);
        let that=this;
        Axios.get(Api.findAllScore(id),
        {
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              }
            }).then(function(response){
              console.log("数据展示："+response.data);
              that.student_data=response.data;
            })
      },

    },
    mounted(){
        // var id=this.$router.param.id;
      let that=this;
      console.log("获取路由参数："+that.$route.params.id);
      var num=that.$route.params.id
        this.getStudentAllScore(that.$route.params.id);
      }

  }
</script>

<style scoped>

</style>
