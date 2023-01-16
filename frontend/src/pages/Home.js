import Base from "../components/Base";
import Header from "../components/Header";
import React from 'react';
import { NavLink as ReactLink } from "react-router-dom";
import {
  Container,
  Row,
  Col,
  Jumbotron,
  Button
} from 'reactstrap';


const Home = () => {
  return (
    <Base>
    <div className="container mt-5 mx-auto ml-3 right">
      <div>
        <Container className=" py-3">
          <Row>
            <Col>
              <h1 className="display-3">Welcome to Blogit</h1>
              <p className="lead">
                Join the blogging community and share your thoughts and ideas
                with the world.
              </p>
              <hr className="my-2" />
              <p>
                With Blogit, you can write, publish, and share your own blog
                posts, connect with other writers, and discover new ideas and
                perspectives.
              </p>
              <p className="lead">
                <Button tag={ReactLink} to="/register" size="lg" className="btn btn-success">Register Now</Button>
              </p>
            </Col>
          </Row>
        </Container>
      </div>
      </div>
    </Base>
  );
};

export default Home;
