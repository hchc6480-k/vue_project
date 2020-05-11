import Read from '@/components/Board/Read'
import Create from '@/components/Board/Create'
import Detail from '@/components/Board/Detail'

const login_chk = (to,state,next) => {
  if(localStorage.token == '' || localStorage.token == undefined){    
    alert('로그인이 필요합니다.');
    next('/');
  }else{    
    next();
  }
}

export default[

    {
      path: '/read/:page',
      name: 'Read',
      component: Read
    },
    {
      path: '/create',
      name: 'Create',
      component: Create,
      beforeEnter:login_chk
    },
    {
      path: '/detail/:contentId',
      name: 'Detail',
      component: Detail
    }
    
]