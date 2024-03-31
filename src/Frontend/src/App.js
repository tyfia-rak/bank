import './App.css';
import Sidebar from './components/Sidebar/Sidebar';
import 'bootstrap/dist/css/bootstrap.min.css';

import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

import Home from './components/Home';
import History from './components/List/History';
import AllTransaction from './components/Transaction/Transaction';
import IncomingTransferForm from './components/Transaction/Transaction_other_bank/TransactionOtherBank';
 

function App() {
  return (
    <div className="App" id="outer-container">
    <Router>
      <Sidebar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/history" element={<History />} />
        <Route path="/transaction" element={<AllTransaction />} />
        <Route path="/Approvisionment" element={<IncomingTransferForm />} />


      </Routes>
    </Router>
  </div>
    
    
  );
}

export default App;
/**
 * <Header/>
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
 */