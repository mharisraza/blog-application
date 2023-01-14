import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { isLoggedIn } from "../../auth/login";

const MainUserRoute = () => {
    return isLoggedIn() ? <Outlet /> : <Navigate to={"/login"} />;
}

export default MainUserRoute;