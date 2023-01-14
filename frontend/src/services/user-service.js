import { apiCaller } from "./helper"

export const doRegister = (user) => {
    return apiCaller.post("/api/auth/register",user).then((response)=> response.data);
}

export const doLogin = (user) => {
    return apiCaller.post("/api/auth/login",user).then((response)=> response.data);
}