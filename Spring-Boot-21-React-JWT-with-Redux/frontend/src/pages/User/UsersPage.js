import defaultPicture from "./../../assets/profile.png"

import React, { Component } from 'react'
import { withTranslation } from 'react-i18next';
import { connect } from 'react-redux';
import ProfileImage from '../../components/ProfileImage';
import UserListItem from '../../components/UserListItem';
import AlertifyService from '../../Services/AlertifyService';
import UserService from '../../Services/UserService';
import { BACKEND_IMAGE_URL } from "../../Shared/config";
import { Link } from "react-router-dom";

class UsersPage extends Component {

    constructor(props) {
        super(props)
        this.state = {
            page: {
                content: [],
                number: 0,
                size: 4,
            },
            jwttoken: props.jwttoken
        };
    }

    componentDidMount() {
        this.getUsers(this.state.page.number, this.state.page.size);

    }
    getUsers = async (number, size) => {
        // const res = await UserService.getUsers('/users',this.state.jwttoken)
        // console.log(res.data)
        try {
            await UserService.getUsers(number, size).then(res => {
                //console.log(res.data);
                this.setState({ page: res.data });
            });
        } catch (error) {
            if (error.response) {
                //console.log(error.response.data.message);
                console.log(error.response.data.message);
                AlertifyService.alert(error.response.data.message);
            }
            else if (error.request) {
                console.log(error.request);
                AlertifyService.alert(error.request);
            }
            else {
                console.log(error.message);
                AlertifyService.alert(error.message);
            }
        };
    }
    onClickNext = () => {
        const nextPage = this.state.page.number + 1;
        this.getUsers(nextPage, this.state.page.size);
    }
    onClickPrevios = () => {
        const nextPage = this.state.page.number - 1;
        this.getUsers(nextPage, this.state.page.size);
    }
    // onDeleteUser = (index)=>{
    //     console.log("Delete button clicked: "+index)
    //     const users = [...this.state.users];
    //     users.splice(index,1);
    //     this.setState({users})
    // }
    render() {
        const { content: users, first, last, number, totalPages } = this.state.page;
        const { t } = this.props;
        return (
            <div className="col-sm-12">
                <div className="card">
                    <h3 className="card-header">
                        <div className="d-flex justify-content-center">{t('Users')}</div>
                    </h3>

                    <div className="card-header d-flex justify-content-between bd-highlight mb-3">
                        <div className="d-flex justify-content-start">
                            {first === false && <button onClick={this.onClickPrevios} className="btn btn-secondary btn-sm">{t('Previous')}</button>}
                        </div>

                        <div className="d-flex justify-content-end">
                            {last === false && <button onClick={this.onClickNext} className=" btn btn-secondary  btn-sm ">{t('Next')}</button>}
                        </div>
                    </div>





                    <table class="table table-hover">
                    <thead>
                        <tr>
                        <td scope="col">id</td>
                        <th scope="col">Name</th>
                        <th scope="col">Surname</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user, index) =>
                            
                        <tr key={user.username}>
                            
                            <td scope="row">
                            <ProfileImage
                                width="32px"
                                height="32px"
                                imageSource={user.image ? BACKEND_IMAGE_URL+user.image : defaultPicture}
                                // newimage={props.newImage}
                                username={user.username}
                            />
                            </td>
                            <td>{user.name}</td>
                            <td>{user.surname}</td>
                            <td>{user.email}</td>
                            <td><Link to={'/user/'+user.username} className="btn btn-wm btn-success">Aç</Link></td>
                        </tr>
                            

                            // <UserListItem key={user.username} user={user} index={index} />
                            )
                        }

                    </tbody>
                    </table>







                    {/* <div className="list-group-flush">
                        {users.map((user, index) =>
                            <UserListItem key={user.username} user={user} index={index} />)
                        }
                    </div> */}
                    <div>
                        <hr />
                        <div className="d-flex justify-content-end pr-5">
                            <h5>{t('Page')} {number !== undefined && number + 1}/{totalPages !== undefined && totalPages}</h5>
                        </div>
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
// export default connect(mapStateToProps)(withRouter(ProfileCard)) ;
export default connect(mapStateToProps)(withTranslation()(UsersPage));