import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

/* state 在 vuex 中用于存储数据，表示一个状态*/
/*flag的状态为0=>未登录 1=>登陆*/
var state={
  id:'',
  username:'登陆 | 注册',
  password:'',
  flag:true
};
/* mutations 中存放方法 用来改变 state 的数据*/
var mutations={
  initCurrent(state,payload){
    console.log("store更新状态 ！");
    state.id=payload.id;
    state.username=payload.username;
    state.password=payload.password;
    state.flag=payload.flag;
  },
  cleanCurrent(state){
    console.log("store初始化 ！");
    state.id='';
    state.username='';
    state.password='';
    state.flag=true;
  }
}
//vuex
const store=new Vuex.Store({
  state,
  mutations:mutations
});
export default store;

