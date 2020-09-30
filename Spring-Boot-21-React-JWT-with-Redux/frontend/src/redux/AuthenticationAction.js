import ApiService from "../Services/BaseService/ApiService";
import UserService from "../Services/UserService";
import * as ACTIONS from "./Constants";


export const logoutAction = () => {
    return { type: ACTIONS.LOGOUT_ACTION };
};

export const loginAction = (authData) => {
    return { type: ACTIONS.LOGIN_ACTION, payload: authData };
};

export const updateUser = (updateDate) =>{
    return {type : ACTIONS.UPDATE_ACTION, payload: updateDate }
}
export const loginHandler = (cridentials) => {
    return  (async (dispatch) => {
        const response = await  ApiService.login(cridentials)
        if (response) {
            //console.log(response.data);
            const authState = {
                ...response.data,
                isLoggedIn: true,
                password: cridentials.password
            }
            ApiService.changeAuthToken(response.data.jwttoken);
            dispatch(loginAction(authState));
        }
        return response;
    })
};

export const signupHandler = (user) =>{
    return async (dispatch) => {
        const response = await UserService.post(user);
        const { username, password } =  {username: user.username, password: user.repeatPassword};
        const creds = { username, password };
        await dispatch(loginHandler(creds));
        return response;
    }
};