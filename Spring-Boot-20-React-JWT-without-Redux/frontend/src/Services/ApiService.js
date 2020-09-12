import Axios from "axios";

const API_BASE_URL = 'http://localhost:8501/api';
class ApiService {

    get(url) { return Axios.get(API_BASE_URL + url); }

    post(url, data) { return Axios.post(API_BASE_URL + url, data); }

    put(url, data) { return Axios.put(API_BASE_URL + url, data); }

    delete(url) { return Axios.delete(API_BASE_URL + url); }
    
    login(data) { return Axios.post(API_BASE_URL + "/login", data); }


    changeLanguage (lg){ Axios.defaults.headers["accept-language"] = lg; }
}

export default new ApiService();