import React, {Component} from 'react';
import {connect} from 'react-redux';
import { pageChange } from "../../store/header/actions";
import {Link} from 'react-router-dom'

class MyComponent extends Component {


    generateRightButton() {
        return <Link to={'addContacts'} className='col-3 text-center text-decoration-none'>
                <i className='iconfont BottomNavIcon icon-adduser'></i>
            </Link>
    }

    componentDidMount() {
        this.props.pageChange("Contacts", null, this.generateRightButton())
    }
    render() {
        return (
            <div className="container">

            </div>
        );
    }
}

function mapStateToProps(state) {
    return {};
}
const actionCreators = {  pageChange }

export default connect(
    mapStateToProps, actionCreators
)(MyComponent);
