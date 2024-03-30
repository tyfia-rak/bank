import './App.css';
import Sidebar from './components/Sidebar';
import Header from './components/Account/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import AllAccount from './components/Account/ListAccount';
import Account from './components/Account/account';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import DetailsComponent from './components/Account/DetailsAccount';
import IncomingTransferForm from './components/Transaction_other_bank/TransactionOtherBank';
import TransferForm from './components/Transaction_between_account/TransactionBetweenAccount';
import WithdrawForm from './components/Transaction_Retreat/Retreat';
import AccountForm from './components/Account/InsertAccount';
import AllRetreat from './components/List/ListRetreat';
import AllTranferMoney from './components/List/ListTranferMoney';



function App() {
  return (
    <div className="App" id="outer-container">
      <Header/>
      <DetailsComponent/>
      <Sidebar pageWrapId={'page-wrap'} outerContainerId={'outer-container'} />
      <AllAccount/>
      <Router>
      <Routes>
          <Route exact path='/new' Component={Account}/>
      </Routes>
    </Router>
    <AccountForm/>
    <IncomingTransferForm/>
    <TransferForm/>
    <WithdrawForm/>
    <AllRetreat/>
    <AllTranferMoney/>
    </div>
    
    
  );
}

export default App;
