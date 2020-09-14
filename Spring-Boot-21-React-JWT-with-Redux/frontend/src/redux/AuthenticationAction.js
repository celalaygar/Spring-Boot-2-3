import ApiService from "../Services/ApiService";
import * as ACTIONS from "./Constants";


export const logoutAction = () => {
    return { type: ACTIONS.LOGOUT_ACTION };
};

export const loginAction = (authData) => {
    return { type: ACTIONS.LOGIN_ACTION, payload: authData };
};

export const loginHandler = (cridentials) => {
    return  (async (dispatch) => {
        const response = await  ApiService.login(cridentials)
        if (response) {
            const authState = {
                ...response.data,
                isLoggedIn: true,
                password: cridentials.password,
                email: null,
                image: "https://i.milliyet.com.tr/MolatikDetayBig/2019/04/12/fft371_mf32728256.Jpeg"
            }
            ApiService.changeAuthToken(response.data.jwttoken);
            dispatch(loginAction(authState));

        }
        return response;
    })
};