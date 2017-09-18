<template>
  <div class="content has-text-centered">
    <p>
      <img width="200" src="~assets/logo1.svg" :alt="description">
    </p>

    <h1 class="is-title is-bold">{{ name.replace('-', ' ') }}</h1>

    <p>
      <strong>{{ description }}</strong>,
      <a :href="homepage">Infras</a>
    </p>

  </div>
</template>

<script>
export default {

  data () {
    return this.$store.state.pkg
  }

}
</script>

<!-- 加了scoped，style中的样式只适用于当前文件-->
<!-- capitalize -->
<style lang="scss" scoped>
.is-title {
  text-transform: capitalize;
}
</style>
