import { PAGE_CHANGE } from "./constants";

const defaultState = {
    title: 'Chat',
    returnPath: '',
    leftButton: false
}

export default function Users(state = defaultState, action) {
    switch (action.type) {
        case PAGE_CHANGE:
            console.log({...state, ...action.payload})
            return {...state, ...action.payload}
        default:
            return state
    }

}