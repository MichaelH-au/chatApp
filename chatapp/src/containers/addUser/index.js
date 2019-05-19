import React, {Component} from 'react';
import {connect} from 'react-redux';
import { pageChange } from "../../store/header/actions";
import BackButton from "../../components/Button/backButton"
import './style.css'
import axios from 'axios'

class AddUser extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userName: "",
            searchList:[]
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

    search() {
        axios.get(`/users/${this.state.userName}`)
            .then(data => {
                console.log(data.data.data)
                // console.log(this)
                this.setState({
                    searchList:data.data.data
                })
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
                <div className='row align-items-center border-bottom pointer' onClick={() => this.search()} style={{height:'60px'}}>
                    <div className='searchIcon mx-3'>
                        <i className='iconfont icon-search col-1 text-white'></i>
                    </div>
                    <div>Search: </div>
                    <div className='text-success ml-2'>{this.state.userName}</div>
                </div>
                {this.state.searchList.map((user, index) => (
                    <div className='row align-items-center border-bottom pointer' key={index} onClick={() => this.search()} style={{height:'60px'}}>
                        <img className='userImage mx-3' src={user.face_image} alt=""/>
                        <div>{user.nickname}</div>
                    </div>)
                )}
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
