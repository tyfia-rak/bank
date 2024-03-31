import React from 'react';
import styled from 'styled-components';
import './Style.css/sidebar.css';
import { Link } from 'react-router-dom';

const Container = styled.div`
  position: fixed;
  top: 0; 
  left: 0; 
  height: 100vh; 
  z-index: 1000;
`;


const Button = styled.button`
  background-color: var(--black);
  border: none;
  width: 2.5rem;
  height: 2.5rem;
  border-radius: 50%;
  margin: 0.5rem 0 0 0.5rem;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  &::before,
  &::after {
    content: "";
    background-color: var(--white);
    height: 2px;
    width: 1rem;
    position: absolute;
    transition: all 0.3s ease;
  }
  &::before {
    top: ${(props) => (props.clicked ? "1.5" : "1rem")};
    transform: ${(props) => (props.clicked ? "rotate(135deg)" : "rotate(0)")};
  }
  &::after {
    top: ${(props) => (props.clicked ? "1.2" : "1.5rem")};
    transform: ${(props) => (props.clicked ? "rotate(-135deg)" : "rotate(0)")};
  }
`;

const SidebarContainer = styled.div`
  background-color: var(--black);
  width: 3.5rem;
  height: 80vh;
  margin-top: 1rem;
  border-radius: 0 30px 30px 0;
  padding: 1rem 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  position: relative;
`;

const Logo = styled.div`
  width: 2rem;
  color:var(--white);
  svg {
    width: 100%;
    height: auto;
  }
`;

const SlickBar = styled.ul`
  color: var(--white);
  list-style: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: var(--black);
  padding: 2rem 0;
  position: absolute;
  top: 6rem;
  left: 0;
  width: ${(props) => (props.clicked ? "12rem" : "3.5rem")};
  transition: all 0.5s ease;
  border-radius: 0 30px 30px 0;
`;

const Item = styled.a`
  text-decoration: none;
  color: var(--white);
  width: 100%;
  padding: 1rem 0;
  cursor: pointer;
  display: flex;
  padding-left: 1rem;
  &:hover {
    border-right: 4px solid var(--white);
    svg {
      filter: invert(100%) sepia(0%) saturate(0%) hue-rotate(93deg)
        brightness(103%) contrast(103%);
    }
  }
  svg {
    width: 1.2rem;
    height: auto;
    filter: invert(92%) sepia(4%) saturate(1033%) hue-rotate(169deg)
      brightness(78%) contrast(85%);
  }
`;

const Text = styled.span`
  width: ${(props) => (props.clicked ? "100%" : "0")};
  overflow: hidden;
  margin-left: ${(props) => (props.clicked ? "1.5rem" : "0")};
  transition: all 0.3s ease;
`;



/**
 * const Name = styled.div`
  padding: 0 1.5rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  h4 {
    display: inline-block;
  }
  a {
    font-size: 0.8rem;
    text-decoration: none;
    color: var(--grey);
    &:hover {
      text-decoration: underline;
    }
  }
`;
 */




