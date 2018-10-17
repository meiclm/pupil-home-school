<template>
  <div>
    <Row>
      <Col span="3">col-12</Col>
      <Col span="3">col-12</Col>
    </Row>
  </div>
</template>

<script>
  import Api from '../../server/api'
  import Axios from 'axios'
  import store from '../../vuex/store'
    export default {
        data(){
          return{
            classList:[]
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
              console.log("该老师教的所有班级，该老师管理的班级"+response);
              that.classList=response.data;
            })
          }
      },
      mounted(){
          this.getAllClass(store.state.id);
      }
    }
</script>

<style scoped>

</style>
