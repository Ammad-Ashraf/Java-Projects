import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './UserPage.css';

const UsersPage = () => {
  const [users, setUsers] = useState([]);
  const [newUser, setNewUser] = useState({
    userType: '',
    firstName: '',
    lastName: '',
    preferredProducts: '',
    email: '',
    password: '',
    company: '',
    mobileNumber: '',
    fiscalAddress: '',
    zipCode: '',
    country: '',
    companyActivity: ''
  });

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get('/api/users');
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users', error);
    }
  };

  const handleChange = (e) => {
    setNewUser({ ...newUser, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/api/users', newUser);
      fetchUsers();
      setNewUser({
        userType: '',
        firstName: '',
        lastName: '',
        preferredProducts: '',
        email: '',
        password: '',
        company: '',
        mobileNumber: '',
        fiscalAddress: '',
        zipCode: '',
        country: '',
        companyActivity: ''
      });
    } catch (error) {
      console.error('Error adding user', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`/api/users/${id}`);
      fetchUsers();
    } catch (error) {
      console.error('Error deleting user', error);
    }
  };

  return (
    <div className="users-page">
      <h1>Users</h1>
      <div className="user-list-container">
        <h2>User List</h2>
        <ul className="user-list">
          {users.map(user => (
            <li key={user.id} className="user-list-item">
              <span>{user.firstName} {user.lastName} - {user.email}</span>
              <Link to={`/users/${user.id}`} className="view-details">View Details</Link>
              <button onClick={() => handleDelete(user.id)} className="delete-button">Delete</button>
            </li>
          ))}
        </ul>
      </div>
      <div className="add-user-container">
        <h2>Add User</h2>
        <form className="user-form" onSubmit={handleSubmit}>
          <input
            type="text"
            name="userType"
            placeholder="User Type"
            value={newUser.userType}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="firstName"
            placeholder="First Name"
            value={newUser.firstName}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="lastName"
            placeholder="Last Name"
            value={newUser.lastName}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="preferredProducts"
            placeholder="Preferred Products"
            value={newUser.preferredProducts}
            onChange={handleChange}
          />
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={newUser.email}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={newUser.password}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="company"
            placeholder="Company"
            value={newUser.company}
            onChange={handleChange}
          />
          <input
            type="text"
            name="mobileNumber"
            placeholder="Mobile Number"
            value={newUser.mobileNumber}
            onChange={handleChange}
          />
          <input
            type="text"
            name="fiscalAddress"
            placeholder="Fiscal Address"
            value={newUser.fiscalAddress}
            onChange={handleChange}
          />
          <input
            type="text"
            name="zipCode"
            placeholder="Zip Code"
            value={newUser.zipCode}
            onChange={handleChange}
          />
          <input
            type="text"
            name="country"
            placeholder="Country"
            value={newUser.country}
            onChange={handleChange}
          />
          <input
            type="text"
            name="companyActivity"
            placeholder="Company Activity"
            value={newUser.companyActivity}
            onChange={handleChange}
          />
          <button type="submit">Add User</button>
        </form>
      </div>
    </div>
  );
};

export default UsersPage;
