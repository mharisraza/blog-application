import Base from "../subComponents/Base";
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
    Toast,
  } from "reactstrap";
import { toast, ToastContainer } from "react-toastify";
import { useState } from "react";
import { NavLink as ReactLink } from "react-router-dom";
import { doLogin } from "../services/user-service";
import { INVALID_PASSWORD } from "../services/helper";
import { doLoginAfterGettingToken } from "../auth/login";
const validator=(data) => {
    const errors = {};
    const fieldsToValidate = ['email', 'password'];

    fieldsToValidate.forEach((field)=> {
        if(data[field] === "") {
            errors[field] = "This field is required.";
        }
    })
    return errors;
}



const Login = () => {

    const [data, setData] = useState({
        email: '',
        password: '',
    })

    const [error, setError] = useState({
        errors: {},
        isError: false,
    })

    // handling change
  const handleChange = (event, field) => {
    setData({ ...data, [field]: event.target.value });
};

    const submitForm = (event) => {
        event.preventDefault();

        const errors = validator(data);
        if(Object.keys(errors).length > 0) {
            setError(prevError => ({
                ...prevError,
                errors,
                isError: true
            }));
           return;
        }
        doLogin(data).then((response)=> {
            console.log(response);
            if(response.token === INVALID_PASSWORD) {
                toast.error("Invalid Password or Email address.");
                return;
            }

            // save the token to localStorage.
            doLoginAfterGettingToken(response, ()=> {
                     toast.success("Login successfully!");
            })

        }).catch((error)=> {
                console.log(error);
        });
    }

  



    return (

        <Base>
          <ToastContainer />
          <Container className="mt-50">
            <Row>
              <Col sm={{ size: 6, offset: 3 }}>
                <Card className="shadow">
                  <CardHeader
                    className="register-header bg-primary text-center text-white font-weight-bold"
                  >
                    <i class="fa fa-user-plus"></i>&nbsp;LOGIN
                  </CardHeader>
                  <CardBody>
                    <Form onSubmit={submitForm}>
                      {/* Email Field */}
    
                      <FormGroup>
                      <Label for="email">Email Address</Label>
                        <Input
                          id="email"
                          name="email"
                          placeholder="Email Address"
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
                            Password is required.
                        </FormFeedback>
                      </FormGroup>
        
                      <Container className="text-center">
                        <Button
                          type="submit"
                          color="success"
                          className="w-100"
                        >
                          Login <i class="fa-solid fa-right-to-bracket"></i>
                        </Button>
                      </Container>
                    </Form>
                  </CardBody>
                </Card>
    
                <p className="text-center mt-3">
                  Don't have an account?&nbsp;&nbsp;
                  <Button tag={ReactLink} to="/register" color="danger">Register Now</Button>
                </p>
              </Col>
            </Row>
          </Container>
        </Base>
      );

}


export default Login;