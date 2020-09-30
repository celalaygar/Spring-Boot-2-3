import React, { useEffect, useState } from 'react'
import { useTranslation } from 'react-i18next';
import { useDispatch, useSelector } from 'react-redux';
import { useParams, withRouter } from 'react-router-dom';
import Input from '../../components/input';
import UpdateUserForm from '../../components/UpdateUserForm';
import UserCard from '../../components/UserCard'
import { updateUser } from '../../redux/AuthenticationAction';
import AlertifyService from '../../Services/AlertifyService';
import UserService from '../../Services/UserService';

const UserDetailPage = (props) => {
    const [user, setUser] = useState({});
    const [notFound, setNotFound] = useState(false);
    const [newImage, setNewImage] = useState();
    const [errorImage, setErrorImage] = useState();
    const [editable, setEditable] = useState(false);
    const [inEditMode, setInEditMode] = useState(false);
    const { username } = useParams(); // this.props.match.params.username
    const { t } = useTranslation();
    const dispatch = useDispatch();
    const reduxStore = useSelector((store) => {
        return {
            isLoggedIn: store.isLoggedIn,
            username: store.username,
            email: store.email,
            jwttoken: store.jwttoken,
            password: store.password,
            image: store.image
        };
    })
    //console.log(reduxStore)
    useEffect(() => {
        loadUser();
    }, [username, inEditMode, editable])

    const loadUser = async () => {
        console.log(username)
        setNotFound(false)
        setEditable(false);
        if (reduxStore.username === username) {
            setEditable(true);
        }
        try {
            const response = await UserService.getUserByUsername(username);
            setUser(response.data)

        } catch (error) {
            console.log(error)
            AlertifyService.alert("User not found !!");
            setNotFound(true);
        }
    }
    const showUpdateForm = (control) => {
        setInEditMode(control);
        if (!control) {
            setErrorImage(undefined);
            setNewImage(undefined);
        }
    }
    const saveImage = async (e) => {
        setErrorImage(undefined)
        //data:image/jpeg;base64,/9j/4AAQSkZJRgA
        e.preventDefault();
        let body = { ...user };
        if (newImage) {
            body['image'] = newImage.split(",")[1];
            try {
                //console.log(body)
                const response = await UserService.loadImage(username, body);
                //console.log(response.data)
                if (response.data.body.message) {
                    setErrorImage(response.data.body.message);
                    AlertifyService.alert(response.data.body.message);
                }
                else {
                    let authData= {...reduxStore, image: response.data.body.image}
                    //console.log(authData)
                    dispatch(updateUser(authData));
                    AlertifyService.successMessage("User Image Updated..");
                    showUpdateForm(false)
                }
            } catch (error) {
                if (error.response) {
                    console.log(error.response)
                    if(error.response.data.validationErrors.image){
                        setErrorImage(error.response.data.validationErrors.image);
                        AlertifyService.error(error.response.data.validationErrors.image);
                    }
                }
                else if (error.request)
                    console.log(error.request);
                else
                    console.log(error.message);
            }
        } else {
            AlertifyService.alert("User Image Not Updated..");
        }


    }
    const onChangeData = (type, event) => {
        if (event.target.files.length < 1) {
            return;
        }
        const file = event.target.files[0];
        const fileReader = new FileReader();
        fileReader.onloadend = () => {
            setNewImage(fileReader.result);
        }
        fileReader.readAsDataURL(file);
    };
    if (notFound) {
        return (
            <div className="container">
                <div className="alert alert-danger">User not found !!</div>
            </div>
        )
    } else if (!notFound) {
        return (
            <div className="col-lg-12">
                <h5>{t('User Detail')} </h5>
                <hr />
                <UserCard
                    user={user}
                    newImage={newImage}
                    editable={editable}
                    username={username}
                />
                {
                    editable &&
                    <div className="card-body">
                        {!inEditMode ?
                            <button
                                onClick={e => showUpdateForm(true)}
                                className="btn btn-sm btn-success">{t('Edit')}</button>
                            :
                            <button
                                onClick={e => showUpdateForm(false)}
                                className="btn btn-sm btn-danger">{t('Cancel')} </button>

                        }

                    </div>
                }
                { inEditMode &&
                    <div className="row">
                        <div className="col-sm-7">
                            <UpdateUserForm
                                user={user}
                                inEditMode={inEditMode}
                                newImage={newImage}
                                showUpdateForm={showUpdateForm}
                            />
                        </div>
                        <div className="col-sm-5">
                            <h5 className="card-header text-center"><b>{t("Change Image")}</b></h5>
                            <ul className="list-group list-group-flush ">
                                <li className="list-group-item" style={{ color: "red" }}> png or jpeg format </li>
                                <li className="list-group-item">

                                    <Input
                                        error={errorImage}
                                        name="image"
                                        type="file"
                                        onChangeData={onChangeData}
                                    // onChangeData={event => onChangeData("image", event)} 
                                    />

                                </li>
                                <li className="list-group-item">
                                    <button
                                        onClick={saveImage}
                                        className="btn btn-sm btn-primary">{t('Save')} </button>
                                    <button
                                        onClick={e => showUpdateForm(false)}
                                        className="btn btn-sm btn-danger">{t('Cancel')} </button>
                                </li>
                            </ul>
                        </div>

                    </div>
                }
                <hr />
                <hr />
                <hr />
                <hr />
                <hr />
                <hr />
            </div>
        )
    }
};
// const mapStateToProps = (store) => {
//     return {
//         isLoggedIn: store.isLoggedIn,
//         username: store.username,
//         email: store.email,
//         jwttoken: store.jwttoken,
//         password: store.password,
//         image: store.image
//     };
// };
// export default connect(mapStateToProps)(withRouter(ProfileCard)) ;
//export default connect(mapStateToProps)(serDetailPage);
export default withRouter(UserDetailPage) ;