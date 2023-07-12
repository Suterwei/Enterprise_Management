import Vue from 'vue'
import VueRouter from 'vue-router'
import Center from '../views/Center.vue'
import Enterprise from '../views/Enterprise.vue'
import Organization from '../views/Organization.vue'
import Permissions from '../views/Permissions.vue'
import Employee from '../views/Employee.vue'
import Module from '../views/Module.vue'
import Product from '../views/Product.vue'
import Business from '../views/Business.vue'
import Field from '../views/Field.vue'
import Dictionary from '../views/Dictionary.vue'
import Log from '../views/Log.vue'
import Main from '../views/Main.vue'
Vue.use(VueRouter)

//1.创建路由组件
//2.将路由与组件进行映射
//3.创建router实例

const routes =  [
    //登陆页面
    {
        path:'/',
        component: () => import('../views/Login.vue'),
    },
    {
        path:'/forget',
        component: () => import('../views1/Forget.vue')
    },
    {
        path:'/register',
        component: () => import('../views1/Register.vue')
    },
    //主路由
    {
        path:'/',
        component: Main,
        redirect: '/center',//重定向
        children: [
            //子路由
            {path: 'center', component: Center},//首页
            {path: 'enterprise', component: Enterprise},//用户管理
            {path: 'organization', component: Organization},//管理中心
            {path: 'permissions', component: Permissions},
            {path: 'employee', component: Employee},
            {path: 'module', component: Module},
            {path: 'product', component: Product},
            {path: 'business', component: Business},
            {path: 'field', component: Field},
            {path: 'dictionary', component: Dictionary},
            {path: 'log', component: Log}
        ]
    },
]

const router = new VueRouter({
    routes
})

export default router

