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

        } catch (error) {
            console.error('Error saving account:', error);

        }
    };

    return (
        <div>
            <h2>Account Form</h2>
            <form onSubmit={handleSubmit}>
                
                <label htmlFor="firstName">First Name:</label><br />
                <input type="text" id="firstName" name="firstName" value={account.firstName} onChange={handleChange} /><br />
                
                <label htmlFor="lastName">Last Name:</label><br />
                <input type="text" id="lastName" name="lastName" value={account.lastName} onChange={handleChange} /><br />
                
                <label htmlFor="birthday">Birthday:</label><br />
                <input type="date" id="birthday" name="birthday" value={account.birthday} onChange={handleChange} /><br />
                
                <label htmlFor="bankBalance">Bank Balance:</label><br />
                <input type="text" id="bankBalance" name="bankBalance" value={account.bankBalance} onChange={handleChange} /><br />
                
                <label htmlFor="bankName">Bank Name:</label><br />
                <input type="text" id="bankName" name="bankName" value={account.bankName} onChange={handleChange} /><br />
                
                <label htmlFor="salaryAmount">Salary Amount:</label><br />
                <input type="text" id="salaryAmount" name="salaryAmount" value={account.salaryAmount} onChange={handleChange} /><br />
                
                <label htmlFor="overdraw">Overdraw:</label><br />
                <input type="checkbox" id="overdraw" name="overdraw" checked={account.overdraw} onChange={handleChange} /><br /><br />
                
                <input type="submit" value="Submit" />
            </form>
        </div>
    );
}

export default AccountForm;
