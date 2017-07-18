import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Demo from '@/views/Demo'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/test/',
      name: 'Demo',
      component: Demo
    }
  ]
})
