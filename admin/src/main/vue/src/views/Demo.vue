<template>
  <div class="hello">
    Name:{{greet.name}}
  </div>
</template>

<script>
  /* global $ */
  export default {
    name: 'hello',
    data () {
      return {
        greet: {}
      }
    },
    created: function () {
      this.getGreet()
    },
    methods: {
      getGreet: function () {
        $.get('http://localhost:3999/test/1').done((res) => {
          if (res.success) {
            this.greet = res.data
          }
        })
      }
    }
  }
</script>
