import axios from 'axios'
import {LOGIN_SUCCESS} from "./constants";
import {ERROR_MSG} from "./constants";

function loginSuccess(data) {
    return {type:LOGIN_SUCCESS, payload:data}
}

function errorMsg(errMsg) {
    return {type: ERROR_MSG, errMsg}
}

export function login(username, password) {
    if (!username) {
        return dispatch => dispatch(errorMsg("Username should not be empty"))
    }
    if (!password) {
        return dispatch => dispatch(errorMsg("Password should not be empty"))
    }
    console.log(username,password)
    return dispatch => {
        axios.post('/user/login', {username, password})
            .then(res => {
                if (res.data.status === 'success') {
                    dispatch(loginSuccess(res.data.data))
                } else {
                    dispatch(errorMsg("Invalid username or password"))
                }
            })
    }
}

