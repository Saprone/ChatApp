import axios from 'axios'

const API_URL = "http://localhost:8082/api/test";

class TestService {
    getTestMessage() {
        return axios.get(API_URL);
    }
}

export default new TestService()