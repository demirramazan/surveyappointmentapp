import React from "react";
import { Router, Route,Component } from "react-router";
import hashHistory from "react-router/lib/hashHistory";
import NotFound from "../common/NotFound";
import loader from "./loader";
import  JwtAjaxRequest   from "../ajax/JwtAjaxRequest"
import cookie from "react-cookie";
export default class HasAuthorization extends Component {

    menuRequest = new JwtAjaxRequest({ url: "menus", type: "GET", serviceName: 'auth' });

    static ROUTES = [];
    static ROUTER;

    constructor(props) {
        super(props);
        this.state = {
            menus: undefined
        };
    }

    render() {
        if (!this.state.menus) {
            return (<span />);
        }
        HasAuthorization.ROUTER = HasAuthorization.createRoutes(this.state.menus);

        return (<Router key="root"
            history={hashHistory}
            onUpdate={HasAuthorization.scrollTop}
            routes={HasAuthorization.ROUTER} />);
    }

    static createRoutes(menu) {


        HasAuthorization.importMenu(menu);
        HasAuthorization.ROUTES.push({ path: "*", component: NotFound });

        return ({
            menu: menu,
            path: "/",
            component: Workspace,
            indexRoute: NotFound,
            childRoutes: HasAuthorization.ROUTES
        });
    }

    static importMenu(items) {
        for (let i = 0; i < items.length; i++) {
            let item = items[i];
            if (item.items && item.items.length > 0) {
                HasAuthorization.importMenu(item.items);
            } else {
                const path = HasAuthorization.normalizePath(item.path);

                let obj = {
                    path: item.module,
                    getComponent(location, cb) {
                        loader(path, cb);
                    }
                };
                HasAuthorization.ROUTES.push(obj);
            }
        }
    }


    /**
     * this function changing absolute path to relative path
     */
    static normalizePath(path) {
        if (path && !(path.indexOf("../") >= 0)) {
            return "" + path;
        }
        return path;
    }

    static scrollTop() {
        window.scrollTo(0, 0);
    }

    componentDidMount() {
        this.menuRequest.call(undefined, undefined,
            (res) => {
                this.setState({ menus: res })
            }, (err) => {
                this.__onExit();
            });
    }
    logoutPost = new AjaxRequest({
        url: "logout",
        type: "POST"
    });
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
}
