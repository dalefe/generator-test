import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
    * meta : {
    title: 'title'               the name show in subMenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if false, the item will hidden in breadcrumb(default is true)
    }
    **/
export const constantRouterMap = [
    { path: '/404', component: () => import('@/views/404'), hidden: true },

    {
        path: '/',
        component: Layout,
        redirect: '/CodeGenerator',
        name: 'CodeGenerator',
        hidden: false,
        meta: { title: '代码生成主页', icon: 'example' },
        children: [{
            path: 'CodeGenerator',
            component: () => import('@/views/dashboard/index')
        }]
    },
    /**
    * 此路由表为演示样例
    * 请将生成后的vue组件按如下格式填写
    *
    * 参数说明：（下列属性说明为children子属性）
    * 1、path: 路由组件被访问的url路径
    * 2、component: 组件的名称
    */
<#-- 循环遍历所有路由信息 -->
<#list RouteDatas as RouteData>
    {
        path: '/${RouteData}',
        component: Layout,
        name: '${RouteData}',
        meta: { title: '${RouteData}', icon: 'example' },
        children: [{
            path: '${RouteData}',
            component: () => import('@/views/${RouteData}/index')
        }]
    },
</#list>
    { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
// mode: 'history', //后端支持可开
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRouterMap
})
