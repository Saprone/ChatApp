<template>
  <div class="loginpage">
    <div class="panel">
      <form action="#" @submit.prevent="submit">
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
          <button type="submit" @click="onclick('login')">Login</button>&nbsp;
          <button type="submit" @click="onclick('signup')">Sign Up</button>
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
  created() {
    let socket = new SockJS('http://localhost:8080/sockjs');
    let stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function(frame) {
        stompClient.subscribe('/topic/chatmessage', function(message) {
      });
    });
  },
  methods: {
    submit(action) {
      const {room, username, password} = Object.fromEntries(new FormData(action.target));
      this.room = room;
      this.username = username;
      this.password = password;

      console.log("room: "+ this.room, ", username: "+this.username, ", password: "+this.password);
    },
    async onclick(event) {
      if(event === "login") {
        console.log("login button clicked");
      }      
      if(event === "signup") {
        console.log("signup button clicked");
      }
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