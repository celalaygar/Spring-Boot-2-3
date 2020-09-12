
var axios = require("axios");

export const username = localStorage.getItem("username");
export const jwtToken = localStorage.getItem("jwttoken");
axios.interceptors.request.use(
  function(config) {
    if (jwtToken) {
      config.headers["authorization"] = "Bearer " + jwtToken;
    }
    return config;
  },
  function(err) {
    return Promise.reject(err);
  }
);