import '../Styles/style.css';
import { useState } from 'react';
import axios from 'axios';
function Account() {
  const [formData, setFormData] = useState({
    firstname: "",
    lastname: "",
    birthDate: "",
    bankbalance: "",
    salaryamount: "",
    bank: "",
    overdraw: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => {
      return { ...prev, [e.target.name]: e.target.value }
    });
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/insert', formData); // Remplacez l'URL par votre endpoint backend
      console.log('Compte créé avec succès:', response.data);
      // Réinitialiser le formulaire après la création réussie du compte
      setFormData({
        firstname: "",
        lastname: "",
        birthDate: "",
        bankbalance: "",
        salaryamount: "",
        bank: "",
        overdraw: ""
      });
    } catch (error) {
      console.error('Erreur lors de la création du compte:', error);
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
            <label htmlFor="">First name :</label>
            <input required name="firstname" type="text" value={formData.firstname} onChange={handleChange}  />
            <label htmlFor="">Last name:</label>
            <input required name="lastname" type="text" value={formData.lastname} onChange={handleChange}  />
            <label htmlFor="">Birthday:</label>
            <input required name="birthDate" type="date" value={formData.birthDate} onChange={handleChange}  />
            <label htmlFor="">Bank balance</label>
            <input required name="bankbalance" type="number" value={formData.bankbalance} onChange={handleChange} />
            <label htmlFor="">Salary amount</label>
            <input required name="salaryamount" type="number" value={formData.salaryamount} onChange={handleChange} />
            <label htmlFor="bank-select">Choose bank</label>
            <select name="bank" value={formData.bank} onChange={handleChange}>
              <option value=""></option>
              <option value="BMOI">BMOI</option>
              <option value="BNI">BNI</option>
              <option value="BOA">BOA</option>
            </select>
            <label htmlFor="">Choose Overdraw</label>
            <select name="overdraw" value={formData.overdraw} onChange={handleChange}>
              <option value=""></option>
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
            <button type="submit">Create Account</button>
          </form >
        </section>
      </div>
    </div>
  );
}

export default Account;