<template>
  <div>
    <Collapse v-model="value1">
      <Panel name="1">
        {{classList.classNo}}
        <p slot="content"></p>
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
            classList:[],
            msg:'',
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
              console.log("该老师教的所有班级，该老师管理的班级"+response.data);
              if (response.data==null){
                that.msg="您没有教学的班级！"
              } else {
                that.classList=response.data;
              }

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
