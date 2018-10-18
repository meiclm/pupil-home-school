<template>
  <div>
    <Menu  active-name="1">
      <MenuGroup title="个人管理">
        <MenuItem name="1">
          <Icon type="logo-freebsd-devil" />
          <span @click="teacherId('1998090101')">
            个人信息
          </span>
        </MenuItem>
        <MenuItem name="2">
          <Icon type="ios-chatboxes-outline" />
          <span @click="getMessage">留言管理</span>
        </MenuItem>
      </MenuGroup>
      <MenuGroup title="教学管理">
        <MenuItem name="3">
          <Icon type="ios-people" />
          <span @click="classId('150842')">班级</span>
        </MenuItem>
        <MenuItem name="4">
          <Icon type="logo-tux" />
          <span @click="">学生成绩管理</span>
        </MenuItem>
      </MenuGroup>
    </Menu>
  </div>
</template>
<script>
  export default {
    data () {
      return {

      }
    },
    props:{

    },
    methods:{
      teacherId(id){
        console.log("执行中！"+id);
        this.$emit("id",id);
      },
      classId(cNo){
        this.$emit("class_no",cNo);
      },
      studentId(sNo){
        this.$emit("s_no",sNo);
      },
      getMessage(){
        this.$emit("new_message",1);
      }
    }
  }
</script>

<style scoped>

</style>
