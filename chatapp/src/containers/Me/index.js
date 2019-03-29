import React, {Component} from 'react';
import {connect} from 'react-redux';
import { pageChange } from "../../store/header/actions";

class MyComponent extends Component {

    componentDidMount() {
        this.props.pageChange("Me")
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
