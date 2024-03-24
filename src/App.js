import './App.css';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import AllAccount from './components/ListAccount';
import Account from './components/account';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import DetailsComponent from './components/DetailsAccount';
import IncomingTransferForm from './components/TransactionOtherBank';
import TransferForm from './components/TransactionBetweenAccount';



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
    <Account/>
    <IncomingTransferForm/>
    <TransferForm/>
  
    </div>
    
    
  );
}

export default App;
