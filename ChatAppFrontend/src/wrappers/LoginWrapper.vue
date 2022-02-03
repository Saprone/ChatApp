<template>
  <div class="loginwrapper">
    <p>{{ message }}</p>
  </div>
</template>

<script>
export default {
  name: 'LoginWrapper',
  props: {
    message: String
  }
}
</script>

<style scoped>
</style>