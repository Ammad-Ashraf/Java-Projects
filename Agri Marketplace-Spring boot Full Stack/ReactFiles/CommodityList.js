import React from 'react';
import './CommodityList.css'; // Importing the CSS file for styling

function CommodityList({ commodities, deleteCommodity, selectCommodity }) {
  return (
    <div className="commodity-list-container">
      <h2>Commodity List</h2>
      <ul className="commodity-list">
        {commodities.map((commodity) => (
          <li key={commodity.id} className="commodity-item">
            <div className="commodity-details">
              <span><strong>Name:</strong> {commodity.name}</span>
              <span><strong>Description:</strong> {commodity.description}</span>
              <span><strong>Quantity:</strong> {commodity.quantity}</span>
              <span><strong>Price:</strong> ${commodity.price}</span>
            </div>
            <div className="commodity-actions">
              <button className="edit-button" onClick={() => selectCommodity(commodity)}>Edit</button>
              <button className="delete-button" onClick={() => deleteCommodity(commodity.id)}>Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CommodityList;