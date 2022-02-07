<template>
  <div class="loginpage">
    <div class="panel">
      <form action="#" @submit.prevent="login">
        <div class="section">
          <label for="room">Room:</label>&nbsp;
          <select name="room">
            <option value="room1">Room1</option>
            <option value="room2">Room2</option>
            <option value="room3">Room3</option>
          </select> 
        </div>
        <div class="section">
          <label for="username">Username:</label>&nbsp;
          <input required type="text" name="username"/>  
        </div>
        <div class="section">
          <label for="password">Password:</label>&nbsp;
          <input required type="password" name="password"/>  
        </div> 
        <div class="section">
          <button type="login">Login</button><br><br>
          <router-link to="/register">Register here</router-link>
        </div> 
      </form> 
    </div>
  </div>
</template> 

<script>
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  name: 'LoginPage',
  data() {
    return {
      room: '',
      username: '',
      password: ''
    }
  },
  methods: {
    login(action) {
      const {room, username, password} = Object.fromEntries(new FormData(action.target));
      this.room = room;
      this.username = username;
      this.password = password;

      console.log("room: "+ this.room, ", username: "+this.username, ", password: "+this.password);

      //sockjs
      let socket = new SockJS('http://localhost:8080/sockjs');
      let stompClient = Stomp.over(socket);
    
      stompClient.connect({}, function(frame) {
        stompClient.subscribe('/topic/chatmessage', function(message) {
      });
    });
    }
  }
}
</script>

<style scoped>
.loginpage .panel {
   margin-top: 300px;
}
.loginpage form {
  display: block;
  margin: auto;
  border: 1px solid black;
  width: 200px;
  padding: 15px 5px;
}
.loginpage .section:not(:first-of-type) {
  margin-top: 10px;
}
</style>