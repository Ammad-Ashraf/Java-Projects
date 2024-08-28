import React, { useState, useEffect } from 'react';
import './OfferForm.css'; // Importing the CSS file

function OfferForm({ addOffer, updateOffer, selectedOffer, setSelectedOffer, commodities }) {
  const [formState, setFormState] = useState({
    id: '',
    description: '',
    discountedPrice: '',
    commodity: { id: '' }
  });

  useEffect(() => {
    if (selectedOffer) {
      setFormState({
        id: selectedOffer.id,
        description: selectedOffer.description,
        discountedPrice: selectedOffer.discountedPrice,
        commodity: selectedOffer.commodity
      });
    }
  }, [selectedOffer]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === 'commodity') {
      setFormState({ ...formState, commodity: { id: value } });
    } else {
      setFormState({ ...formState, [name]: value });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (formState.id) {
      updateOffer(formState);
    } else {
      addOffer(formState);
    }
    setFormState({ id: '', description: '', discountedPrice: '', commodity: { id: '' } });
    setSelectedOffer(null);
  };

  return (
    <form className="offer-form" onSubmit={handleSubmit}>
      <h2>{formState.id ? 'Edit Commodity' : 'Add Offer'}</h2>
      <select name="commodity" value={formState.commodity.id} onChange={handleChange} required>
        <option value="">Select Commodity</option>
        {commodities.map((commodity) => (
          <option key={commodity.id} value={commodity.id}>
            {commodity.name}
          </option>
        ))}
      </select>
      <input
        type="text"
        name="description"
        value={formState.description}
        onChange={handleChange}
        placeholder="Description"
        required
      />
      <input
        type="number"
        name="discountedPrice"
        value={formState.discountedPrice}
        onChange={handleChange}
        placeholder="Discounted Price"
        required
      />
      <button type="submit">{formState.id ? 'Update' : 'Add'} Offer</button>
    </form>
  );
}

export default OfferForm;
