import React, { useState } from "react";
import { NavLink as ReactLink } from "react-router-dom";
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
  Button
} from "reactstrap";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
      <Navbar
        expand="md"
        className="main-navbar"
        dark
      >
        <NavbarBrand className="fw-bold" tag={ReactLink} to="/" >
          BLOG-it
        </NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto text-center  navbar-expand-xl" navbar>
            <NavItem>
              <NavLink className="active" tag={ReactLink} to="/home" ><li className="fas fa-home"></li>&nbsp;Home</NavLink>
            </NavItem>

            <NavItem>
              <NavLink tag={ReactLink} to="/blogs" >
                <li className="fa-brands fa-blogger-b"></li>&nbsp;Blogs
              </NavLink>
            </NavItem>

           


          </Nav>

          <Nav className="ms-auto text-center" navbar>

          <NavItem>
              <NavLink tag={ReactLink} to="/login" className="btn btn-block btn-warning text-dark fw-bold">
              <i class="fa-solid fa-user"></i>&nbsp;LOGIN
              </NavLink>
            </NavItem>

          </Nav>

          
        </Collapse>
      </Navbar>
    </div>
  );
};

export default Header;
