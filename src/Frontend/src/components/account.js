import '../Styles/style.css'
import React, { useState } from 'react';
import axios from 'axios';

function Account() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    birthDate: "",
    bankBalance: "",
    salaryAmount: "",
    bank: "",
    overdraw: ""
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/insert_account', formData); 
      console.log('Compte créé avec succès:', response.data);
      setFormData({
        firstName: "",
        lastName: "",
        birthDate: "",
        bankBalance: "",
        salaryAmount: "",
        bank: "",
        overdraw: ""
      });
    } catch (error) {
      console.error('Erreur lors de la création du compte:', error);
      setError("Une erreur s'est produite lors de la création du compte. Veuillez réessayer plus tard.");
    }
  };

  return (
    <div className="account">
      <div className="accountContainer">
        <section>

        </section>
        <section className="articleContainer">
          <h1>Create Account</h1>
          <form onSubmit={handleSubmit} className="infoContainer">
            <label htmlFor="firstname">First name :</label>
            <input required name="firstName" type="text" value={formData.firstName} onChange={handleChange} />
            <label htmlFor="lastname">Last name:</label>
            <input required name="lastName" type="text" value={formData.lastName} onChange={handleChange} />
            <label htmlFor="birthDate">Birthday:</label>
            <input required name="birthDate" type="date" value={formData.birthDate} onChange={handleChange} />
            <label htmlFor="bankbalance">Bank balance</label>
            <input required name="bankBalance" type="number" value={formData.bankBalance} onChange={handleChange} />
            <label htmlFor="salaryamount">Salary amount</label>
            <input required name="salaryAmount" type="number" value={formData.salaryAmount} onChange={handleChange} />
            <label htmlFor="bank">Choose bank</label>
            <select name="bank" value={formData.bank} onChange={handleChange}>
              <option value=""></option>
              <option value="BMOI">BMOI</option>
              <option value="BNI">BNI</option>
              <option value="BOA">BOA</option>
            </select>
            <label htmlFor="overdraw">Choose Overdraw</label>
            <select name="overdraw" value={formData.overdraw} onChange={handleChange}>
              <option value=""></option>
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
            {error && <p className="error">{error}</p>}
            <button type="submit">Create Account</button>
          </form>
        </section>
      </div>
    </div>
  );
}

export default Account;
