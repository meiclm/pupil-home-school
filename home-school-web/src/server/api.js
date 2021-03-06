// 管理所有后台请求
// 定义请求路径形式
const root='http://localhost:8080';

const Api={
    // 注册
    'userSignUp':(username,password,phone) => `${root}/teacher/sign-up?username=${username}
    &password=${password}&phone=${phone}`,
  //登陆
  'userSignIn':(username,password) =>`${root}/sign-in?username=${username}&password=${password}&status=${1}`,
  //查找班级
  'findClassByClassNo':(classNo) =>`${root}/class?classNo=${classNo}`,
  //查找一门课的所有班级
  'findClassByCno':(c_no) =>`${root}/class?c_no=${c_no}&t_id=${id}`,

  //查找一个学生
  'findStudent':(s_no) =>`${root}/student?s_no=${s_no}`,
  //查找一门课的所有学生
  'findAllStudentByCno':(c_no,t_no) =>`${root}/student?c_no=${c_no}&t_no=${t_no}`,
//  查找该学生的家长
  'findParentsByStudent':(s_no) =>`${root}/parents?s_no=${s_no}`,
  // 查找该学生的所有成绩
  'findAllScore':(s_no) =>`${root}/student/allTerm?s_no=${s_no}`,

  // 找到该老师
  'findTeacher':(t_id) => `${root}/teacher?id=${t_id}`,
  /*查找该老师教的所有的班级*/
  'findAllClass':(t_id) =>`${root}/teaching/class?t_id=${t_id}`,
  /*查找该班级下的所有学生*/
  'findThisClassStus':(c_id)=>`${root}/class/students?c_id=${c_id}`,
// 修改个人信息
  'updateTeacher':(t_id,name,telephone,wechat,email)=>`${root}/teacher/update?t_id=${t_id}&name=${name}&telephone=${telephone}&wechat=${wechat}&email=${email}`,
  'getMessage':(t_id)=>`${root}/message?t_id=${t_id}`,
  'addMessage':(t_id,p_id,message)=>`${root}/message/send?t_id=${t_id}&phone=${p_id}&message=${message}}`
};
export default Api;//Api暴露出去
