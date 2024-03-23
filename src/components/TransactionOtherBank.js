import React, { useState } from 'react';
import axios from 'axios';

function IncomingTransferForm() {
  const [formData, setFormData] = useState({
    id_account: '',
    amount: '',
    bank_name: '',
    transfer_reason: '',
    effective_date: '',
    registration_date: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/other_bank', formData);
      console.log(response.data); // Assuming the backend returns a message
      // Reset form after successful submission
      setFormData({
        id_account: '',
        amount: '',
        bank_name: '',
        transfer_reason: '',
        effective_date: '',
        registration_date: ''
      });
    } catch (error) {
      console.error('Error submitting data: ', error);
    }
  };

  return (
    <div>
      <h2>Enter Incoming Transfer Information</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Account ID:
          <input
            type="number"
            name="id_account"
            value={formData.id_account}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Amount:
          <input
            type="number"
            name="amount"
            value={formData.amount}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Bank Name:
          <input
            type="text"
            name="bank_name"
            value={formData.bank_name}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Transfer Reason:
          <input
            type="text"
            name="transfer_reason"
            value={formData.transfer_reason}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Effective Date:
          <input
            type="date"
            name="effective_date"
            value={formData.effective_date}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Registration Date:
          <input
            type="date"
            name="registration_date"
            value={formData.registration_date}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default IncomingTransferForm;
