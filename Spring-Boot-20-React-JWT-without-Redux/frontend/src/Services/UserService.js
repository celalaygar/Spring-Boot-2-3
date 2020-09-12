import ApiService from "./ApiService";



const USER_URL  = '/user'
class UserService {

    get(url) { return ApiService.get(url)}

    post(data) { return ApiService.post(USER_URL,data)}

    //put(url, data) { return axios.put(API_BASE_URL + url, data); }

    //delete(url) { return axios.delete(API_BASE_URL + url); }
}

export default new UserService();