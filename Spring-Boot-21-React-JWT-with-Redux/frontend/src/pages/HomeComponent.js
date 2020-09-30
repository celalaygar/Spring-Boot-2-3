import React, { Component } from 'react'
import UserList from '../components/UserList';


export default class HomeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: null,
            password: '' 
        };
        
    }
    render() {

        return (
            <div className="col-lg-12">
                <h3>Home Page</h3>
                <hr />
                <UserList />
            </div>
        )
    }
}
