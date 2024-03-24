
import { useState } from 'react';

function Account() {
  const [formData, setFormData] = useState({
    firstname: "",
    lastname: "",
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
          <h1>Create Account</h1>
          <form onSubmit={(e) => handleSubmit(e)} className="infoContainer">
            <label for="">First name :</label>
            <input required name="firstname" type="text" value={formData.firstname} onChange={handleChange}  />
            <label for="">Last name:</label>
            <input required name="lastname" type="text" value={formData.secondName} onChange={handleChange}  />
            <label for="">Birthday:</label>
            <input required name="birthday" type="date" value={formData.birthDate} onChange={handleChange}  />
            <label for="">Bank balance</label>
            <input required name="bankbalance" type="number" value={formData.salary} onChange={handleChange} />
            <label for="">Salary amount</label>
            <input required name="salaryamount" type="number" value={formData.salary} onChange={handleChange} />
            <label for="bank-select">Choose bank</label>
            <select name="bank" value={formData.bank} onChange={handleChange}>
              <option value="bank-select"></option>
              <option value="BMOI">BMOI</option>
              <option value="BNI">BNI</option>
              <option value="BOA">BOA</option>
            </select>
            <label for="">Choose Overdraw</label>
            <select name="overdraw" value={formData.bank} onChange={handleChange}>
              <option value="bank-select"></option>
              <option value="BMOI">Yes</option>
              <option value="BNI">No</option>
            </select>
            <button type="submit">Create Account</button>
          </form >
        </section>
      </div>
    </div>
  );
}

export default Account;