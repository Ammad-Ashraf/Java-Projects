import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const BuyerPage = () => {
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

  const handleOrderClick = (commodityId) => {
    navigate(`/orders/create?commodityId=${commodityId}`);
  };

  return (
    <div>
      <h1>Buyer Page</h1>
      <h2>Commodities</h2>
      <ul>
        {commodities.map(commodity => (
          <li key={commodity.id}>
            {commodity.name} - {commodity.description}
            <button onClick={() => handleOrderClick(commodity.id)}>Order</button>
            <a href="/inspection-reports">Generate Inspection Report</a>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BuyerPage;
