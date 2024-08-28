import React, { useState, useEffect } from 'react';
import axios from 'axios';
import OfferList from './OfferList';
import OfferForm from './OfferForm';

function OfferPage() {
  const [offers, setOffers] = useState([]);
  const [selectedOffer, setSelectedOffer] = useState(null);
  const [commodities, setCommodities] = useState([]);

  useEffect(() => {
    fetchOffers();
    fetchCommodities();
  }, []);

  const fetchOffers = async () => {
    const response = await axios.get('/api/offers');
    setOffers(response.data);
  };

  const fetchCommodities = async () => {
    const response = await axios.get('/api/commodities');
    setCommodities(response.data);
  };

  const addOffer = async (offer) => {
    const response = await axios.post('/api/offers', offer);
    setOffers([...offers, response.data]);
  };

  const updateOffer = async (offer) => {
    const response = await axios.put(`/api/offers/${offer.id}`, offer);
    const updatedOffers = offers.map((item) => (item.id === offer.id ? response.data : item));
    setOffers(updatedOffers);
  };

  const deleteOffer = async (id) => {
    await axios.delete(`/api/offers/${id}`);
    setOffers(offers.filter((offer) => offer.id !== id));
  };

  const selectOffer = (offer) => {
    setSelectedOffer(offer);
  };

  return (
    <div>
      <h2>Offers</h2>
      <OfferForm
        addOffer={addOffer}
        updateOffer={updateOffer}
        selectedOffer={selectedOffer}
        setSelectedOffer={setSelectedOffer}
        commodities={commodities}
      />
      <OfferList offers={offers} deleteOffer={deleteOffer} selectOffer={selectOffer} />
    </div>
  );
}

export default OfferPage;
