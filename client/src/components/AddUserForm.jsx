import React, { useState } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import { IconButton } from "@mui/material";

function AddUserForm({ onAddUser }) {
  const [userData, setUserData] = useState({
    firstName: "",
    lastName: "",
    emailAddress: "",
    password: "",
  });
  const [showForm, setShowForm] = useState(false);

  const toggleForm = () => {
    setShowForm((prevShowForm) => !prevShowForm);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onAddUser(userData);
    setShowForm(false);
    setUserData({
      firstName: "",
      lastName: "",
      emailAddress: "",
      password: "",
    });
  };

  return (
    <>
      <Grid container justifyContent="center">
        <Grid item xs={12} md={6}>
          <IconButton onClick={toggleForm}>
            {showForm ? <RemoveIcon /> : <AddIcon />}
          </IconButton>
          {showForm && (
            <form onSubmit={handleSubmit}>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="First Name"
                    name="firstName"
                    value={userData.firstName}
                    onChange={handleChange}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Last Name"
                    name="lastName"
                    value={userData.lastName}
                    onChange={handleChange}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Email Address"
                    name="emailAddress"
                    type="email"
                    value={userData.emailAddress}
                    onChange={handleChange}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Password"
                    name="password"
                    type="password"
                    value={userData.password}
                    onChange={handleChange}
                  />
                </Grid>
                <Grid item xs={12}>
                  <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    fullWidth
                  >
                    Add User
                  </Button>
                </Grid>
              </Grid>
            </form>
          )}
        </Grid>
      </Grid>
    </>
  );
}

export default AddUserForm;
