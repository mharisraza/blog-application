import Base from "../components/Base";
import {
    Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
  Row,
} from "reactstrap";

const Register = () => {
  return (
    <Base>
        <Container  className="mt-50">
       <Row>
        <Col sm={{ size: 6, offset: 3 }}>

        <Card className="shadow">
          <CardHeader style={{backgroundColor: '#3f51b5'}}  className="register-header text-center text-white   fw-bold"><i class="fa fa-user-plus"></i>&nbsp;REGISTER</CardHeader>
          <CardBody>
            <Form>
                {/* Full Name Field */}
              <FormGroup floating>
                <Input
                  id="fullName"
                  name="name"
                  placeholder="Full Name"
                  type="text"
                />
                <Label for="fullName">Full Name</Label>
              </FormGroup>

              {/* Email Field */}

              <FormGroup floating>
                <Input
                  id="email"
                  name="email"
                  placeholder="Email Address"
                  type="email"
                />
                <Label for="email">Email Address</Label>
              </FormGroup>

              {/* Password Field */}

              <FormGroup floating>
                <Input
                  id="password"
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <Label for="password">Password</Label>
              </FormGroup>

              {/* Confirm Password Field */}

              <FormGroup floating>
                <Input
                  id="confirm_password"
                  name="confirm_password"
                  placeholder="Confirm Password"
                  type="password"
                />
                <Label for="confirm_password">Confirm Password</Label>
              </FormGroup>

              <Container className="text-center">
                <Button style={{backgroundColor: '#3f51b5'}} className="w-100" >Register <i class="fa-solid fa-right-to-bracket"></i></Button>
              </Container>

            </Form>
          </CardBody>
        </Card>

        <p className="text-center mt-3">Already have an account? Login now.</p>
        
        </Col>
       </Row>
      </Container>
    </Base>
  );
};

export default Register;
