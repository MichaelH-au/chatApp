import React, {Component} from 'react';
import {connect} from 'react-redux';

import "./header.css"

class MyComponent extends Component {
    render() {
        return (
            <div className="headerContainer">
                <div className="row text-center align-items-center justify-content-center h-100">
                    <div className="col-2">{"<"}</div>
                    <div className="col-8">{this.props.headerNav.title}</div>
                    <div className="col-2"></div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        headerNav: state.headerNav
    };
}

export default connect(
    mapStateToProps,
)(MyComponent);
