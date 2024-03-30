import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/esm/Table';

const DetailsComponent = () => {
  const [details, setDetails] = useState(null);
  const accountId = 2; 

  useEffect(() => {
    const fetchAccountDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/details/${accountId}`);
        setDetails(response.data);
      } catch (error) {
        console.error('Error fetching account details:', error);
      }
    };

    fetchAccountDetails();
  }, [accountId]);

  return (
<div>
      {details ? (
        <Table striped bordered hover variant="white"style={{ width: '20vw',marginLeft:'60vw' }}>
          <thead>
            <tr>
              <th>Account: {accountId}</th>
              <th>Amount</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Firt name</td>
              <td>{details.firstName}</td>
            </tr>
            <tr>
              <td>Last name</td>
              <td>{details.lastName}</td>
            </tr>
            <tr>
              <td>Amount</td>
              <td>{details.bankBalance}</td>
            </tr>
            <tr>
              <td>Loans</td>
              <td>{details.loans}</td>
            </tr>
            <tr>
              <td>Interest</td>
              <td>{details.interest}</td>
            </tr>
          </tbody>
        </Table>
      ) : (
        <p>Loading...</p>
      )}
    </div>
    
  );
};

export default DetailsComponent;
