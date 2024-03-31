import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

function AllRetreat() {
    const [HistoryRetreat, setHistoryRetreat] = useState([]);

    useEffect(() => {
        fetchRetreats();
    }, []);

    const fetchRetreats = async () => {
        try {
            const response = await axios.get('http://localhost:8080/history_retreat');
            setHistoryRetreat(response.data);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <>
        <h2>History Retreat</h2>
            <Table striped bordered hover variant="white" style={{ width: '50%', marginTop: '10vh' }}>
                <thead>
                    <tr>
                        <th>ID Retreat</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Amount</th>
                        <th>Transaction Date</th>
                    </tr>
                </thead>
                <tbody>
                    {HistoryRetreat.map(history => (
                        <tr key={history.id}>
                            <td>{history.id}</td>
                            <td>{history.firstName}</td>
                            <td>{history.lastName}</td>
                            <td>{history.amount}</td>
                            <td>{history.transaction_date}</td>

                        </tr>
                    ))}
                </tbody>
            </Table>
        </>
    );
}

export default AllRetreat;
