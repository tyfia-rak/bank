import React, { useState } from 'react';
import axios from 'axios';

function WithdrawForm() {
  const [withdrawData, setWithdrawData] = useState({
    amount: '',
    transaction_date: '',
    id_account: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setWithdrawData({ ...withdrawData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/Retreat_account', withdrawData);
      if (response.data === 'retreat effectued') {
        alert('Retreat effectued');

        setWithdrawData({
          amount: '',
          transaction_date: '',
          id_account: ''
        });
      } else {
        alert( response.data);
      }
    } catch (error) {
      console.error( error);
      alert(error.message);
    }
  };

  return (
    <div className="container" style={{ padding:'20px' }}>
      <h2>Retreat Money</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="amount">Amount:</label>
          <input
            className="form-control"
            type="number"
            id="amount"
            name="amount"
            value={withdrawData.amount}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="transaction_date">Transaction Date:</label>
          <input
            className="form-control"
            type="date"
            id="transaction_date"
            name="transaction_date"
            value={withdrawData.transaction_date}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="id_account">Account ID:</label>
          <input
            className="form-control"
            type="text"
            id="id_account"
            name="id_account"
            value={withdrawData.id_account}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Withdraw</button>
      </form>
    </div>
  );
}

export default WithdrawForm;



