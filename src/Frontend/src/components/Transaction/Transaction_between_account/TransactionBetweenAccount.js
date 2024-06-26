import React, { useState } from 'react';
import axios from 'axios';

function TransferForm() {
  const [formData, setFormData] = useState({
    credit_account: '',
    debit_account: '',
    amount: '',
    transfer_reason: '',
    effective_date: '',
    registration_date: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
   try{
    axios.post('http://localhost:8080/Transfer_account', formData, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      console.log(response.data);
      setFormData({
        credit_account: '',
        debit_account: '',
        amount: '',
        transfer_reason: '',
        effective_date: '',
        registration_date: ''
      });
      console.log(response.data); 
      alert('Transfer by another Bank')
    })
   }catch (error){
      console.error('Error submitting data:', error);
      alert('Error during Tranfer between Account')
   }
      
  };

  return (
    <div className="container" style={{ marginTop:'5vh',padding:'20px' }}>
      <h2>Transfer Between account</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Credit Account:</label>
          <input
            className="form-control"
            type="number"
            name="credit_account"
            value={formData.credit_account}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Debit Account:</label>
          <input
            className="form-control"
            type="number"
            name="debit_account"
            value={formData.debit_account}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Amount:</label>
          <input
            className="form-control"
            type="number"
            name="amount"
            value={formData.amount}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Transfer Reason:</label>
          <input
            className="form-control"
            type="text"
            name="transfer_reason"
            value={formData.transfer_reason}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Effective Date:</label>
          <input
            className="form-control"
            type="date"
            name="effective_date"
            value={formData.effective_date}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Registration Date:</label>
          <input
            className="form-control"
            type="date"
            name="registration_date"
            value={formData.registration_date}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Send</button>
      </form>
    </div>
  );
}

export default TransferForm;
