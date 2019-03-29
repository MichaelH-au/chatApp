import {createStore, applyMiddleware, combineReducers} from 'redux'
import thunk from 'redux-thunk'
import {reducer as userReducer} from './user'
import {reducer as headerReducer} from './header'

const reducer = combineReducers({
    user: userReducer,
    headerNav: headerReducer
})

const store = createStore(reducer, applyMiddleware(thunk))
export default store