import React from "react";
import ShallowComponent from "robe-react-commons/lib/components/ShallowComponent";
import AjaxRequest from "robe-react-commons/lib/connections/AjaxRequest";
import { Navbar, Col, Badge, Image, Button, ButtonGroup, NavbarToggler, NavbarBrand, Collapse, Nav, NavItem, NavLink } from "reactstrap";
import FaIcon from "robe-react-ui/lib/faicon/FaIcon";
import Link from "react-router/lib/Link";
import cookie from "react-cookie";
import "./style.css";
import jwtDecode from "jwt-decode";
export default class Header extends ShallowComponent {
    static propTypes = {
        matches: React.PropTypes.bool,
        toggled: React.PropTypes.bool
    };
    static defaultProps = {
        toggled: false,
        matches: false
    };
    logoutPost = new AjaxRequest({
        url: "logout",
        type: "POST"
    });
    
    constructor(props) {
        super(props);

        let username = '';
        let sicil = '';
        this.state = {
            data: [],
        };
    }
    render() {
        this.__KullaniciBilgi()
        return (
            <Navbar color="faded" toggleable style={{ background: "#FFD300" }} className="robe-header-navbar">
                <Button onClick={this.__onToggle}
                    style={{ display: this.props.toggled ? "none" : "inherit", marginTop: 6 }}
                    className="navbar-toggle pull-left robe-navbar-button" color="link">
                    <FaIcon code="fa-bars" />
                </Button>
                <Button onClick={this.__onToggle}
                    style={{
                        display: this.props.matches && this.props.toggled ? "inherit" : "none", marginTop: 6
                    }}
                    className="navbar-toggle pull-left robe-navbar-button" color="link">
                    <FaIcon code="fa-bars" />
                </Button>
                <Link to="/">
                    <img src="./PTT.png"
                        className="pull-left"
                        style={{ marginLeft: 5 }} //#34558b  **#166187   ***#014B96
                        width="50" />

                </Link>
                <Link to="/">
                    <Col style={{ fontWeight: "Bold", fontSize: "30px", color: "#0158a3 ", lineHeight: "30px", height: "9px", }} >  E-Tahsilat </Col>
                </Link>
                <Nav className="ml-auto header-navbar-right" navbar>
                <label style={{fontWeight: "Bold", color: "#0158a3 ", marginBottom:'5px',marginRight:'3px', marginBottom:'3px', fontSize:'15px', marginRight:'20px'}}> {this.username} /  {this.sicil}</label>
                    <Button
                        className="robe-navbar-button"
                        onClick={this.__onExit} color="link">
                        <FaIcon code="fa-sign-out" />
                    </Button>
                    <label style={{marginRight:'20px', }}>  </label>
                </Nav>

            </Navbar>
        );
    }
    __KullaniciBilgi() {

        var token = sessionStorage.getItem('Authorization');
        var str = jwtDecode(token);
        this.username = str.user.username;
        this.sicil = str.user.sicil;
    }
    __onExit = () => {
        cookie.remove('domain');
        cookie.remove('username');
        sessionStorage.clear();
        window.location.hash = "";
        this.logoutPost.call(undefined, undefined,
            function (res) {
                location.reload();
            }.bind(this),
            function (res) {
                location.reload();
            }.bind(this));
    };
    __onToggle = () => {
        if (this.props.onToggle)
            this.props.onToggle();
    }
}