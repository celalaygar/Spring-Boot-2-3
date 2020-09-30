
import React, { Component } from 'react'
import { withTranslation } from 'react-i18next';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import { logoutAction, updateUser } from '../redux/AuthenticationAction';
import AlertifyService from '../Services/AlertifyService';
import ApiService from '../Services/BaseService/ApiService';
import UserService from '../Services/UserService';
import Input from './input';

class UpdateUserForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: null,
            username: '',
            email: '', 
            name: '',
            surname: '',
            errors: {
            }
        };
        this.loadInputs = this.loadInputs.bind(this);
    }
    componentDidMount(){ 
        const { user } = this.props; 
        this.loadInputs(user);
    }
    loadInputs =  (user) =>{
        // const { user } = props;
        this.setState({ ...user });
    }
    onChangeData = (type, event) =>{
        const stateData = this.state;
        stateData[type] = event 
        const errors = { ...this.state.errors }
        errors[type] = undefined; 
        this.setState({ stateData, errors: errors });
    }
    onClickSave = async (e) => {
        // browser form içeriğini bir yere göndermesini engeller.
        // browserin bizim yerimize bir şey yapmasını engellemiş oluyoruz.
        e.preventDefault();
        this.setState({ errors: {} })
        let body = this.state;
        try {
            const {isLoggedIn,jwttoken, password} = this.props;
            const response = await UserService.update(this.props.username,body);
            // const data = {isLoggedIn, jwttoken,password, ...response.data.body};
            // this.props.dispatch(updateUser(data));
            // this.props.showUpdateForm(false)
            // this.props.history.push("/user/"+data.username)
            this.logoutForChangingUserData();
            AlertifyService.alert("User Updated..");
        } catch (error) {
            if (error.response) {
                console.log(error.response)
                if (error.response.data.validationErrors) {
                    console.log(error.response.data.validationErrors);
                    this.setState({ errors: error.response.data.validationErrors })
                }
            }
            else if (error.request)
                console.log(error.request);
            else
                console.log(error.message);
        } 
    } 
    logoutForChangingUserData = () =>{
        ApiService.changeAuthToken(null);
        this.props.dispatch(logoutAction());
    }
    render() {
        const { t /*,user*/ } = this.props;  
        const { username,email /*,bornDate*/} = this.state.errors;
        return (
            <div>
                {this.props.inEditMode &&
                    <form>
                        <h5 className="card-header text-center">{t("Change User Info")}</h5>
                        <Input
                        label={t("Username *")}
                        error={username}
                        type="text"
                        name="username"
                        placeholder={t("Username *")}
                        valueName={this.state.username}
                        onChangeData={this.onChangeData}
                    />
                    <Input
                        label={t("Email *")}
                        type="email"
                        error={email}
                        name="email"
                        placeholder={t("Email *")}
                        valueName={this.state.email}
                        onChangeData={this.onChangeData}
                    />
                    <Input
                        label={t("Name")} 
                        type="text"
                        name="name"
                        placeholder={t("Name")}
                        valueName={this.state.name}
                        onChangeData={this.onChangeData}
                    />
                    <Input
                        label={t("Surname")} 
                        type="text"
                        name="surname"
                        placeholder={t("Surname")}
                        valueName={this.state.surname}
                        onChangeData={this.onChangeData}
                    />
                    <button
                        className="btn btn-primary "
                        type="button"
                        onClick={this.onClickSave}>{t('Update')}</button>
                        
                    </form>
                }
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
export default connect(mapStateToProps)(withTranslation()(withRouter(UpdateUserForm)));