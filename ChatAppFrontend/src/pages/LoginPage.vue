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
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  name: 'LoginPage',
  components: {
    LoginComponent,
    LoginWrapper
  },
  data: function() {
    return {
      connection: null
    }
  },
  created: function() {
    console.log("Starting connection to WebSocket Server")

    this.socket = new SockJS("http://localhost:8080/sockjs");
    this.stompClient = Stomp.over(this.socket);

    console.log(this.stompClient);
  }
}
</script>

<style scoped>
</style>