import React, { Component } from 'react'
import './App.css';
import UserSignupPage from './pages/User/UserSignupPage';
import UserLoginPage from './pages/User/UserLoginPage';
import LanguageSelector from './components/LanguageSelector';
import { Route, BrowserRouter, Redirect, Switch } from 'react-router-dom';
import NavbarComponent from './pages/Navbar';
import UserDetailPage from './pages/User/UserDetailPage';
import HomeComponent from './pages/HomeComponent';
import AuthenticatedRoute from './components/AuthenticatedRoute';
import { connect } from 'react-redux';
import ApiService from './Services/ApiService';



  class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      username: null,
      isLoggedIn: null,
      jwttoken: null,
      email: null,
      image: null
    };
    // this.onLoginSuccess = this.onLoginSuccess.bind(this);
    // this.onLogoutSuccess = this.onLogoutSuccess.bind(this);
  }

  onLoginSuccess = (authState) => {
    ApiService.changeAuthToken(authState.jwttoken);
    localStorage.setItem("username", authState.username);
    localStorage.setItem("jwttoken", authState.jwttoken);
    localStorage.setItem("isLoggedIn", true);
    this.setState({...authState,isLoggedIn: true});
    
    return <Redirect to="/index" />
  }
  onLogoutSuccess = () => {
    ApiService.changeAuthToken(null);
    localStorage.removeItem("jwttoken");
    localStorage.removeItem("username");
    localStorage.removeItem("isLoggedIn");
    //console.log(localStorage)
    this.setState({
      isLoggedin: false,
      username: null,
      jwttoken: null
    });
    return <Redirect to="/login" />
  }
  back() {
    this.props.history.push('/login');
  }
  render() {
    // localStorage.removeItem("jwttoken");
    // localStorage.removeItem("username");
    // localStorage.removeItem("isLoggedIn");

    let links = null;
    const {isLoggedIn}=this.props;
    //console.log(this.props)
    // if not logged in
    //if (!AuthenticationService.isUserLoggedIn() ) {
    if (!isLoggedIn) {
      links = (
        <Switch>
          <Route exact path="/login" component={(props) => <UserLoginPage {...props} onLoginSuccess={this.onLoginSuccess} />}/> 
          <Route path="/signup" component={UserSignupPage} />  
          <Route exact path="/" component={(props) => <UserLoginPage {...props} onLoginSuccess={this.onLoginSuccess} />}/> 
          <Redirect to="/" />
        </Switch>
      );
    } 
    // if logged in
    //if(AuthenticationService.isUserLoggedIn())  {
    if(isLoggedIn){
      links = (
        <Switch>
          <AuthenticatedRoute exact  path="/index" component={HomeComponent}  isLoggedIn={isLoggedIn} />
          <AuthenticatedRoute path="/user/:username" component={UserDetailPage}  isLoggedIn={isLoggedIn} />
          <Redirect to="/index" />
        </Switch>
      );
    }
    return (
      <div className="container" >
        <div className="row">

          <div className="col-sm-12">
          </div>
          <BrowserRouter>
            <NavbarComponent
              // isLoggedin={isLoggedin}
              // username={username}
              // jwttoken={jwttoken}
              onLogoutSuccess={this.onLogoutSuccess}
            />
            {links}
          </BrowserRouter>

          <LanguageSelector />

          {/* <UserSignupPage /> */}
          {/* <UserLoginPage />
          <LanguageSelector /> */}
        </div>
      </div>
    )
  }
}
const mapStateToProps = (store) => {
  return {
      isLoggedIn: store.isLoggedIn,
      username: store.username,
      jwttoken: store.jwttoken
  };
};

export default connect(mapStateToProps)(App) ;




// import React from 'react';
// import logo from './logo.svg';
// import './App.css';
// import UploadImageComponent from './components/uploadImage';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <h5>App Title</h5>


//         <UploadImageComponent />
//       </header>
//     </div>
//   );
// }

// export default App;
