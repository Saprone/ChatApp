<template>
  <div class="loginpage">
    <div class="panel">
      <form action="#" @submit.prevent="handleLogin">
        <div class="section">
          <label>Username:</label>
          <input v-model="user.username" type="text" name="username" required/>  
        </div>
        <div class="section">
          <button type="login">Login</button>
        </div>
      </form>
    </div>
  </div>
</template> 

<script>
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'
import User from '../models/user'
import axios from 'axios'

export default {
  name: 'LoginPage',
  data: () => {
    return {
      user: new User('', 'Passw0rd!'),
      usernames: [] 
    }
  },
  created() {
    this.authenticateUser()
    this.createWebsocketConnection()
  },  
  methods: {
    handleLogin() {
      if(this.stompClient && this.user != null) {
        this.sendMessageToServer()
      }
    },
    createWebsocketConnection() {
      this.socket = new SockJS("http://localhost:8080/sockjs");
      this.stompClient = Stomp.over(this.socket);

      this.stompClient.connect({}, frame => {
        this.stompClient.subscribe("/topic/user", payload => {
          if(payload.body !== null) {
            this.usernames.push(payload.body);
            this.$router.push({name: "Chatroom", params: { data: this.usernames }}).catch(()=>{});
          }
        });
      });
    },
    sendMessageToServer() {
      this.stompClient.send("/app/user.input", JSON.stringify({ username: this.user.username }), {});
    },
    authenticateUser() {
      const API_URL = 'http://localhost:8080/api/login';
      var user = new User('admin', '1234');

      return axios
        .post(API_URL, { user })
        .then(response => {
          console.log(response);
        })
        .catch((error) => {
            console.log(error);
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
.loginpage .section:not(:first-of-type), .loginpage input {
  margin-top: 10px;
}
</style>