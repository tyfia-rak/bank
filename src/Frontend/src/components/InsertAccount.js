import React, { useState } from 'react';
import axios from 'axios';

function AccountForm() {
    const [account, setAccount] = useState({
        firstName: '',
        lastName: '',
        birthday: '',
        bankBalance: '',
        bankName: '',
        salaryAmount: '',
        overdraw: false
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setAccount(prevState => ({
            ...prevState,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/insert_account', account);
            console.log('Account saved successfully:', response.data);
            alert('Account inserted successfully');
        } catch (error) {
            console.error('Error saving account:', error);
            alert('Error occurred while saving account');
        }
    };

    return (
        <div className="container">
            <h2>Account Form</h2>
            <form onSubmit={handleSubmit}>
    
                <div className="mb-3">
                    <label htmlFor="firstName" className="form-label">First Name:</label>
                    <input type="text" className="form-control" id="firstName" name="firstName" value={account.firstName} onChange={handleChange} />
                </div>
    
                <div className="mb-3">
                    <label htmlFor="lastName" className="form-label">Last Name:</label>
                    <input type="text" className="form-control" id="lastName" name="lastName" value={account.lastName} onChange={handleChange} />
                </div>
    
                <div className="mb-3">
                    <label htmlFor="birthday" className="form-label">Birthday:</label>
                    <input type="date" className="form-control" id="birthday" name="birthday" value={account.birthday} onChange={handleChange} />
                </div>
    
                <div className="mb-3">
                    <label htmlFor="bankBalance" className="form-label">Bank Balance:</label>
                    <input type="text" className="form-control" id="bankBalance" name="bankBalance" value={account.bankBalance} onChange={handleChange} />
                </div>
    
                <div className="mb-3">
                    <label htmlFor="bankName" className="form-label">Bank Name:</label>
                    <input type="text" className="form-control" id="bankName" name="bankName" value={account.bankName} onChange={handleChange} />
                </div>
    
                <div className="mb-3">
                    <label htmlFor="salaryAmount" className="form-label">Salary Amount:</label>
                    <input type="text" className="form-control" id="salaryAmount" name="salaryAmount" value={account.salaryAmount} onChange={handleChange} />
                </div>
    
                <div className="mb-3 form-check">
                    <input type="checkbox" className="form-check-input" id="overdraw" name="overdraw" checked={account.overdraw} onChange={handleChange} />
                    <label className="form-check-label" htmlFor="overdraw">Overdraw</label>
                </div>
    
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    );
}

export default AccountForm;
