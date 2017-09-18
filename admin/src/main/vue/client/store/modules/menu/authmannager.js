import lazyLoading from './lazyLoading'

export default {
  name: '权限管理',
  meta: {
    icon: 'fa-building-o',
    expanded: false
  },
  children: [
    {
      name: '角色列表',
      path: '/rolelist',
      component: lazyLoading('authmannager/Rolelist', false)
    },
    {
      name: '角色详情',
      path: '/role',
      component: lazyLoading('authmannager/Role', false)
    }
  ]
}
