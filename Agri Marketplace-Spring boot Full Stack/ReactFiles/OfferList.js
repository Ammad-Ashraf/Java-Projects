import React from 'react';
import './OfferList.css'; // Importing the CSS file

function OfferList({ offers, deleteOffer, selectOffer }) {
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
            <div className="offer-actions">
              <button className="edit-button" onClick={() => selectOffer(offer)}>Edit</button>
              <button className="delete-button" onClick={() => deleteOffer(offer.id)}>Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default OfferList;
