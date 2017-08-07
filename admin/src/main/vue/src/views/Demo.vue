<template>
  <div>
    <span v-bind:title="message">
      Name:{{greet.name}}
    </span>
    <p v-if="seen">现在你看到我了</p>
    <input v-model="message"/>
    <p>
      {{message}}
    </p>
    <button v-on:click='reverseMessage'>消息翻转</button>
    <ol>
      <!--
        现在我们为每个 todo-item 提供待办项对象
        待办项对象是变量，即其内容可以是动态的。
        我们也需要为每个组件提供一个“key”，晚些时候我们会做个解释。
      -->
      <tool-item
        v-for="tool in tools"
        v-bind:tool="tool"
        v-bind:key="tool.id">
      </tool-item>
    </ol>
  </div>
</template>

<script>
  import ToolItem from '../components/Item'
  /* global $ */
  export default {
    name: 'hello',
    data () {
      return {
        greet: {
          name: '赵衡'
        },
        message: 'Hello Vue.js',
        seen: false,
        tools: [{id: 1, name: '赵衡'}, {id: 2, name: 'zhaoheng'}]
      }
    },
    created: function () {
//      this.getGreet()
    },
    methods: {
      getGreet: function () {
        $.get('http://localhost:3999/test/1').done((res) => {
          if (res.success) {
            this.greet = res.data
          }
        })
      },
      reverseMessage: function () {
        this.message = this.message.split('').reverse().join('')
      }
    },
    components: {
      ToolItem
    }
  }
</script>
