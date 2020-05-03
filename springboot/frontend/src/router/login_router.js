import LoginForm from '@/components/Login/LoginForm'
import RegistForm from '@/components/Login/RegistForm'

const login_chk = (to,state,next) => {
  if(localStorage.token == '' || localStorage.token == undefined){    
    next();
  }else{
    alert('로그인 되어있습니다.');
    next('/');
  }
}

export default[

    {
      path: '/login',
      name: 'LoginForm',      
      component: LoginForm,
      beforeEnter:login_chk
    },
    {
      path: '/usr/regist',
      name: 'RegistForm',
      component: RegistForm,
      beforeEnter:login_chk
    }
    
]