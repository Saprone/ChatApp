<template>
  <div class="logincomponent">
    <p>{{ message }}</p>
  </div>
</template>

<script>
export default {
  name: 'LoginComponent',
  props: {
    message: String
  }
}
</script>

<style scoped>
</style>