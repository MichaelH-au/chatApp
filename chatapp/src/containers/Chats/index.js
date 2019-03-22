import React, {Component} from 'react';
import {connect} from 'react-redux';

class MyComponent extends Component {
    render() {
        return (
            <div className='container'>
                {this.props.user.username}
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        user: state.user
    };
}

export default connect(
    mapStateToProps,
)(MyComponent);
