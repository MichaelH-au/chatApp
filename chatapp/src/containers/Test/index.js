import React, {Component} from 'react';

class Index extends Component {
    render() {
        return (
            <div>
                <div>Send message</div>
                <input type="text" name="msgContent"/>
                <button className="btn btn-success">Send</button>


                <div>Send message</div>
                <input type="text" name="msgContent"/>
                <button className="btn btn-success">Send</button>
            </div>
        );
    }
}

export default Index;