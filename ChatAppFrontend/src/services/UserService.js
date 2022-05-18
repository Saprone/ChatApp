import axios from 'axios'

const API_URL = "http://localhost:8082/api/";

export default new class UserService {
    async getUsers() {
        return await axios
            .get(API_URL + "users")
            .then(response => {       
                console.log("Users:");     
                response.data.forEach(user => {
                    console.log(user);
                });
            })
            .catch(error => {
                console.log(error)
            })
    }       
}    