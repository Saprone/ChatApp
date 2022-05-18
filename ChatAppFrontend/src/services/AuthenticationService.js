import axios from 'axios'

const API_URL = "http://localhost:8082/api/";

export default new class AuthenticationService {
    async authenticateUser(user) {   
        const params = new URLSearchParams();
        params.append('username', user.username);
        params.append('password', user.password);

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }
        }   
  
        return await axios
            .post(API_URL + "login", params, config)
            .then((response) => {
                console.log("Initial_access_token:"); 
                console.log(response.data.access_token);
                console.log("Initial_refresh_token:"); 
                console.log(response.data.refresh_token);

                localStorage.access_token = response.data.access_token;
                return true;
            })
            .catch((error) => {
                console.log(error);
                return false;
            })
    }
    async refreshAccesTokenUser() {
        return await axios
            .get(API_URL + "token/refresh", {
                headers: {
                    authorization: `Bearer ${localStorage.access_token}`,
                }
            })
            .then(response => {
                console.log("Refreshed_access_token:"); 
                console.log(response.data.access_token);
                console.log("Refreshed_refresh_token:"); 
                console.log(response.data.refresh_token);
            })
            .catch(error => {
                console.log(error)
            })
    }
}