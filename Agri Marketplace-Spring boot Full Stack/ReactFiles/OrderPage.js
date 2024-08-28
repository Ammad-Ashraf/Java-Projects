import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './OrderPage.css';

const OrdersPage = () => {
  const [orders, setOrders] = useState([]);
  const [commodities, setCommodities] = useState([]);
  const [formState, setFormState] = useState({
    commodity: { id: '' },
    user: { id: 'tayyab' }, // Set the user ID here
    orderDate: '',
    status: 'PENDING'
  });

  useEffect(() => {
    fetchOrders();
    fetchCommodities();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await axios.get('/api/orders');
      setOrders(response.data);
    } catch (error) {
      console.error('Error fetching orders', error);
    }
  };

  const fetchCommodities = async () => {
    try {
      const response = await axios.get('/api/commodities');
      console.log('Commodities fetched:', response.data); // Debugging line
      setCommodities(response.data);
    } catch (error) {
      console.error('Error fetching commodities', error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === 'commodity') {
      setFormState({ ...formState, commodity: { id: value } });
    } else {
      setFormState({ ...formState, [name]: value });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/api/orders', {
        ...formState,
        commodityId: formState.commodity.id,
      });
      fetchOrders();
      setFormState({ commodity: { id: '' }, orderDate: '', status: 'PENDING' });
    } catch (error) {
      console.error('Error adding order', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`/api/orders/${id}`);
      fetchOrders();
    } catch (error) {
      console.error('Error deleting order', error);
    }
  };

  return (
    <div className="orders-page">
      <h1>Orders</h1>
      <form onSubmit={handleSubmit} className="order-form">
        <select name="commodity" value={formState.commodity.id} onChange={handleChange} required>
          <option value="">Select Commodity</option>
          {commodities.map((commodity) => (
            <option key={commodity.id} value={commodity.id}>
              {commodity.name}
            </option>
          ))}
        </select>
        <input
          type="date"
          name="orderDate"
          value={formState.orderDate}
          onChange={handleChange}
          required
        />
        <select name="status" value={formState.status} onChange={handleChange}>
          <option value="PENDING">Pending</option>
          <option value="CONFIRMED">Confirmed</option>
          <option value="DELIVERED">Delivered</option>
        </select>
        <button type="submit">Place Order</button>
      </form>
      <ul className="order-list">
        {orders.map((order) => (
          <li key={order.orderId} className="order-item">
            <span>Commodity ID: {order.commodityId}, User ID: {order.userId}, Order Date: {order.orderDate}, Status: {order.status}</span>
            <button className="delete-button" onClick={() => handleDelete(order.orderId)}>Cancel</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default OrdersPage;
