import React, { useState, useEffect } from 'react';
import './CommodityForm.css'; // Importing the CSS file for styling

function CommodityForm({ addCommodity, updateCommodity, selectedCommodity, setSelectedCommodity }) {
  const [formState, setFormState] = useState({
    id: '',
    name: '',
    description: '',
    quantity: '',
    price: '',
  });

  useEffect(() => {
    if (selectedCommodity) {
      setFormState(selectedCommodity);
    } else {
      setFormState({
        id: '',
        name: '',
        description: '',
        quantity: '',
        price: '',
      });
    }
  }, [selectedCommodity]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormState({
      ...formState,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (formState.id) {
      updateCommodity(formState);
    } else {
      addCommodity(formState);
    }
    setFormState({
      id: '',
      name: '',
      description: '',
      quantity: '',
      price: '',
    });
    setSelectedCommodity(null);
  };

  return (
    <form className="commodity-form" onSubmit={handleSubmit}>
      <h2>{formState.id ? 'Edit Commodity' : 'Add Commodity'}</h2>
      <input
        type="text"
        name="name"
        value={formState.name}
        onChange={handleChange}
        placeholder="Name"
        required
      />
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
        name="quantity"
        value={formState.quantity}
        onChange={handleChange}
        placeholder="Quantity"
        required
      />
      <input
        type="number"
        name="price"
        value={formState.price}
        onChange={handleChange}
        placeholder="Price"
        required
      />
      <button type="submit" className="submit-button">{formState.id ? 'Update' : 'Add'}</button>
    </form>
  );
}

export default CommodityForm;

