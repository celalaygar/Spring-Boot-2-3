import React, { Component } from 'react'
import Input from '../../components/input';
import { withTranslation } from 'react-i18next';
import { signupHandler } from '../../redux/AuthenticationAction';
import { connect } from 'react-redux';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
class UserSignupPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: null,
            username: '',
            email: '',
            password: '',
            repeatPassword: "",
            name: '',
            surname: '',
            bornDate: new Date(), 
            errors: {
            }
        };
        this.onChangeData = this.onChangeData.bind(this);
    }

    onChangeData = (type, event) => {
        const { t } = this.props;

        const stateData = this.state;
        stateData[type] = event

        const errors = { ...this.state.errors }
        errors[type] = undefined;

        //match both of password for same
        if (type === 'password' || type === "repeatPassword") {
            if (type === 'password' && event !== this.state.repeatPassword) {
                errors.repeatPassword = t('Password mismatch');
            } else if (type === 'repeatPassword' && event !== this.state.password) {
                errors.repeatPassword = t('Password mismatch');
            } else {
                errors.repeatPassword = undefined;
            }
        }
        this.setState({ stateData, errors: errors });
    }
    onClickSignUp = async (e) => {
        // browser form içeriğini bir yere göndermesini engeller.
        // browserin bizim yerimize bir şey yapmasını engellemiş oluyoruz.
        e.preventDefault();
        this.setState({ errors: {} })
        let data = this.state;
        const { dispatch, history } = this.props;
        try {
            const response = await dispatch(signupHandler(data));
            console.log(response)
            history.push("/index");

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
        // .then(res=>{
        //      console.log(res.data);
        // })
        // .catch(error=> {
        //     if (error.response) {
        //         //console.log(error.response.data.message);
        //         console.log(error.response.data.message.body);
        //         AlertifyService.alert(error.response.data.message);
        //         this.setState({errors:error.response.data.message.headers.body.validationErrors})
        //     }
        //     else if (error.request) 
        //         console.log(error.request);
        //     else 
        //         console.log(error.message);
        // });
    }
    render() {
        const { username, email, password, repeatPassword } = this.state.errors;
        //const {errorUsername, errorEmail, errorPassword} = errors;
        const { t } = this.props;
        const isWeekday = date => {
            const day = date.getDay(date);
            return day !== 0 && day !== 6;
        };
        return (
            <div className="col-lg-12">
                <h3>{t('Sign Up')}</h3>
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
                        label={t("Email *")}
                        type="email"
                        error={email}
                        name="email"
                        placeholder={t("Email *")}
                        valueName={this.state.email}
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
                    <Input
                        label={t("Repeat Password *")}
                        error={repeatPassword}
                        type="password"
                        name="repeatPassword"
                        placeholder={t("Repeat Password *")}
                        valueName={this.state.repeatPassword}
                        onChangeData={this.onChangeData}
                    />
                    <Input
                        label={t("Name")}
                        //error={name}
                        type="text"
                        name="name"
                        placeholder={t("Name")}
                        valueName={this.state.name}
                        onChangeData={this.onChangeData}
                    />
                    <Input
                        label={t("Surname")}
                        //error={name}
                        type="text"
                        name="surname"
                        placeholder={t("Surname")}
                        valueName={this.state.surname}
                        onChangeData={this.onChangeData}
                    />
                    <div className="form-group">
                        <label>Born Date *</label>
                        <div className="form-group">
                            <DatePicker
                                className="form-control"
                                // showTimeSelect
                                showTimeInput
                                selected={this.state.bornDate}
                                onChange={e => this.onChangeData('bornDate', e)}
                                filterDate={isWeekday}          // disable weekend
                                timeIntervals={15}              // time range around 15 min
                                //showWeekNumbers               // show week number
                                timeFormat="HH:mm"              // show time format
                                dateFormat="yyyy/MM/dd h:mm aa" // show all of time format
                            />
                        </div>
                    </div>
                    <button
                        className="btn btn-primary "
                        type="button"
                        disabled={repeatPassword !== undefined}
                        onClick={this.onClickSignUp}>{t('Sign Up')}</button>
                </form>

            </div>
        )
    }
}
const translation = withTranslation()(UserSignupPage);
export default connect()(translation);