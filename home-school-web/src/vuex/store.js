import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

/* state 在 vuex 中用于存储数据，表示一个状态*/

var state={
  id:'1998090101',
  username:'登陆 | 注册',
  password:''
};
/* mutations 中存放方法 用来改变 state 的数据*/
var mutations={
  initCurrent(state,payload){
    console.log("store更新状态 ！");
    state.id=payload.id;
    state.username=payload.username;
    state.password=payload.password;
  }
}
//vuex
const store=new Vuex.Store({
  state,
  mutations:mutations
});
export default store;

