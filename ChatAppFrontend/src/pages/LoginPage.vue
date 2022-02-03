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
  created:function() {
    let socket = new SockJS('http://localhost:8080/sockjs');
    let stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function(frame) {
        stompClient.subscribe('/topic/chatmessage', function(message) {
          
        console.log("message: " + message.body);
        //console.warn(JSON.parse(message.body));
      });
    });
  }
}
</script>

<style scoped>
</style>