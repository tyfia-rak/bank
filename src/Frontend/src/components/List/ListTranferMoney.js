import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

function AllTranferMoney() {
    const [transferMoney, setTransferMoney] = useState([]);

    useEffect(() => {
        fetchTransferMoney();
    }, []);

    const fetchTransferMoney = async () => {
        try {
            const response = await axios.get('http://localhost:8080/all_transferMoney');
            setTransferMoney(response.data);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <>
        <h2>History Transfer Money</h2>   
            <Table striped bordered hover variant="white" style={{ width: '50%', marginTop: '10vh' }}>
                <thead>
                    <tr>
                        <th>Credit Account</th>
                        <th>Debit Account</th>
                        <th>Amount</th>
                        <th>Transfer Reason</th>
                        <th>Effective Date</th>
                        <th>Registration Date</th>
                    </tr>
                </thead>
                <tbody>
                    {transferMoney.map(transferMonies => (
                        <tr key={transferMonies.id}>
                            <td>{transferMonies.credit_account}</td>
                            <td>{transferMonies.debit_account}</td>
                            <td>{transferMonies.amount}</td>
                            <td>{transferMonies.transfer_reason}</td>
                            <td>{transferMonies.effective_date}</td>
                            <td>{transferMonies.registration_date}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </>
    );
}

export default AllTranferMoney;
