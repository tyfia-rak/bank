import './style.css';
import { useState } from 'react';

function Account() {
  const [formData, setFormData] = useState({
    name: "",
    secondName: "",
    birthDate: "",
    salary: "",
    bank: ""
  })

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => {
      return { ...prev, [e.target.name]: e.target.value }
    });
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    setFormData({
      name: "",
      secondName: "",
      birthDate: "",
      salary: "",
      bank: ""
    })
  }
  return (
    <div className="account">
      <div className="accountContainer">
        <section>

        </section>
        <section className="articleContainer">
          <h1>Créer un compte</h1>
          <form onSubmit={(e) => handleSubmit(e)} className="infoContainer">
            <label for="">Nom :</label>
            <input required name="name" type="text" value={formData.name} onChange={handleChange}  />
            <label for="">Prénom:</label>
            <input required name="secondName" type="text" value={formData.secondName} onChange={handleChange}  />
            <label for="">Date de naissance:</label>
            <input required name="birthDate" type="date" value={formData.birthDate} onChange={handleChange}  />
            <label for="">Salaire mensuel en Ariary . Ex:10000</label>
            <input required name="salary" type="number" value={formData.salary} onChange={handleChange} />
            <label for="bank-select">Choisissez une banque:</label>
            <select name="bank" value={formData.bank} onChange={handleChange}>
              <option value="bank-select"></option>
              <option value="BMOI">BMOI</option>
              <option value="BNI">BNI</option>
              <option value="BOA">BOA</option>
            </select>
            <button type="submit">Créer le Compte</button>
          </form >
        </section>
      </div>
    </div>
  );
}

export default Account;