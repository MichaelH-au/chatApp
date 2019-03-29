import { PAGE_CHANGE } from "./constants";

export function pageChange(title, returnPath = '', leftButton=false) {
    return dispatch => dispatch({type: PAGE_CHANGE, payload: {title, returnPath, leftButton}})
}
