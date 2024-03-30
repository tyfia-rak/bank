import Table from 'react-bootstrap/Table';
import axios from 'axios';
import { useState,useEffect } from 'react';
function AllAccount (){
    const [accounts, setAccounts] = useState([]);

    useEffect(() => {
        fetchAccounts();
      }, []);

      const fetchAccounts = async () => {
        try {
          const response = await axios.get('http://localhost:8080/all_account');
          setAccounts(response.data);
        } catch (error) {
          console.error('Error:', error);
        }
      };

    return (
      <>
         <Table striped bordered hover variant="white"style={{ width: '50%', marginTop:'10vh' }}>
          <thead>
            <tr>
              <th>ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Birthday</th>
              <th>Bank Balance</th>
              <th>Bank Name</th>
              <th>Salary Amount</th>
              <th>Overdraw</th>
            </tr>
          </thead>
          <tbody>
          {accounts.map(account => (
            <tr key={account.id}>
              <td>{account.id}</td>
              <td>{account.firstName}</td>
              <td>{account.lastName}</td>
              <td>{account.birthday}</td>
              <td>{account.bankBalance}</td>
              <td>{account.bankName}</td>
              <td>{account.salaryAmount}</td>
              <td>{account.overdraw ? 'Yes' : 'No'}</td>
            </tr>
          ))}
          </tbody>
        </Table>
      </>
       
      );   
}
export default AllAccount;