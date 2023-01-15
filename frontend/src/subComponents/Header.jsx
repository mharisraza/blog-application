import React, { useState } from "react";
import { Link, NavLink as ReactLink } from "react-router-dom";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
  Button,
  Container,
  Row,
  UncontrolledCollapse,
  Col
} from "reactstrap";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <Navbar 
          className="navbar-horizontal navbar-dark bg-primary"
          expand="lg"
        >

            <NavbarBrand tag={ReactLink} to="/">
              Blog-it
            </NavbarBrand>
            <button
              aria-controls="navbar-primary"
              aria-expanded={false}
              aria-label="Toggle navigation"
              className="navbar-toggler"
              data-target="#navbar-primary"
              data-toggle="collapse"
              id="navbar-primary"
              type="button"
            >
              <span className="navbar-toggler-icon" />
            </button>
            <UncontrolledCollapse navbar toggler="#navbar-primary">
              <div className="navbar-collapse-header">
                <Row>
                  <Col className="collapse-brand" xs="6">
                  <Link to="/">
                      <img
                        alt="..."
                        src={"data:image/png;base64,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"}
                      />
                    </Link>
                  </Col>
                  <Col className="collapse-close" xs="6">
                    <button
                      aria-controls="navbar-primary"
                      aria-expanded={false}
                      aria-label="Toggle navigation"
                      className="navbar-toggler"
                      data-target="#navbar-primary"
                      data-toggle="collapse"
                      id="navbar-primary"
                      type="button"
                    >
                      <span />
                      <span />
                    </button>
                  </Col>
                </Row>
              </div>
              <Nav className="ms-auto text-center" navbar>
                <NavItem>
                  <NavLink tag={ReactLink} to="/home">
                  <i class="fa-solid fa-house"></i>Home
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="#pablo" onClick={e => e.preventDefault()}>
                  <i class="fa-brands fa-blogger-b"></i>Blogs
                  </NavLink>
                </NavItem>
              </Nav>

              <Nav className="ml-auto text-center" navbar>
                 <NavItem>
                  <NavLink tag={ReactLink} to="/login">
                  <Button className="w-100" color="success"><i class="fa-solid fa-user"></i>Login</Button>
                  </NavLink>
                 </NavItem>
              </Nav>
            </UncontrolledCollapse>
        </Navbar>
      
  );
};

export default Header;