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
import User from "../models/user";
import AuthenticationService from "../services/AuthenticationService";
import UserService from "../services/UserService";

export default {
  name: 'LoginPage',
  data: () => {
    return {
      user: new User('admin', '1234')
    }
  },  
  methods: {
    handleLogin() {
      if(this.user != null) {
        AuthenticationService.authenticateUser(this.user);
        AuthenticationService.refreshAccesTokenUser();
        
        console.log("Initial_access_token:"); 
        console.log(localStorage.access_token);
        console.log("Initial_refresh_token:"); 
        console.log(localStorage.refresh_token);

        console.log("New_access_token:"); 
        console.log(localStorage.new_access_token);
        console.log("New_refresh_token:"); 
        console.log(localStorage.new_refresh_token);

        UserService.getUsers();
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