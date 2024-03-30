import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

function AllRetreat() {
    const [retreat, setRetreat] = useState([]);

    useEffect(() => {
        fetchRetreats();
    }, []);

    const fetchRetreats = async () => {
        try {
            const response = await axios.get('http://localhost:8080/all_retreat');
            setRetreat(response.data);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <>
            <Table striped bordered hover variant="white" style={{ width: '50%', marginTop: '10vh' }}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>transaction_date</th>
                        <th>ID_ACCOUNT</th>
                    </tr>
                </thead>
                <tbody>
                    {retreat.map(retreats => (
                        <tr key={retreats.id}>
                            <td>{retreats.id}</td>
                            <td>{retreats.amount}</td>
                            <td>{retreats.transaction_date}</td>
                            <td>{retreats.id_account}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </>
    );
}

export default AllRetreat;
