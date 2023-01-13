import { apiCaller } from "./helper"

export const doRegister = (user) => {
    return apiCaller.post("/api/auth/register",user).then((response)=> response.data);
}