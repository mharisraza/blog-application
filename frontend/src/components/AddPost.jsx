import React from "react";
import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Container,
  Form,
  FormFeedback,
  FormGroup,
  Input,
  Label,
} from "reactstrap";
import Base from "./Base";

const AddPost = () => {
  const submitForm = (event) => {
    event.preventDefault();
  };

  return (
    <Base>
      <div className="container-fluid mt-5">
        <Form onSubmit={submitForm}>
          <div className="row">
            <div className="col-sm-6">
              <Card style={{ with: "50rem" }} className="shadow">
                <CardHeader className="register-header text-center font-weight-bold bg-primary text-white">
                  Write something new.
                </CardHeader>
                <CardBody>
                  {/* Blog Title Field */}

                  <FormGroup>
                    <Input
                      id="title"
                      name="title"
                      className="form-control-alternative"
                      placeholder="Blog Title"
                      type="text"
                    />

                    <FormFeedback>Blog title is required.</FormFeedback>
                  </FormGroup>

                  {/* Blog Description Field */}

                  <FormGroup>
                    <Input
                    style={{ height: "339px" }}
                      id="content"
                      className="form-control-alternative"
                      name="content"
                      placeholder="Blog Description"
                      type="textarea"
                    />

                    <FormFeedback>Blog Description is required.</FormFeedback>
                  </FormGroup>
                </CardBody>
              </Card>
            </div>
            <div className="col-sm-6 blog_image_and_category">
              <Card className="shadow">
                <CardHeader className="bg-primary register-header text-center font-weight-bold text-white ">
                  Blog Image and Category
                </CardHeader>
                <CardBody>
                  <div class="form-group">
                    <select
                      class="form-control form-control-alternative"
                      id="blogCategory"
                    >
                      <option selected>Select Blog Category</option>

                      <option>Programming</option>
                    </select>

                    <FormFeedback>Blog Category is required.</FormFeedback>
                  </div>

                  <FormGroup>
                    <Input
                      id="password"
                      className="form-control-alternative file-input"
                      name="password"
                      placeholder="Blog Description"
                      type="file"
                    />

                    <FormFeedback>Blog Image is required.</FormFeedback>

                    <div className="text-center" id="serveBlogImage"></div>
                  </FormGroup>

                  <div className="container text-center">
                  <Button className="w-75" color="success">Add Blog <i className="fas fa-plus"></i></Button>
                  </div>

                </CardBody>
              </Card>
            </div>
          </div>
        </Form>
      </div>
    </Base>
  );
};

export default AddPost;
