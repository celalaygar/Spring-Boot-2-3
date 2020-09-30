import React, { useEffect, useRef, useState } from 'react'
import { useTranslation } from 'react-i18next';
import { Link } from 'react-router-dom';
import {  useDispatch, useSelector } from 'react-redux';
import { logoutAction } from '../redux/AuthenticationAction';
import ApiService from '../Services/BaseService/ApiService';
import ProfileImage from '../components/ProfileImage';
import defaultPicture from "./../assets/profile.png"
import { BACKEND_IMAGE_URL } from '../Shared/config';

const NavbarComponent = props =>{
    const [dropDownVisible, setDropDownVisible] = useState(false);
    const dropDownMenuArea  = useRef(null);
    let imageSource = defaultPicture;
    const {isLoggedIn, username, image} = useSelector( store =>{
        return {
            isLoggedIn: store.isLoggedIn,
            username: store.username,
            image: store.image
        };
    });
    const dispatch = useDispatch();
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         isLoggedin: false,
    //         username: null,
    //         jwttoken: null
    //     };
    // }

    // onLogout = () => {

    //     ApiService.changeAuthToken(null);
    //     this.props.dispatch(logoutAction());
    // }

    useEffect(()=>{ 
        document.addEventListener("click", menuClickTracker)
        return () =>{
            document.removeEventListener("click",menuClickTracker);
        };
    }, [isLoggedIn]);

    const menuClickTracker =(event) =>{
        if(dropDownMenuArea.current === null  ||!dropDownMenuArea.current.contains(event.target)){
            setDropDownVisible(false)
        }
    };


    const onLogout = () =>{
        ApiService.changeAuthToken(null);
        dispatch(logoutAction());
    }
    const {t} = useTranslation();
    //const {  onLogout } = props;
    let links = (
        <ul className="navbar-nav ml-auto">
            <li className="nav-item">
                <Link className="nav-link" to="/login">{t('Login')}</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/signup">{t('Sign Up')} </Link>
            </li>
        </ul>
    );

    if (isLoggedIn) {
        let dropdownClassName ="dropdown-menu  p-2 shadow";
        if(dropDownVisible){
            dropdownClassName +=" show";
        }
        if (image) {
            imageSource = BACKEND_IMAGE_URL+image;
        }
        links = (
            <ul className="navbar-nav ml-auto">
                <li className="nav-item active">
                    <Link className="nav-link" to="/index">{t('HomePage')} <span className="sr-only">(current)</span></Link>
                </li>

                <li className="nav-item active">
                    <Link className="nav-link" to="/users">{t('Users')} </Link>
                </li>
                {/* DropDown Menu */}
                <li  className="naw-item dropdown ml-3" style={{ cursor: "pointer" }} ref={dropDownMenuArea}>
                    <div className="d-flex" onClick={() => setDropDownVisible(true)}>
                        <ProfileImage 
                            width="32" 
                            height="32" 
                            imageSource={imageSource} 
                            username={username} 
                            className="m-auto"
                        /> 
                        <span className="nav-link dropdown-toggle">{username} </span>
                    </div>
                    <div className={dropdownClassName}> 
                        <Link 
                            className="dropdown-item" 
                            to={"/user/" + username} 
                            onClick={() => setDropDownVisible(false)}> {t("My Profile")} </Link>
                            
                        <span className="dropdown-item" onClick={onLogout} style={{ cursor: "pointer" }}>
                            {t('Logout')}
                        </span>
                    </div>
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
    // render() {
    //     //console.log(this.props)
    // }
}

export default NavbarComponent;
// const mapStateToProps = (store) => {
//     return {
//         isLoggedIn: store.isLoggedIn,
//         username: store.username,
//         email: store.email,
//         jwttoken: store.jwttoken
//     };
// };
// const mapDispatchToProps = (dispatch) => {
//     return {
//         onLogout: () => {
//             return dispatch(logoutAction());
//         }
//     };
// };
// export default connect(mapStateToProps, mapDispatchToProps)(NavbarComponent);

//export default connect(mapStateToProps, mapDispatchToProps)(withTranslation()(NavbarComponent));