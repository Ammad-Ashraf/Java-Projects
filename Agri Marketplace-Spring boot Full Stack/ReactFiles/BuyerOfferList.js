// BuyerOfferList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './OfferList.css'; // Importing the CSS file

const BuyerOfferList = () => {
  const [offers, setOffers] = useState([]);

  useEffect(() => {
    fetchOffers();
  }, []);

  const fetchOffers = async () => {
    try {
      const response = await axios.get('/api/offers');
      setOffers(response.data);
    } catch (error) {
      console.error('Error fetching offers', error);
    }
  };

  return (
    <div className="offer-list">
      <h2>Offers List</h2>
      <ul>
        {offers.map((offer) => (
          <li key={offer.id} className="offer-item">
            <div className="offer-details">
              <span>
                <strong>Description:</strong> {offer.description}, <strong>Discounted Price:</strong> {offer.discountedPrice}, 
                <strong>Commodity ID:</strong> {offer.commodity.id}, <strong>Commodity Name:</strong> {offer.commodity.name}
              </span>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BuyerOfferList;
