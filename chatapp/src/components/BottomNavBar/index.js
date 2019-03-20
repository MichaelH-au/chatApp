import React, {Component} from 'react';
import './BottomNavBar.css'
import {Link} from 'react-router-dom'

class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {
            index:0
        }
    }

    changeHandler(key, value) {
        this.setState({
            [key]:value
        })
    }

    render() {
        return (
            <div className='container bottomNavBarContainer' >
                <div className='row justify-content-center p-0 m-0'>
                    <Link to='/chats' className='col-3 text-center text-decoration-none'
                          onClick={() => this.changeHandler('index',0)}
                    >
                        <i className={`iconfont BottomNavIcon ${this.state.index === 0 ? 'icon-wechat2 tabActive' : 'icon-wechat'}`}></i>
                        <div className={`BottomNavName ${this.state.index === 0 ? 'tabActive' : ''}`}>Chats</div>
                    </Link>
                    <Link to='contacts' className='col-3 text-center text-decoration-none'
                          onClick={() => this.changeHandler('index',1)}
                    >
                        <i className={`iconfont BottomNavIcon ${this.state.index === 1 ? 'icon-icon-contacts tabActive' : 'icon-icon-contacts-o'}`}></i>
                        <div className={`BottomNavName ${this.state.index === 1 ? 'tabActive' : ''}`}>Contacts</div>
                    </Link>
                    <Link to='discover' className='col-3 text-center text-decoration-none'
                          onClick={() => this.changeHandler('index',2)}
                    >
                        <i className={`iconfont BottomNavIcon ${this.state.index === 2 ? 'icon-faxian tabActive' : 'icon-discover'}`}></i>
                        <div className={`BottomNavName ${this.state.index === 2 ? 'tabActive' : ''}`}>Discover</div>
                    </Link>
                    <Link to='/me' className='col-3 text-center text-decoration-none'
                          onClick={() => this.changeHandler('index',3)}
                    >
                        <i className={`iconfont BottomNavIcon ${this.state.index === 3 ? 'icon-geren6 tabActive' : 'icon-my'}`}></i>
                        <div className={`BottomNavName ${this.state.index === 3 ? 'tabActive' : ''}`}>Me</div>
                    </Link>
                </div>
            </div>
        );
    }
}

export default Index;