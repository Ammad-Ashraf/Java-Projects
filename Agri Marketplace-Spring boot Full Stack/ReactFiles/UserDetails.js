import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './UserDetails.css';

const UserDetails = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchUserDetails = async () => {
      try {
        const response = await axios.get(`/api/users/${id}`);
        setUser(response.data);
      } catch (error) {
        console.error('Error fetching user details', error);
      }
    };

    fetchUserDetails();
  }, [id]);

  const handleEdit = () => {
    navigate(`/edit-user/${id}`);
  };

  if (!user) {
    return <div className="loading">Loading...</div>;
  }

  return (
    <div className="user-details">
      <h1>User Details</h1>
      <div className="user-info">
        <p><strong>User Type:</strong> {user.userType}</p>
        <p><strong>First Name:</strong> {user.firstName}</p>
        <p><strong>Last Name:</strong> {user.lastName}</p>
        <p><strong>Preferred Products:</strong> {user.preferredProducts}</p>
        <p><strong>Email:</strong> {user.email}</p>
        <p><strong>Company:</strong> {user.company}</p>
        <p><strong>Mobile Number:</strong> {user.mobileNumber}</p>
        <p><strong>Fiscal Address:</strong> {user.fiscalAddress}</p>
        <p><strong>Zip Code:</strong> {user.zipCode}</p>
        <p><strong>Country:</strong> {user.country}</p>
        <p><strong>Company Activity:</strong> {user.companyActivity}</p>
      </div>
      <button className="edit-button" onClick={handleEdit}>Edit User</button>
    </div>
  );
};

export default UserDetails;
