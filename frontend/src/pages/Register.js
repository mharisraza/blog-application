import Base from "../components/Base";
import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormFeedback,
  FormGroup,
  Input,
  Label,
  Row,
} from "reactstrap";
import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import { doRegister } from "../services/user-service";
import { USER_ALREADY_EXIST_REGISTER_ERROR } from "../services/helper";
import { Navigate, NavLink as ReactLink, useNavigate } from "react-router-dom";


// validator.
const validate = (data) => {
  const errors = {};
  const fieldsToValidate = ["name", "email", "password", "confirmPassword"];
  fieldsToValidate.forEach((field) => {
      if (data[field] === "") {
          errors[field] = "This field is required";
      }
      if (field === 'confirmPassword' && data.password !== data.confirmPassword) {
        errors[field] = 'Password and Confirm Password do not match';
    }

      if (field === 'password' && data[field]!== '' && !(data.password.length >= 8 && /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).*$/.test(data.password))) {
        errors[field] = 'Password should be at least 8 characters long and contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character';
    }

  });
  return errors;
}

const Register = () => {

  const navigate = useNavigate();

  const [data, setData] = useState({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const [error, setError] = useState({
    errors: {},
    isError: false,
  });

  // handling change
  const handleChange = (event, field) => {
    setData({ ...data, [field]: event.target.value });
};

  // submiting the form......
  const submitForm = (event) => {
    event.preventDefault();

    const errors = validate(data);
    if (Object.keys(errors).length > 0) {
        setError(prevError => ({
            ...prevError,
            errors,
            isError: true
        }));
        return;
    }

    // calling server apis.
    doRegister(data)
      .then((response) => {
        toast.success("Register successfully, you can login now!");
        setData({
          name: '',
          email: '',
          password: '',
          confirmPassword: ''
        });
        setError({errors:{},
        isError: false});
        setTimeout(() => {
          navigate("/login");
        }, 3000);
         return;
      })
      .catch((error) => {
        if (error?.response?.data?.message == USER_ALREADY_EXIST_REGISTER_ERROR) {
          toast.error("Sorry, an user already exist with provided email.");
        }
        setError(prevError => ({
          ...prevError,
          errors: errors,
          isError: true
      }));
       toast.error("Sorry an Unexpected error occured, try again in a while.");
      });
  };

  return (
    <Base>
      <ToastContainer />

      <Container className="mt-5">
        <Row>
          <Col sm={{ size: 6, offset: 3 }}>
            <Card className="shadow">
              <CardHeader
                className="register-header bg-primary text-center text-white   font-weight-bold"
              >
                <i class="fa fa-user-plus"></i>&nbsp;REGISTER
              </CardHeader>
              <CardBody>
                <Form onSubmit={submitForm}>
                  {/* Full Name Field */}
                  <FormGroup>
                  <Label for="fullName">&nbsp;Full Name</Label>
                    <Input
                      id="fullName"
                      name="name"
                      placeholder="John Doe"
                      type="text"
                      onChange={(e) => handleChange(e, "name")}
                      value={data.name}
                      invalid = { error?.errors?.name }
                    />
           
                    <FormFeedback>
                      Full Name is required.
                    </FormFeedback>


                  </FormGroup>

                  {/* Email Field */}

                  <FormGroup>
                  <Label for="email">Email Address</Label>
                    <Input
                      id="email"
                      name="email"
                      placeholder="johndoe@example.com"
                      type="email"
                      onChange={(e) => handleChange(e, "email")}
                      value={data.email}
                      invalid = { error?.errors?.email }
                    />

                    <FormFeedback>
                      Email Address is required.
                    </FormFeedback>
                  </FormGroup>

                  {/* Password Field */}

                  <FormGroup>
                  <Label for="password">Password</Label>
                    <Input
                      id="password"
                      name="password"
                      placeholder="Password"
                      type="password"
                      onChange={(e) => handleChange(e, "password")}
                      value={data.password}
                      invalid = { error?.errors?.password }
                    />
                   

                    <FormFeedback>
                    {error?.errors?.password}
                    </FormFeedback>
                  </FormGroup>

                  {/* Confirm Password Field */}

                  <FormGroup>
                  <Label for="confirm_password">Confirm Password</Label>
                    <Input
                      id="confirm_password"
                      name="confirmPassword"
                      placeholder="Confirm Password"
                      type="password"
                      onChange={(e) => handleChange(e, "confirmPassword")}
                      value={data.confirmPassword}
                      invalid = {error?.errors?.confirmPassword}
                    />

                    <FormFeedback>
                    {error?.errors?.confirmPassword}
                    </FormFeedback>

                  </FormGroup>

                  <Container className="text-center">
                    <Button color="success"
                      type="submit"
                      className="w-100"
                    >
                      Register <i class="fa-solid fa-right-to-bracket"></i>
                    </Button>
                  </Container>
                </Form>
              </CardBody>
            </Card>

            <p className="text-center mt-3">
              Already have an account?&nbsp;&nbsp;
              <Button tag={ReactLink} to="/login" color="danger">Login Now</Button>
            </p>
          </Col>
        </Row>
      </Container>
    </Base>
  );
};

export default Register;
