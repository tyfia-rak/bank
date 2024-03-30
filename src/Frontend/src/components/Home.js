import IncomingTransferForm from './Transaction_other_bank/TransactionOtherBank';
import TransferForm from './Transaction_between_account/TransactionBetweenAccount';
import WithdrawForm from './Transaction_Retreat/Retreat';
import AboutAccount from './Account/About_account';
import Sidebar from './Sidebar/Sidebar';
import Header from './Account/Header';


const Home = () => {
    return (
        <>
        <Header/>
         <AboutAccount/>
      <Sidebar pageWrapId={'page-wrap'} outerContainerId={'outer-container'} />
    <IncomingTransferForm/>
    <TransferForm/>
    <WithdrawForm/>
        </>
    )
  };
  
  export default Home;