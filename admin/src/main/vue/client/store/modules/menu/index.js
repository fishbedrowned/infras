/* global $ */
import * as types from '../../mutation-types'
import lazyLoading from './lazyLoading'
// import charts from './charts'
// import uifeatures from './uifeatures'
// import components from './components'
// import authmannager from './authmannager'
// import tables from './tables'
// import Vue from 'vue'
// import axios from '../../myaxios'

// show: meta.label -> name
// name: component name
// meta.label: display label
import constant from '../../constant'

// const menuse
const base = {
  items: [
    {
      name: 'Dashboard',
      path: '/dashboard',
      meta: {
        icon: 'fa-tachometer',
        link: 'dashboard/index.vue',
        label: '测试标题'
      },
      component: lazyLoading('dashboard', true)
    }
    // authmannager,
    // tables
  ]
}

var state = {
  items: [
    // {
    //   name: 'Axios',
    //   path: '/axiosDemo',
    //   meta: {
    //     auth: true,
    //     icon: 'fa-rocket',
    //     link: 'axios/index.vue'
    //   },
    //   component: lazyLoading('axios', true)
    // },
    // charts,
    // uifeatures,
    // components
    // tables
    // authmannager
  ]
}

const mutations = {
  [types.EXPAND_MENU] (state, menuItem) {
    if (menuItem.index > -1) {
      if (state.items[menuItem.index] && state.items[menuItem.index].meta) {
        state.items[menuItem.index].meta.expanded = menuItem.expanded
      }
    } else if (menuItem.item && 'expanded' in menuItem.item.meta) {
      menuItem.item.meta.expanded = menuItem.expanded
    }
  }
}

const updateMenu = function () {
  $.ajax({
    url: constant.addBaseUrl('/menus'),
    method: 'GET',
    async: false
  }).done((res) => {
    if (res.success) {
      console.info('ajax success!')
      state.items = getPMenuJson(res.data)
    }
  })
}

function getPMenuJson (infos = [], routes = []) {
  for (let i = 0, l = infos.length; i < l; i++) {
    let info = infos[i]
    const m = {
      name: info.name,
      meta: {
        icon: info.icon,
        expanded: false
      },
      children: getChildMenuJson(info.children)
    }
    routes.push(m)
  }
  return routes
}

function getChildMenuJson (menu = [], routes = []) {
  for (let i = 0, l = menu.length; i < l; i++) {
    let item = menu[i]
    const cm = {
      name: item.name,
      path: item.path,
      component: lazyLoading(item.component, false)
    }
    routes.push(cm)
  }
  return routes
}

export default {
  state,
  mutations,
  base,
  updateMenu
}
