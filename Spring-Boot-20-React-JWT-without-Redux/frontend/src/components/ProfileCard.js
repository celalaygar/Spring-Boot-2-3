import React, { Component } from 'react'

export default class ProfileCard extends Component {
    render() {
        return (
            <div>
                <div className="card"   >
                    <img className="card-img-top" alt="" src="https://cdn2.vectorstock.com/i/1000x1000/20/76/man-avatar-profile-vector-21372076.jpg" alt="Card image cap" />
                    <div className="card-body">
                        <h5 className="card-title">{this.props.currentUser}</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">Cras justo odio</li>
                        <li className="list-group-item">Dapibus ac facilisis in</li>
                        <li className="list-group-item">Vestibulum at eros</li>
                    </ul>
                    <div className="card-body">
                        {/* <a href="#" className="card-link">Card link</a>
                        <a href="#" className="card-link">Another link</a> */}
                    </div>
                </div>
            </div>
        )
    }
}
