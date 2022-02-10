<template>
  <div class="loginpage">
    <div class="panel">
      <form action="#" @submit.prevent="login">
        <div class="section">
          <label for="username">Username:</label>
          <input required type="text" name="username"/>  
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

export default {
  name: 'LoginPage',
  data: () => {
    return {
      usernames: [],
      username: ''  
    }
  },
  created() {
    this.socket = new SockJS("http://localhost:8080/sockjs");
    this.stompClient = Stomp.over(this.socket);

    this.stompClient.connect({}, frame => {
        this.stompClient.subscribe("/topic/user", payload => {
          if(payload.body !== null) {
            this.usernames.push(payload.body);

            this.$router.push({name: "Chatroom", params: { data: this.usernames }});
          }
        });
      }
    );
  },  
  methods: {
    login(action) {
      const {username} = Object.fromEntries(new FormData(action.target));
      this.username = username;

      if(this.stompClient && this.username != '') {
        this.stompClient.send("/app/user.input", JSON.stringify({ username: this.username }), {});
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
.loginpage .section:not(:first-of-type), .loginpage input {
  margin-top: 10px;
}
</style>