import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import '../Styles/sidebar.css';
 function Slidebar  () {
  return (
    <Menu>
      <a className="menu-item" href="/">
        Home
      </a>
      <a className="menu-item" href="/salads">
        All Accounts
      </a>
      <a className="menu-item" href="/pizzas">
        Retrait
      </a>
      <a className="menu-item" href="/desserts">
        Transaction
      </a>
    </Menu>
  );
};
export default Slidebar;