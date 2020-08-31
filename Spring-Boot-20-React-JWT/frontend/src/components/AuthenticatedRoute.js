
import React, { Component } from 'react'
import { Route, Redirect } from 'react-router-dom'
import AuthenticationService from '../Services/AuthenticationService'

export default class AuthenticatedRoute extends Component {
    render() {
        if(  AuthenticationService.isUserLoggedIn())
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
