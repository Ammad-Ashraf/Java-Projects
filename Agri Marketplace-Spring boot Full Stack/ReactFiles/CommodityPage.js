import React, { useState, useEffect } from 'react';
import axios from 'axios';
import CommodityList from './CommodityList';
import CommodityForm from './CommodityForm';
import './CommodityPage.css'; // Importing the CSS file for styling

function CommodityPage() {
  const [commodities, setCommodities] = useState([]);
  const [selectedCommodity, setSelectedCommodity] = useState(null);

  useEffect(() => {
    fetchCommodities();
  }, []);

  const fetchCommodities = async () => {
    try {
      const response = await axios.get('/api/commodities');
      setCommodities(response.data);
    } catch (error) {
      console.error('Error fetching commodities:', error);
    }
  };

  const addCommodity = async (commodity) => {
    try {
      const response = await axios.post('/api/commodities', commodity);
      setCommodities([...commodities, response.data]);
    } catch (error) {
      console.error('Error adding commodity:', error);
    }
  };

  const updateCommodity = async (commodity) => {
    try {
      const response = await axios.put(`/api/commodities/${commodity.id}`, commodity);
      const updatedCommodities = commodities.map((item) => (item.id === commodity.id ? response.data : item));
      setCommodities(updatedCommodities);
    } catch (error) {
      console.error('Error updating commodity:', error);
    }
  };

  const deleteCommodity = async (id) => {
    try {
      await axios.delete(`/api/commodities/${id}`);
      setCommodities(commodities.filter((commodity) => commodity.id !== id));
    } catch (error) {
      console.error('Error deleting commodity:', error);
    }
  };

  const selectCommodity = (commodity) => {
    setSelectedCommodity(commodity);
  };

  return (
    <div className="commodity-page">
      <h2 className="page-title">Commodities</h2>
      <div className="commodity-content">
        <CommodityForm
          addCommodity={addCommodity}
          updateCommodity={updateCommodity}
          selectedCommodity={selectedCommodity}
          setSelectedCommodity={setSelectedCommodity}
        />
        <CommodityList commodities={commodities} deleteCommodity={deleteCommodity} selectCommodity={selectCommodity} />
      </div>
    </div>
  );
}

export default CommodityPage;