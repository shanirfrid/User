import React from "react";
import UserList from "./UserList";

export default function UserTable({ users, onDeleteUser }) {
  return (
    <>
      <h1>Users Table</h1>
      <UserList users={users} onDeleteUser={onDeleteUser} />
    </>
  );
}
