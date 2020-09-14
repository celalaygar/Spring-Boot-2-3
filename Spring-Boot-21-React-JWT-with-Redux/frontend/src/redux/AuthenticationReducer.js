import * as ACTIONS from "./Constants";

const defaultState = {
    isLoggedIn: false,
    username: undefined,
    jwttoken: undefined,
    password: undefined,
    email: undefined,
    image: undefined
}

const authReducer = (state = { ...defaultState }, action) => {
    if (action.type === ACTIONS.LOGOUT_ACTION) {
        return defaultState;
    }
    if (action.type ===  ACTIONS.LOGIN_ACTION ) {
        return {
            ...action.payload
        };
    }
    return state;
};

export default authReducer;