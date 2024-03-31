import AboutAccount from './Account/About_account';
import Sidebar from './Sidebar/Sidebar';
import Header from './Account/Header';


const Home = () => {
    return (
        <>
        <Header/>
         <AboutAccount/>
      <Sidebar pageWrapId={'page-wrap'} outerContainerId={'outer-container'} />
        </>
    )
  };
  
  export default Home;