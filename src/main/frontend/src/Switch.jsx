import React,{PureComponent} from "react";
import HasAuthorization from "./router/HasAuthorization";
import NoAuthorization from "./router/NoAuthorization";
import cookie from "react-cookie";

export default class Switch extends PureComponent {
    constructor(props) {
        super(props);
        let username = cookie.load("username");
        let token = sessionStorage.getItem('Authorization');
        if (username == undefined) {
            if (token) {
                var base64Url = token.split('.')[1];
                var base64 = base64Url.replace('-', '+').replace('_', '/');
                var str = JSON.parse(window.atob(base64));
                username = str.sub;
                cookie.save('username', username);
            }
        }
        
        // let me = this;

        // ajax.ajaxSetup({
        //     complete: function (jqXHR, textStatus, errorThrown) {
        //         switch (jqXHR.status) {
        //             case 401:
        //                 cookie.remove("username");
        //                 sessionStorage.clear();
        //                 me.setState({hasAuth: false});
        //                 break;
        //             case 403:
        //                 Toast.error("Yetki Hatası !");
        //                 break;
        //             case 404 :
        //                 // Toast.error("Sayfa bulunamadı ! ");
        //                 break;
        //                 break;
        //             case 422 :
        //                 Toast.error("Verilerinizi kontrol ediniz.");
        //                 break;
        //             case 500:
        //                 Toast.error("Sistem Hatası");
        //                 break;
        //
        //         }
        //     }
        // });

        this.state = {
            hasAuth: (username && username.trim() !== "" && token && token.trim() !== ""),
            menu: undefined
        };
    }

    render() {
        let content;
        if (!this.state.hasAuth) {
            // Progress.done();
            content = <NoAuthorization />;
        }
        else {
            // Progress.done();
            content = <HasAuthorization menu={this.state.menu}/>;
        }

        return (
            <div>
                {content}
            </div>
        );

    }
}
