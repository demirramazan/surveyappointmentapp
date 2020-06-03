/*import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();*/

import React from "react";
import ReactDOM from "react-dom";
import Switch from "./Switch";
import 'bootstrap/dist/css/bootstrap.css';
import 'react-month-picker/css/month-picker.css';


const appNode = document.getElementById("app");
ReactDOM.render(<Switch/>, appNode);
