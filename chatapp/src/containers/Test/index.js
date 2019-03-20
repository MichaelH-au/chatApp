import React, {Component} from 'react';

class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {
            receivedMessage:'',
            message: ''

        }
        this.socket = new WebSocket('ws://localhost:8088/ws')
    }
    componentDidMount() {
        if (window.WebSocket) {
            this.socket.onopen = function () {
                console.log('connect success')
            }
            this.socket.onclose = function () {
                console.log('connect close')
            }
            this.socket.onerror = function () {
                console.log('connect error')
            }
            this.socket.onmessage = function (e) {
                this.setState({
                    receivedMessage:e.data
                })
                console.log('get message')
            }.bind(this)


        }
    }
    sendMsg() {
        console.log(this.state.message)
        this.socket.send(this.state.message)
    }

    changeHendler(key, value) {
        this.setState({
            [key]:value
        })
    }

    render() {
        return (
            <div className="d-flex justify-content-around align-items-center flex-column" style={{height:"100vh"}}>
                <div>
                    <div>Send message</div>
                    <input type="text" name="msgContent" value={this.state.message} onChange={(e) => this.changeHendler('message', e.target.value)}/>
                    <button className="btn btn-success" onClick={() => this.sendMsg()}>Send</button>
                </div>

                <div>
                    <div>receive message</div>
                    <div>{this.state.receivedMessage}</div>
                    {/*<input type="text" name="msgContent"/>*/}
                    {/*<button className="btn btn-success">Send</button>*/}
                </div>
            </div>
        );
    }
}

export default Index;