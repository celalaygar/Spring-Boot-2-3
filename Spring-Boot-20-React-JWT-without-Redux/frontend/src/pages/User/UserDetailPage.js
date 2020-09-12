import React, { Component } from 'react' 
import { Redirect } from 'react-router-dom'
import ProfileCard from '../../components/ProfileCard'

export default class UserDetailPage extends Component {
    render() { 
        //console.log(localStorage.getItem("isLoggedIn"))
        if( !localStorage.getItem("isLoggedIn"))
            return <Redirect to="/" />
        if(this.props.match.params.username !== localStorage.getItem("username"))
            return <Redirect to="/" />
        return (
            <div>
            <div className="col-lg-12">
                <h5>User Detail</h5>
                <hr/>
            </div>
            <div className="col-lg-4">
                <ProfileCard currentUser={this.props.match.params.username}/></div>
            </div>
        )
    }
}
