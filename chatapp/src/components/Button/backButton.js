import React, {Component} from 'react';
import { Link } from 'react-router-dom'

class BackButton extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <Link to={this.props.returnPage} className='col-3 text-center text-decoration-none'>
            <i className='iconfont  icon-back'></i>
        </Link>
    }
}

export default BackButton;

