import React, { Component } from 'react'
import { withTranslation } from 'react-i18next';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { logoutAction } from '../redux/AuthenticationAction';
import ApiService from '../Services/ApiService';


class NavbarComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedin: false,
            username: null,
            jwttoken: null
        };
    }
    onLogout = () =>{
        
        ApiService.changeAuthToken(null);
        this.props.dispatch(logoutAction());
    }
    render() {
        //console.log(this.props)
        const { t, isLoggedIn,username,onLogout/*,email,image, onLogoutSuccess*/ } = this.props;
        let links = null;
        //console.log(AuthenticationService.isUserLoggedIn())
        if (!isLoggedIn) {
            links = (
                <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <Link className="nav-link" to="/login">{t('Login')}</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/signup">{t('Sign Up')} </Link>
                    </li>
                </ul>
            );
        }

        if (isLoggedIn) {
            links = (
                <ul className="navbar-nav ml-auto">
                    <li className="nav-item active">
                        <Link className="nav-link" to="/index">{t('HomePage')} <span className="sr-only">(current)</span></Link>
                    </li>
                    <li className="nav-item  ">
                        <Link className="nav-link" to={"/user/" + username}> {username} </Link>
                    </li>
                    <li className="nav-item nav-link" onClick={onLogout} style={{ cursor: "pointer" }}>
                        {t('Logout')}
                    </li>
                </ul>
            );
        }
        return (
            <div className="col-lg-12 shadow-sm bg-light mb-2">
                <nav className="navbar navbar-expand-lg navbar-light ">
                    <Link className="navbar-brand" to="/">{t('Navbar')}</Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        {links}
                    </div>
                </nav>
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
const mapDispatchToProps = (dispatch) =>{
    return {onLogout: () =>{
        return dispatch(logoutAction());
    }};
};
export default connect(mapStateToProps,mapDispatchToProps)(withTranslation()(NavbarComponent));