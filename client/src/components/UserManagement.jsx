import React, { useState, useEffect } from "react";
import UserTable from "./UserTable";
import { addUser, deleteUser, getAllUsers } from "./api/userApi";
import AddUserForm from "./AddUserForm";

export default function UserManagement() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const usersData = await getAllUsers();
      setUsers(usersData);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const handleDeleteUser = async (emailAddress) => {
    try {
      await deleteUser(emailAddress);
      const updatedUsers = users.filter(
        (user) => user.emailAddress !== emailAddress,
      );
      setUsers(updatedUsers);
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  const handleAddUser = async (userData) => {
    try {
      await addUser(userData);
      setUsers((prevUsers) => [...prevUsers, userData]);
    } catch (error) {
      console.error("Error adding user:", error);
    }
  };

  return (
    <>
      <UserTable users={users} onDeleteUser={handleDeleteUser} />
      <AddUserForm onAddUser={handleAddUser}></AddUserForm>
    </>
  );
}
