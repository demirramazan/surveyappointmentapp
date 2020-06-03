import {PureComponent} from "react";

class Main extends PureComponent {

    render() {
        return (
            this.props.children
        );
    }
}
module.exports = Main;
