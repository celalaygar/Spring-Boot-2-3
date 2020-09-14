import React, { Component } from 'react'
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';

class ProfileCard extends Component {
    render() {
        return (
            <div>
                <div className="card"   
                    style={{width:"300px"}}>
                    <img className="card-img-top" alt="data"  src={this.props.image}  />
                    <div className="card-body">
                        <h5 className="card-title">{this.props.username}</h5>
                        <p className="card-text">{this.props.email}</p>
                    </div>
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">My Questions are</li>
                        <li className="list-group-item">My Target are </li>
                        <li className="list-group-item">My Target</li>
                    </ul>
                    <div className="card-body">
                        Hi everybody...
                        {/* <a href="#" className="card-link">Card link</a>
                        <a href="#" className="card-link">Another link</a> */}
                    </div>
                </div>
            </div>
        )
    }
}
const mapStateToProps = (store) => {
    return {
        isLoggedIn: store.isLoggedIn,
        username: store.username,
        email: store.email,
        jwttoken: store.jwttoken,
        password: store.password,
        image: store.image
    };
  };
  
  
  export default connect(mapStateToProps)(withRouter(ProfileCard)) ;