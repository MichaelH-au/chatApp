import React, {Component} from 'react';
import {connect} from 'react-redux';
import { Redirect }from 'react-router-dom'
import { login } from "../../store/user/actions";
import './style.css'


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username:'',
            password:''
        }
    }

    changeHandler(key, value) {
        this.setState({
            [key]: value
        })
    }

    login() {
        this.props.login(this.state.username,)
    }

    render() {
        return (
            <div className='contentContainer'>
                {this.props.user.isAuth ? <Redirect to='/chats'></Redirect> : null}
                <div className='d-flex justify-content-center align-items-center flex-column h-100 p-0 w-100'>
                    <img style={{width:'300px'}} src="http://www.stickpng.com/assets/images/580b57fcd9996e24bc43c542.png" alt=""/>
                    <div className='mt-4'>
                        <div>
                            <input type="text" placeholder='username'
                                   value={this.state.username}
                                   onChange={(e) => this.changeHandler('username', e.target.value)}
                            />
                        </div>
                        <div className='mt-4'>
                            <input type="text" placeholder='password'
                                   value={this.state.password}
                                   onChange={(e) => this.changeHandler('password', e.target.value)}
                            />
                        </div>
                        <button className='btn btn-success w-100 mt-5'
                                onClick={() => this.props.login(this.state.username, this.state.password)}
                        >
                            Login
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        user:state.user
    };
}

const actionCreators = { login }

export default connect(
    mapStateToProps, actionCreators
)(Login);
