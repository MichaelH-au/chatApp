import React, {Component} from 'react';
import {connect} from 'react-redux';
import { login } from "../../store/user/actions";
import { Redirect } from 'react-router-dom'

class MyComponent extends Component {
    componentDidMount() {
        // this.props.login('user', 'password')
    }
    render() {
        return (
            <div className='container'>
                {this.props.user.isAuth ? null : <Redirect to='/login'></Redirect>}
                {/*{this.props.user.username}*/}
                test
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        user: state.user
    };
}

const actionCreators = { login }

export default connect(
    mapStateToProps, actionCreators
)(MyComponent);
