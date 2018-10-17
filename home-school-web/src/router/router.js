import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import Home from '../components/home/Home'
//二级路由
import Teacher from '../components/teacher/Teacher'
import FirstContent from '../components/home/FirstContent'

//三级路由
import Information from '../components/teacher/Information'
import UpdateInfo from '../components/teacher/UpdateInfo'
import ClassNo from '../components/student/ClassNo'
import Student from '../components/student/Student'
import Content from '../components/teacher/Content.vue'
import Message from '../components/teacher/Message'

export default new VueRouter({
  routes:[
    {path:'/',component:Home,children:[
        {path:'/index',name:'first',component:FirstContent},
        {path:'/teacher',name:'teacher',component:Teacher,children:[
            {path:'/teacher/info',component:Information,name: 'information'},
            {path:'/teacher/updateInfo',component:UpdateInfo,name:'updateInfo'},
            {path:'/teacher/classNo',component:ClassNo,name: 'classNo'},
            {path:'/teacher/content:id',component:Content,name: 'content'},
            {path:'/teacher/student:id',component:Student,name: 'student'},
            {path:'/teacher/message',component:Message,name: 'message'}
          ]}
      ]}
    ],
  mode:'history'
})



