<template>
  <div class="registerpage">
    <h2>Register Page</h2>   

    <!--<div class="panel">
      <form action="#" @submit.prevent="register">
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
          <button type="register">Register</button>
        </div> 
      </form> 
    </div>-->
  </div>
</template> 

<script>
/*import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  name: 'RegisterPage',
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
    register(action) {
      const {room, username, password} = Object.fromEntries(new FormData(action.target));
      this.room = room;
      this.username = username;
      this.password = password;

      console.log("room: "+ this.room, ", username: "+this.username, ", password: "+this.password);
    }
  }
}*/
</script>

<style scoped>
/*.registerpage .panel {
   margin-top: 300px;
}
.registerpage form {
  display: block;
  margin: auto;
  border: 1px solid black;
  width: 200px;
  padding: 15px 5px;
}
.registerpage .section:not(:first-of-type) {
  margin-top: 10px;
}*/
</style>