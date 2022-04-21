import axios from 'axios'

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
            .post("http://localhost:8082/api/login", params, config)
            .then((response) => {
                localStorage.access_token = response.data.access_token;
                localStorage.refresh_token = response.data.refresh_token;         
            })
            .catch((error) => {
                console.log(error);
            })
    }
}