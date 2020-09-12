
 class AuthenticationService {
    isUserLoggedIn() { 
        let isLoggedIn = localStorage.getItem('isLoggedIn');
        if (isLoggedIn  === null || !isLoggedIn) return false;
        return isLoggedIn;
    }

    getUsername() {
        let username = localStorage.getItem('username');
        if (username === null) return null;
        return username;
    }
    getJwtToken() {
        let jwttoken = localStorage.getItem('jwttoken');
        if (jwttoken === null) return null;
        return jwttoken;
    }
}
export default new AuthenticationService();