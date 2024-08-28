import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './EditUser.css';

const EditUser = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  const [editedUser, setEditedUser] = useState({
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
    const fetchUserDetails = async () => {
      try {
        const response = await axios.get(`/api/users/${id}`);
        setUser(response.data);
        setEditedUser(response.data); // Initialize form with current user data
      } catch (error) {
        console.error('Error fetching user details', error);
      }
    };

    fetchUserDetails();
  }, [id]);

  const handleChange = (e) => {
    setEditedUser({ ...editedUser, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`/api/users/${id}`, editedUser); // Update user data
      navigate(`/users/${id}`); // Navigate back to user details after update
    } catch (error) {
      console.error('Error updating user', error);
    }
  };

  if (!user) {
    return <div className="loading">Loading...</div>;
  }

  return (
    <div className="edit-user">
      <h1>Edit User</h1>
      <form className="edit-user-form" onSubmit={handleSubmit}>
        {/* Editable fields */}
        <input
          type="text"
          name="userType"
          placeholder="User Type"
          value={editedUser.userType}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={editedUser.firstName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={editedUser.lastName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="preferredProducts"
          placeholder="Preferred Products"
          value={editedUser.preferredProducts}
          onChange={handleChange}
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={editedUser.email}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={editedUser.password}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="company"
          placeholder="Company"
          value={editedUser.company}
          onChange={handleChange}
        />
        <input
          type="text"
          name="mobileNumber"
          placeholder="Mobile Number"
          value={editedUser.mobileNumber}
          onChange={handleChange}
        />
        <input
          type="text"
          name="fiscalAddress"
          placeholder="Fiscal Address"
          value={editedUser.fiscalAddress}
          onChange={handleChange}
        />
        <input
          type="text"
          name="zipCode"
          placeholder="Zip Code"
          value={editedUser.zipCode}
          onChange={handleChange}
        />
        <input
          type="text"
          name="country"
          placeholder="Country"
          value={editedUser.country}
          onChange={handleChange}
        />
        <input
          type="text"
          name="companyActivity"
          placeholder="Company Activity"
          value={editedUser.companyActivity}
          onChange={handleChange}
        />
        <button type="submit">Update User</button>
      </form>
    </div>
  );
};

export default EditUser;
