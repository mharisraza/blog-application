// check if user logged in or not.
export const isLoggedIn = () => {
    let data = localStorage.getItem("data");
    if (data != null) return true;
    return false;
}

// do login 
export const doLoginAfterGettingToken=(data, next)=> {
    localStorage.setItem("data",JSON.stringify(data));
    next();
}

// do logout
export const doLogout = (next) => {
    localStorage.removeItem("data");
    next();
}

// get user
export const getUser = () => {
    if (isLoggedIn) return JSON.parse(localStorage.getItem("data"));
    return false;
}