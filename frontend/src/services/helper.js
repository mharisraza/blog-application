import  axios from "axios";
export const BASE_URL='http://localhost:8000';

export const apiCaller = axios.create({
    baseURL: BASE_URL,  
});


export const SOMETHING_WENT_WRONG_ERROR = "ERROR_CODE: 0x01";
export const USER_ALREADY_EXIST_REGISTER_ERROR = "ERROR_CODE: 0x02";
export const INVALID_PASSWORD = "ERROR_CODE: 0x03";