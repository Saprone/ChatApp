<template>
  <div class="loginpage">
    <div class="panel">
      <form action="#" @submit.prevent="handleLogin">
        <div class="section">
          <label>Username:</label>
          <input v-model="user.username" type="text" name="username" ref="username" required/>  
        </div>
        <div class="section">
          <label>Password:</label>
          <input v-model="user.password" type="password" name="password" ref="password" required/>  
        </div>
        <div class="section">
          <button type="login">Login</button>
        </div>  
      </form>
      <div class="section" style="margin-right: 40px;">
          <ul style="list-style-type: none;">
            <li v-for="user in usernames" :key="user">
              {{ user }} joined
            </li>
          </ul>
        </div>
    </div>
  </div>
</template> 

<script>
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'
import User from '../models/user'
import AuthenticationService from '../services/AuthenticationService'
import UserService from '../services/UserService'

export default {
  name: 'LoginPage',
  data: () => {
    return {
      user: new User('admin', '1234'),
      usernames: [] 
    }
  },
  created() {
    this.createWebsocketConnection()
  },    
  methods: {
    handleLogin() {
      if(this.stompClient && this.user != null) {        
        AuthenticationService.authenticateUser(this.user).then(userIsAuthenticated => {
              if(userIsAuthenticated && this.usernames.includes(this.user.username) == false) {
                //AuthenticationService.refreshAccesTokenUser();  
                UserService.getUsers();
                this.sendMessageToServer(); 
              } 
          })
          .catch(error => {
            console.log(error)
          })
      }
    },
    createWebsocketConnection() {
      this.socket = new SockJS("http://localhost:8082/sockjs");
      this.stompClient = Stomp.over(this.socket);

      this.stompClient.connect({}, frame => {
        this.stompClient.subscribe("/topic/user", payload => {
          if(payload.body !== null) {       
            if(this.usernames.includes(payload.body) == false) {
              this.usernames.push(payload.body);
              //this.$router.push({name: "Chatroom", params: { data: this.usernames }}).catch(()=>{});
            }   
          }
        });
      });
    },
    sendMessageToServer() {
      this.stompClient.send("/app/user.input", JSON.stringify({ username: this.user.username }), {});
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