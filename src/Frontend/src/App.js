import './App.css';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import AllAccount from './components/ListAccount';

function App() {
  return (
    <div className="App" id="outer-container">
      <Header/>
      <Sidebar pageWrapId={'page-wrap'} outerContainerId={'outer-container'} />
      <AllAccount/>
    </div>
    
  );
}

export default App;
