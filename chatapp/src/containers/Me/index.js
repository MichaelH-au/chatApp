import React, {Component} from 'react';
import {connect} from 'react-redux';
import { pageChange } from "../../store/header/actions";
import { Redirect, Link } from "react-router-dom"

import "./me.css"

class MyComponent extends Component {

    componentDidMount() {
        this.props.pageChange("Me")
    }

    generateInfoBox(title, value) {
        return (
            <div className="row justify-content-between p-0 text-center align-items-center infoBox text-black-50">
                <div className="col-2">{title}</div>
                <div className="col-2">{value}</div>
            </div>
        )
    }

    render() {
        console.log(this.props.user)
        return (
            <div className="container pt-4">
                {/*{this.props.user.isAuth ? null : <Redirect to='/login'></Redirect>}*/}
                <Link to="/MyAvatar" className="text-decoration-none text-black-50">
                    <div className="row justify-content-between p-0 text-center align-items-center avatar">
                        <div className="col-2">Avatar</div>
                        <div className="col-2"><img className='w-100' src={this.props.user.face_image} alt=""/></div>
                    </div>
                </Link>
                {this.generateInfoBox("Nickname", this.props.user.nickname)}
                {this.generateInfoBox("Username", this.props.user.username)}
                <div className="row text-center p-0 mt-5 logout align-items-center justify-content-center text-black-50">Logout</div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        user: state.user
    };
}
const actionCreators = {  pageChange }

export default connect(
    mapStateToProps, actionCreators
)(MyComponent);
