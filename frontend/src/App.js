import { BrowserRouter , Routes , Route } from "react-router-dom";
import AddPost from "./components/AddPost";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import MainUserRoute from "./privatePages/normalUser/User";
import UserDashboard from "./privatePages/normalUser/UserDashboard";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register />} />
        <Route path="home" element={<Home />} />
        <Route path="" element={<Home />} />

        {/* normal user route */}
        
          <Route path="/user" element={<MainUserRoute />}>
          <Route path="dashboard" element={<UserDashboard />} />
          <Route path="add-blog" element={<AddPost />} />
          </Route>


        {/* admin user route */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
