<template>
  <div class="loginpage">
    <h2>Login Page</h2> 
  </div>
</template> 

<script>
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  name: 'LoginPage',
  created() {
    this.socket = new SockJS("http://localhost:8080/sockjs");
    this.stompClient = Stomp.over(this.socket);
    this.stompClient.connect();
  }
}
</script>

<style scoped>
</style>