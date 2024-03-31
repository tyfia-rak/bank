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
      console.log(response.data); 
      alert('Transfer by another Bank')
      
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
      alert('Error during transfer')

    }
  };

  return (
    <div className="container">
        <h2>Enter Incoming Transfer Other Bank</h2>
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="id_account" className="form-label">Account ID:</label>
                <input type="number" className="form-control" id="id_account" name="id_account" value={formData.id_account} onChange={handleChange} />
            </div>

            <div className="mb-3">
                <label htmlFor="amount" className="form-label">Amount:</label>
                <input type="number" className="form-control" id="amount" name="amount" value={formData.amount} onChange={handleChange} />
            </div>

            <div className="mb-3">
                <label htmlFor="bank_name" className="form-label">Bank Name:</label>
                <input type="text" className="form-control" id="bank_name" name="bank_name" value={formData.bank_name} onChange={handleChange} />
            </div>

            <div className="mb-3">
                <label htmlFor="transfer_reason" className="form-label">Transfer Reason:</label>
                <input type="text" className="form-control" id="transfer_reason" name="transfer_reason" value={formData.transfer_reason} onChange={handleChange} />
            </div>

            <div className="mb-3">
                <label htmlFor="effective_date" className="form-label">Effective Date:</label>
                <input type="date" className="form-control" id="effective_date" name="effective_date" value={formData.effective_date} onChange={handleChange} />
            </div>

            <div className="mb-3">
                <label htmlFor="registration_date" className="form-label">Registration Date:</label>
                <input type="date" className="form-control" id="registration_date" name="registration_date" value={formData.registration_date} onChange={handleChange} />
            </div>

            <button type="submit" className="btn btn-primary">Submit</button>
        </form>
    </div>
);
  
}
export default IncomingTransferForm;
