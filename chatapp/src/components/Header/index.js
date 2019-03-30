import React, {Component} from 'react';
import {connect} from 'react-redux';

import "./header.css"

class MyComponent extends Component {
    render() {
        return (
            <div className="headerContainer">
                <div className="row text-center align-items-center justify-content-center h-100">
                    {this.props.headerNav.leftButton
                        ?
                        <div className="col-2">{this.props.headerNav.leftButton}</div>
                        :
                        <div className="col-2"></div>
                    }
                    <div className="col-8">{this.props.headerNav.title}</div>
                    {this.props.headerNav.rightButton
                        ?
                        <div className="col-2">{this.props.headerNav.rightButton}</div>
                        :
                        <div className="col-2"></div>
                    }
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
