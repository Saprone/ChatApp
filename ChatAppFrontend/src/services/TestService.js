import axios from 'axios'

export default new class TestService {
    getTestMessage() {
        return axios.get("http://localhost:8081/api/test");
    }
}