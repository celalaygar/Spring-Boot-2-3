import Axios from "axios";

const API_BASE_URL = 'http://localhost:8501/api';
const LOGIN_URL = '/login';
class ApiService {

    get(url) { return Axios.get(API_BASE_URL + url); }

    post(url, data) { return Axios.post(API_BASE_URL + url, data); }

    put(url, data) { return Axios.put(API_BASE_URL + url, data); }

    delete(url) { return Axios.delete(API_BASE_URL + url); }
    
    login(data) { return Axios.post(API_BASE_URL + LOGIN_URL, data); }

    changeAuthToken(jwt){
        if(jwt) 
            Axios.defaults.headers.common['Authorization'] = jwt;
        else
            Axios.defaults.headers.common['Authorization'] = null;  
    }

    changeLanguage (lg){ Axios.defaults.headers["accept-language"] = lg; }
}

export default new ApiService();