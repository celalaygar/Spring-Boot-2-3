import React, { Component } from 'react'
import Input from '../../components/input';
import { withTranslation } from 'react-i18next';
// import AlertifyService from '../../Services/AlertifyService';
// import LanguageSelector from '../../components/LanguageSelector';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { /*loginAction,*/ loginHandler } from './../../redux/AuthenticationAction';

class UserLoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: null,
            password: '',
            error: null,
            errors: {
            }
        };
        this.onClickLogin = this.onClickLogin.bind(this);
    }

    onChangeData = (type, event) => {
        if (this.state.error)
            this.setState({ error: null })
        const stateData = this.state;
        stateData[type] = event

        this.setState({ stateData });
    }
    onClickLogin = async (event) => {
        event.preventDefault();
        if (this.state.error) {
            this.setState({ error: null });
        }
        const { username, password } = this.state;
        const { dispatch, history } = this.props;
        const data = { username, password };
        console.log(data)
        try {
            await dispatch(loginHandler(data));
            // const response = await ApiService.login(data)
            // if (response) {
            //     this.setState({ error: null })
            //     const authState = {
            //         ...response.data,
            //         isLoggedIn: true,
            //         password: this.state.password,
            //         email: null,
            //         image: "https://i.milliyet.com.tr/MolatikDetayBig/2019/04/12/fft371_mf32728256.Jpeg"
            //     }
            //     ApiService.changeAuthToken(response.data.jwttoken);
            //     dispatch(loginAction(authState));
            // }
            history.push("/index");
        } catch (error) {
            if (error.response) {
                if (error.response.data.message) {
                    console.log(error.response)
                    this.setState({ error: error.response.data.message })
                }
            }
            else if (error.request)
                console.log(error.request);
            else
                console.log(error.message);
        }
    }
    render() {
        //const { isLoggedin, username } = state;
        const { username, password } = this.state.errors;
        const btnEnable = this.state.username && this.state.password;
        const { t } = this.props;
        return ( 
                <div className="container row">

                <div className="col-lg-8">
                    <h3>{t('Login')}</h3>
                    <hr />
                    <p className="description-p" style={{ color: "red" }}>  ( * ) Zorunlu alanlar</p>
                    <form >
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
                            label={t("Password *")}
                            error={password}
                            type="password"
                            name="password"
                            placeholder={t("Password *")}
                            valueName={this.state.password}
                            onChangeData={this.onChangeData}
                        />
                        <button
                            className="btn btn-primary"
                            type="button"
                            disabled={!btnEnable}
                            onClick={this.onClickLogin}>{t('Login')}</button>
                    </form>
                    <br />
                    {this.state.error ?
                        <div className="alert alert-danger" role="alert">
                            {this.state.error}
                        </div>
                        : null

                    }
                </div>
                <div className="col-lg-3">
                    <img style={{ height: 200 }} src="https://images.squarespace-cdn.com/content/v1/55e06d0ee4b0718764fcc921/1507805805238-M8XG4RMCMWITZ7LJGEEF/ke17ZwdGBToddI8pDm48kETUuxmp5xHjxR_mq0kKQipZw-zPPgdn4jUwVcJE1ZvWhcwhEtWJXoshNdA9f1qD7XbdY2v8mR--EcMEe2KaFSVzNBu9Qs0q6qR3QzqKFtHJVM6oy5K0EEbGe9v0FXNpEg/slidebank+login.gif" alt="" />
                </div>
                <div className="col"></div>
                <div className="col-lg-12">
                    <hr />
                    <hr />
                    <hr />
                </div>
            </div> 
        )
    }
}
// withTranslation to change language (turkısh <=> english)
// connect for redux
export default connect()(withTranslation()(withRouter(UserLoginPage)));