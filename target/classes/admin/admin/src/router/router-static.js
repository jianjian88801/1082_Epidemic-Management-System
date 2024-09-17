import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import huanzhe from '@/views/modules/huanzhe/list'
    import miqiejiechuzhe from '@/views/modules/miqiejiechuzhe/list'
    import quezhenhuanzhe from '@/views/modules/quezhenhuanzhe/list'
    import siwanghuanzhe from '@/views/modules/siwanghuanzhe/list'
    import yuangong from '@/views/modules/yuangong/list'
    import zhiliaoxinxi from '@/views/modules/zhiliaoxinxi/list'
    import zhiyuhuanzhe from '@/views/modules/zhiyuhuanzhe/list'
    import dictionaryMiqiejiechuzheGeli from '@/views/modules/dictionaryMiqiejiechuzheGeli/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryZhongzheng from '@/views/modules/dictionaryZhongzheng/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryMiqiejiechuzheGeli',
        name: '隔离类型',
        component: dictionaryMiqiejiechuzheGeli
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryZhongzheng',
        name: '是否重症',
        component: dictionaryZhongzheng
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/huanzhe',
        name: '患者',
        component: huanzhe
      }
    ,{
        path: '/miqiejiechuzhe',
        name: '密切接触者',
        component: miqiejiechuzhe
      }
    ,{
        path: '/quezhenhuanzhe',
        name: '确诊患者',
        component: quezhenhuanzhe
      }
    ,{
        path: '/siwanghuanzhe',
        name: '死亡患者',
        component: siwanghuanzhe
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }
    ,{
        path: '/zhiliaoxinxi',
        name: '治疗信息',
        component: zhiliaoxinxi
      }
    ,{
        path: '/zhiyuhuanzhe',
        name: '治愈患者',
        component: zhiyuhuanzhe
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
