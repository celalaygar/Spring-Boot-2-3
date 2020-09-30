import { createStore, applyMiddleware, compose } from 'redux';
import authReducer from './AuthenticationReducer';
import SecureLS from "secure-ls";
import thunk from 'redux-thunk';
import ApiService from '../Services/BaseService/ApiService';

const secureLS = new SecureLS();


const getStateFromStorage = () => {
  const auth = secureLS.get("auth");
  //const auth = localStorage.getItem("auth");
  let stateInLocalStorage = {
    isLoggedIn: false,
    username: undefined,
    jwttoken: undefined,
    password: undefined,
    email: undefined,
    image: undefined
  };

  if (auth) {
    stateInLocalStorage = auth;
    // try {
    //   stateInLocalStorage = JSON.parse(auth);
    // } catch (error) {    }
  }
  ApiService.changeAuthToken(auth.jwttoken);
  return stateInLocalStorage;
}

const updateStateInStorage = newState => {
  secureLS.set("auth", newState);
  //localStorage.setItem("auth", JSON.stringify(newState));
}

const configureStore = () => {
  const composeEnhancer = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
  //  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
  const store = createStore(
    authReducer,
    getStateFromStorage(),
    composeEnhancer(applyMiddleware(thunk))
  );

  store.subscribe(() => {
    // insert data to local Storage
    updateStateInStorage(store.getState());
  });
  return store;
}

export default configureStore;