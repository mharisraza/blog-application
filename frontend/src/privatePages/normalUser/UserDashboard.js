import React from "react";
import { ToastContainer } from "react-toastify";
import { Button, Col, Container, Row } from "reactstrap";
import { NavLink as ReactLink } from "react-router-dom";
import Base from "../../components/Base";

const UserDashboard = () => {
    return(<Base>
    <ToastContainer />
    <div className="container">
        <div className="row">
               <div className="col-sm-6 offset-sm-9 text-center mt-3">
                       <Button color="danger"><i className="fa-solid fa-blog"></i>&nbsp;Your Blogs: 0</Button>
                       <Button color="danger"><i className="fas fa-heart"></i>&nbsp;Total Likes: 0</Button>
               </div>
        </div>
</div>
        <div className="container mt-3">
              <div className="row">
                 <div className="col-sm-6 mr-4 text-center">
                       <h1>Write a new blog!</h1>
                       <hr />
                       <p>
                       With Blogit, you can write, publish, and share your own blog posts, connect with other writers, and discover new ideas and perspectives.
                       </p>
                       <Button color="primary">Add new blog</Button>
                 </div>
              </div>
        </div>
    </Base>);
}

export default UserDashboard;