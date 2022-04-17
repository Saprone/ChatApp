import axios from 'axios'

const API_URL = "http://localhost:8082/api/login";

export default new class AuthenticationService {
    authenticateUser(username, password) {   
        const params = new URLSearchParams();
        params.append('username', username);
        params.append('password', password);

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }
        }    
        
        return axios.post(API_URL, params, config)
    }
}