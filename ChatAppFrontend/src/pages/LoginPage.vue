<template>
  <div class="home">
    <h2>Login Page</h2>
    <LoginComponent message="Login component tekst" />
    <LoginWrapper message="Login wrapper tekst" />
  </div>
</template> 

<script>
import LoginComponent from '../components/LoginComponent.vue'
import LoginWrapper from '../wrappers/LoginWrapper.vue'

export default {
  name: 'LoginPage',
  components: {
    LoginComponent,
    LoginWrapper
  }
}
</script>

<style scoped>
</style>