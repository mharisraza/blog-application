import React, { useState } from "react";
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
        <NavbarBrand className="fw-bold" href="/">
          BLOG-it
        </NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto text-center  navbar-expand-xl" navbar>
            <NavItem>
              <NavLink className="active" href="/home"><li className="fas fa-home"></li>&nbsp;Home</NavLink>
            </NavItem>

            <NavItem>
              <NavLink href="https://github.com/reactstrap/reactstrap">
                <li className="fa-brands fa-blogger-b"></li>&nbsp;Blogs
              </NavLink>
            </NavItem>

           


          </Nav>

          <Nav className="ms-auto text-center" navbar>

          <NavItem>
              <NavLink className="btn btn-block btn-warning text-dark fw-bold">
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
