import { LOGIN_SUCCESS } from "./constants";
import { ERROR_MSG } from "./constants";

const defaultState = {
    username: 'testName',
    userId: '',
    face_image: '',
    face_image_big: '',
    nickname: '',
    qrcode: '',
    isAuth: false,
    errMsg: ''
}

export default function Users(state = defaultState, action) {
    switch (action.type) {
        case LOGIN_SUCCESS:
            return {...state, ...action.payload, isAuth: true}
        case ERROR_MSG:
            return {...state, errMsg: action.errMsg}
        default:
            return state
    }

}