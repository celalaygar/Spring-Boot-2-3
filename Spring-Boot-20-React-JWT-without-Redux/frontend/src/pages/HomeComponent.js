import React, { Component } from 'react'

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
                <h5>Home Page</h5>
                <hr />
            </div>
        )
    }
}
