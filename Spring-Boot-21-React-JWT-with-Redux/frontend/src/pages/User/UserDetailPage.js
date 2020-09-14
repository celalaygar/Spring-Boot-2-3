import React, { Component } from 'react'
import ProfileCard from '../../components/ProfileCard'

export default class UserDetailPage extends Component {
    render() {
        console.log(this.props.match.params.username)
        return (
            <div>
                <div className="col-lg-12">
                    <h5>User Detail</h5>
                    <hr />
                </div>
                <div className="col-lg-4">
                    <ProfileCard currentUser={this.props.match.params.username} />
                </div>
            </div>
        )
    }
}
