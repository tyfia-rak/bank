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
    })
    .catch(error => console.error('Erreur lors de l\'envoi des données:', error));
  };

  return (
    <div>
      <h2>Transfer Between account</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Compte créditeur:</label>
          <input 
            type="number" 
            name="credit_account" 
            value={formData.credit_account} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Compte débiteur:</label>
          <input 
            type="number" 
            name="debit_account" 
            value={formData.debit_account} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Montant:</label>
          <input 
            type="number" 
            name="amount" 
            value={formData.amount} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Raison du transfert:</label>
          <input 
            type="text" 
            name="transfer_reason" 
            value={formData.transfer_reason} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          {/* <label>Type de transfert:</label>
          <select 
            name="type" 
            value={formData.type} 
            onChange={handleChange} 
            required 
          >
            <option value="">Sélectionner le type</option>
            <option value="credit">credit</option>
            <option value="debit">debit</option>
          </select> */}
        </div>
        <div>
          <label>Date d'effet:</label>
          <input 
            type="date" 
            name="effective_date" 
            value={formData.effective_date} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label>Date d'enregistrement:</label>
          <input 
            type="date" 
            name="registration_date" 
            value={formData.registration_date} 
            onChange={handleChange} 
            required 
          />
        </div>
        <button type="submit">Envoyer</button>
      </form>
    </div>
  );
}

export default TransferForm;
