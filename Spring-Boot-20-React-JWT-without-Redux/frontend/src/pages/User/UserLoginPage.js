
import React, { Component } from 'react'
import Input from '../../components/input';
import { withTranslation } from 'react-i18next';
import ApiService from '../../Services/ApiService';
// import AlertifyService from '../../Services/AlertifyService';
// import LanguageSelector from '../../components/LanguageSelector';

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
        this.onChangeData = this.onChangeData.bind(this);
        this.onClickSignUp = this.onClickSignUp.bind(this);
        
    }
    
    onChangeData(type, event) {
        if(this.state.error)
            this.setState({error:null})
        const stateData = this.state;
        stateData[type] = event

        this.setState({ stateData});
    }
    onClickSignUp = async (event) =>{
        event.preventDefault();
        if(this.state.error){
            this.setState({error:null});
        }

        
        const {username, password} = this.state;
        const {onLoginSuccess} = this.props;
        

        const data = {  username,  password };
        try {
            const response = await ApiService.login(data)
            if(response){
                //console.log(response)
                localStorage.setItem("username", response.data.username);
                localStorage.setItem("jwttoken", response.data.jwttoken);
                localStorage.setItem("isLoggedIn", true);
                this.setState({error:null})

                const {push} = this.props.history;
                push("/index");
                onLoginSuccess( response.data.username, response.data.jwttoken)

            }
        } catch (error) {
            if (error.response) {
                if(error.response.data.message){
                    console.log(error.response)
                    this.setState({error:error.response.data.message})
                }
            }
            else if (error.request)
                console.log(error.request);
            else
                console.log(error.message);
        }
    }
    render() {       
        const { username,  password } = this.state.errors;
        const btnEnable = this.state.username && this.state.password;
        const { t } = this.props;
        return (
            <div className="col-lg-12">
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
                        className="btn btn-primary " 
                        type="button" 
                        disabled={!btnEnable}
                        onClick={this.onClickSignUp}>{t('Login')}</button>
                </form>
                <br/>
                { this.state.error ? 
                <div className="alert alert-danger" role="alert">
                    {this.state.error}
                </div>
                : null

                }
            </div>
        )
    }
}
export default withTranslation()(UserLoginPage);