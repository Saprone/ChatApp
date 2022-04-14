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
      user: new User('placeholder', 'Passw0rd!'),
      usernames: [] 
    }
  },
  created() { 
    this.createWebsocketConnection()
  },  
  methods: {
    handleLogin() {
      if(this.stompClient && this.user != null) {
        //this.sendMessageToServer()

        this.authenticateUser()
      }
    },
    createWebsocketConnection() {
      this.socket = new SockJS("http://localhost:8082/sockjs");
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
      const API_URL = 'http://localhost:8082/api/login';

      const params = new URLSearchParams();
      params.append('username', 'admin');
      params.append('password', '1234');

      const config = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }
      }

      axios.post(API_URL, params, config)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        }) 
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