const Sidebar = () => {
  const [click, setClick] = React.useState(false);
  const handleClick = () => setClick(!click);


  return (
    <Container>
      <Button clicked={click} onClick={() => handleClick()}>
        Click
      </Button>
      <SidebarContainer>
        <Logo>
          <h2>CB</h2>
        </Logo>
        <SlickBar clicked={click}>
          <Item
            onClick={() => setClick(false)}
            exact
            activeClassName="active"
            to="/"
          >
<svg viewBox="0 0 576 512" width="100" title="home">
  <path d="M280.37 148.26L96 300.11V464a16 16 0 0 0 16 16l112.06-.29a16 16 0 0 0 15.92-16V368a16 16 0 0 1 16-16h64a16 16 0 0 1 16 16v95.64a16 16 0 0 0 16 16.05L464 480a16 16 0 0 0 16-16V300L295.67 148.26a12.19 12.19 0 0 0-15.3 0zM571.6 251.47L488 182.56V44.05a12 12 0 0 0-12-12h-56a12 12 0 0 0-12 12v72.61L318.47 43a48 48 0 0 0-61 0L4.34 251.47a12 12 0 0 0-1.6 16.9l25.5 31A12 12 0 0 0 45.15 301l235.22-193.74a12.19 12.19 0 0 1 15.3 0L530.9 301a12 12 0 0 0 16.9-1.6l25.5-31a12 12 0 0 0-1.7-16.93z" />
</svg>
            <Text clicked={click} > <Link to="/" style={{textDecoration: 'none',color: 'inherit'}}>Home</Link></Text>
          </Item>
          <Item
            onClick={() => setClick(false)}
            activeClassName="active"
            to="/team"
          >
            
      <svg viewBox="0 0 512 512" width="100" title="book-reader">
  <path d="M352 96c0-53.02-42.98-96-96-96s-96 42.98-96 96 42.98 96 96 96 96-42.98 96-96zM233.59 241.1c-59.33-36.32-155.43-46.3-203.79-49.05C13.55 191.13 0 203.51 0 219.14v222.8c0 14.33 11.59 26.28 26.49 27.05 43.66 2.29 131.99 10.68 193.04 41.43 9.37 4.72 20.48-1.71 20.48-11.87V252.56c-.01-4.67-2.32-8.95-6.42-11.46zm248.61-49.05c-48.35 2.74-144.46 12.73-203.78 49.05-4.1 2.51-6.41 6.96-6.41 11.63v245.79c0 10.19 11.14 16.63 20.54 11.9 61.04-30.72 149.32-39.11 192.97-41.4 14.9-.78 26.49-12.73 26.49-27.06V219.14c-.01-15.63-13.56-28.01-29.81-27.09z" />
</svg>
<Text clicked={click} > <Link to="/Approvisionment" style={{textDecoration: 'none',color: 'inherit'}}>Approvisionement</Link></Text>
          </Item>
          <Item
            onClick={() => setClick(false)}
            activeClassName="active"
            to="/team"
          >
            
      <svg viewBox="0 0 512 512" width="100" title="book-reader">
  <path d="M352 96c0-53.02-42.98-96-96-96s-96 42.98-96 96 42.98 96 96 96 96-42.98 96-96zM233.59 241.1c-59.33-36.32-155.43-46.3-203.79-49.05C13.55 191.13 0 203.51 0 219.14v222.8c0 14.33 11.59 26.28 26.49 27.05 43.66 2.29 131.99 10.68 193.04 41.43 9.37 4.72 20.48-1.71 20.48-11.87V252.56c-.01-4.67-2.32-8.95-6.42-11.46zm248.61-49.05c-48.35 2.74-144.46 12.73-203.78 49.05-4.1 2.51-6.41 6.96-6.41 11.63v245.79c0 10.19 11.14 16.63 20.54 11.9 61.04-30.72 149.32-39.11 192.97-41.4 14.9-.78 26.49-12.73 26.49-27.06V219.14c-.01-15.63-13.56-28.01-29.81-27.09z" />
</svg>
            <Text clicked={click}><Link to="/history" style={{textDecoration: 'none',color: 'inherit'}}>History</Link></Text>
          </Item>
          <Item
            onClick={() => setClick(false)}
            activeClassName="active"
            to="/calender"
          >

          <svg viewBox="0 0 512 512" width="100" title="history">
  <path d="M413.1 73.1C373.4 26.9 318.3 0 256 0 132.3 0 32 100.3 32 224s100.3 224 224 224c88.5 0 165.6-51.6 201.9-126.1 10.7-21.1-3.4-45.9-26.5-45.9H336v-64c0-12.1-14.5-18.4-23.1-9.7l-80 80c-6.2 6.2-6.2 16.4 0 22.6l80 80c8.6 8.6 23.1 2.4 23.1-9.7v-64h64c17.7 0 32-14.3 32-32V99.1c0-23.1-24.8-37.2-45.9-26zM256 176c-70.7 0-128 57.3-128 128s57.3 128 128 128 128-57.3 128-128-57.3-128-128-128zm16 144c-8.8 0-16 7.2-16 16v48H176c-8.8 0-16 7.2-16 16s7.2 16 16 16h112v48c0 8.8 7.2 16 16 16s16-7.2 16-16v-64c0-26.5-21.5-48-48-48z"/>
</svg>

            <Text clicked={click}><Link to="/Transaction" style={{textDecoration: 'none',color: 'inherit'}}>Transacitons</Link></Text>
          </Item>
          <Item
            onClick={() => setClick(false)}
            activeClassName="active"  
            to="/projects"
          >
            
   
          </Item>
        </SlickBar>

      </SidebarContainer>
    </Container>
  );
};

export default Sidebar;