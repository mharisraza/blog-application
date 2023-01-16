import React, { useEffect, useState } from "react";
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
  Col,
} from "reactstrap";
import { getUser, isLoggedIn } from "../auth/login";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  const [login, setLogin] = useState(false);
  const [user, setUser] = useState(undefined);

  useEffect(() => {
    setLogin(isLoggedIn());
    setUser(getUser());
  }, [isLoggedIn()]);

  return (
    <Navbar className="navbar-horizontal navbar-dark bg-primary" expand="lg">
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
                <img alt="..." src={"../png"} />
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
              <i class="fas fa-home"></i>Home
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="#pablo" onClick={(e) => e.preventDefault()}>
              <i class="fa-brands fa-blogger-b"></i>Blogs
            </NavLink>
          </NavItem>
        </Nav>

        <Nav className="ml-auto text-center d-flex" navbar>
          {login && user && (
            <NavItem>
              <NavLink>
                <UncontrolledDropdown className="w-100">
                  <DropdownToggle caret className="w-100" color="warning">
                    <img
                      className="rounded-circle"
                      width={20}
                      src="https://demos.creative-tim.com/argon-design-system-react/static/media/team-1-800x800.53033970.jpg"
                    />
                    &nbsp;&nbsp;Muhammad Haris
                  </DropdownToggle>
                  <DropdownMenu className="dropdown-menu">
                    <DropdownItem tag={ReactLink} to="/user/profile">
                      <i className="ni ni-settings-gear-65" />
                      Profile
                    </DropdownItem>
                    <DropdownItem tag={ReactLink} to="/logout">
                      <i className="ni ni-bold-right" />
                      Logout
                    </DropdownItem>
                  </DropdownMenu>
                </UncontrolledDropdown>
              </NavLink>
            </NavItem>
          )}
          {!login && (
            <NavItem>
              <NavLink tag={ReactLink} to="/login">
                <Button className="w-100" color="success">
                  <i class="fa-solid fa-user"></i>Login
                </Button>
              </NavLink>
            </NavItem>
          )}
        </Nav>
      </UncontrolledCollapse>
    </Navbar>
  );
};

export default Header;
