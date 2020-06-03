import React, {PureComponent} from "react";
import {Button, Card, Col, Form} from "reactstrap";
import cookie from "react-cookie";
// import jwtDecode from "jwt-decode";
const Package = require("../../package.json");
class Login extends PureComponent {

    // loginPost = new JwtAjaxRequest({
    //     url: "login",
    //     type: "POST",
    //     serviceName: 'auth'
    // });

    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: "",
            sicil: '',
            rememberme: false,
        };
    }

    render() {
        return (
            <div className="center-block"
                style={{ maxWidth: 350, margin: "30px auto" }}>
                <Card>
                    <Form>
                        {/*<div style={{ textAlign: "center", marginBottom: "30px", background: "#153647", padding: "0px" }}>*/}
                        {/*    /!*<img src="./logo.png" style={{ margin: "0 auto", height: "200px", width: '350px' }} />*!/*/}
                        {/*</div>*/}
                        <Col>
                            <TextInput
                                ref="username"
                                type="email"
                                name="username"
                                placeholder="Kullanıcı Adı"
                                value={this.state.username}
                                onChange={this.__handleChange}
                                // inputGroupLeft={<InputGroupAddon><FaIcon code="fa-user" /></InputGroupAddon>}
                                validationDisplay="block"
                                onKeyPress={this.__onKeyPress}
                                maxLength={8}
                            />
                        </Col>
                        <Col>
                            <TextInput
                                ref="sicil"
                                type="email"
                                name="sicil"
                                placeholder="Sicil"
                                value={this.state.sicil}
                                onChange={this.__handleChange}
                                // inputGroupLeft={<InputGroupAddon><FaIcon code="fa-user" /></InputGroupAddon>}
                                validationDisplay="block"
                                onKeyPress={this.__onKeyPress}
                                maxLength={6}
                            />
                        </Col>
                        <Col>
                            <PasswordInput
                                ref="password"
                                name="password"
                                className="form-control"
                                value={this.state.password}
                                onChange={this.__handleChange}
                                // inputGroupLeft={<InputGroupAddon><FaIcon code="fa-lock" /></InputGroupAddon>}
                                placeholder="Şifre"
                                onKeyPress={this.__onKeyPress}
                                maxLength={8}
                            />
                        </Col>
                        <Col>
                            <Button
                                ref="submitBtn"
                                onClick={this.__handleSubmit}
                                color="warning"
                                block
                            >
                                Giriş
                            </Button>
                        </Col>
                        <div className="versionNo" style={{ marginLeft: "17px", fontSize: "13px" }}>
                            V.{Package.version}
                    </div>
                    </Form>

                </Card>
            </div >
        );
    }

    __handleChange(e) {
        let state = {};
        state[e.target.name] = e.target.value;
        this.setState(state);
        return true;
    }

    __handleSubmit() {
        cookie.remove("auth-token");
        var username = this.state.username.trim();
        var password = this.state.password.trim();
        var sicil = this.state.sicil.trim();
        if (!password || !username || !sicil) {
            return;
        }

        let data = {
            username: username,
            password: password,
        };


        this.loginPost.call(data, undefined, this.__loginSuccess, this.__loginError);
        // this.__loginSuccess({username:'admin'})
    }

    __loginSuccess(response) {
        var token = response.token;
        var str = jwtDecode(token);
        cookie.save('username', str.sub);
        sessionStorage.setItem('Authorization', token);
        location.reload();

    }


    __loginError(response, textStatus, xhr) {
        var text = response.responseText;
        switch (response.status) {

            case 200:
                text = "";
                break;
            case 401:
            case 403:
                text = "Kullanıcı adı ya da şifre hatalı girdiniz.";
                break;
            case 412:
            case 500:
                text = JSON.parse(response.responseText).message
                break;
            default:
                text = "Lütfen daha sonra tekrar deneyiniz.";
                break;
        }
      
        // Toast.error(text);

    }

    __onKeyPress(e) {
        if (e.key == "Enter")
            this.__handleSubmit();
    }
}

module.exports = Login;
