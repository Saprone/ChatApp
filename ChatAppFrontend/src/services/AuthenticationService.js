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
                localStorage.access_token = response.data.access_token;
                localStorage.refresh_token = response.data.refresh_token;         
            })
            .catch((error) => {
                console.log(error);
            })
    }
    async refreshAccesTokenUser() {
        return await axios
            .get("http://localhost:8082/api/" + "token/refresh", {
                headers: {
                    authorization: `Bearer ${localStorage.refresh_token}`,
                }
            })
            .then(response => {
                localStorage.new_access_token = response.data.access_token;
                localStorage.new_refresh_token = response.data.refresh_token;  
            })
            .catch(error => {
                console.log(error)
            })
    }
}