import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './font_icon/iconfont.css'
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import { Provider }from 'react-redux'
import store from './store'

//Containers
import Test from "./containers/Test"
import BottomNavBar from "./components/BottomNavBar"
import Chats from './containers/Chats'
import Contacts from './containers/Contacts'
import Discover from './containers/Discover'
import Me from './containers/Me'


ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <div>
                <Switch>
                    <Route path='/' exact component={Test}></Route>
                </Switch>
                <Switch>
                    <Route path='/chats' exact component={Chats}></Route>
                </Switch>
                <Switch>
                    <Route path='/contacts' exact component={Contacts}></Route>
                </Switch>
                <Switch>
                    <Route path='/discover' exact component={Discover}></Route>
                </Switch>
                <Switch>
                    <Route path='/me' exact component={Me}></Route>
                </Switch>
                <BottomNavBar/>
            </div>
        </BrowserRouter>
    </Provider>
    , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
