
import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom' ;

export default class AuthenticatedRoute extends Component {
    render() {
        //if(AuthenticationService.isUserLoggedIn())
        //console.log(this.props.isLoggedIn)
        if(this.props.isLoggedIn)
            return <Route {...this.props}/>
        else 
            return <Redirect to="/" />
        /*
        if (AuthenticationService.isUserLoggedIn()) {
            return <Route {...this.props}/>
        } else {
            return <Redirect to="/login"/>
        }*/
    }
}
