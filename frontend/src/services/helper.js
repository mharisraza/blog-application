import  axios from "axios";
export const BASE_URL='http://localhost:8000';

export const apiCaller = axios.create({
    baseURL: BASE_URL,  
});


export const SOMETHING_WENT_WRONG_ERROR = "0x01";
export const USER_ALREADY_EXIST_REGISTER_ERROR = "0x02";