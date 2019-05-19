import React, {Component} from 'react';
import {connect} from 'react-redux';
import { pageChange } from "../../store/header/actions";
import BackButton from "../../components/Button/backButton"
import './style.css'

class AddUser extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userName: ""
        }
    }

    componentDidMount() {
        this.props.pageChange("Add Contacts", <BackButton returnPage="contacts"/>)
    }

    changeHandler(key, value) {
        this.setState({
            [key]: value
        })
    }

    render() {
        return (
            <div className="container">
                <div className='row position-relative align-items-center p-2' style={{height:'40px'}}>
                    <i className='iconfont searchInputIcon icon-search col-1'></i>
                    <input type="text" className='col-9 pl-5' value={this.state.userName} onChange={(e) => this.changeHandler('userName', e.target.value)}/>
                    <div className='col-3 text-center pointer' onClick={() => this.changeHandler('userName', '')}>Cancel</div>
                </div>
                <div className='row align-items-center border-bottom pointer' style={{height:'60px'}}>
                    <div className='searchIcon mx-3'>
                        <i className='iconfont icon-search col-1 text-white'></i>
                    </div>
                    <div>Search: </div>
                    <div className='text-success ml-2'>{this.state.userName}</div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {user: state.user};
}

const actionCreator = {pageChange}

export default connect(
    mapStateToProps, actionCreator
)(AddUser);
