// BuyerCommodityList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './CommodityList.css'; // Importing the CSS file

const BuyerCommodityList = () => {
  const [commodities, setCommodities] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchCommodities();
  }, []);

  const fetchCommodities = async () => {
    try {
      const response = await axios.get('/api/commodities');
      setCommodities(response.data);
    } catch (error) {
      console.error('Error fetching commodities', error);
    }
  };

  const handleOrder = (commodityId) => {
    navigate('/orders', { state: { commodityId } });
  };

  return (
    <div>
      <h1>Commodities</h1>
      <ul>
        {commodities.map((commodity) => (
          <li key={commodity.id}>
            <span>{commodity.name} - {commodity.price}</span>
            <button onClick={() => handleOrder(commodity.id)}>Order</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BuyerCommodityList;
