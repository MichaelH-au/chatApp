import { PAGE_CHANGE } from "./constants";

export function pageChange(title, leftButton=false, rightButton=false) {
    return dispatch => dispatch({type: PAGE_CHANGE, payload: {title, leftButton, rightButton}})
}
