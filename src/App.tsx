import React from 'react';
import logo2 from './Pages/Landing_page/assets/DH_LOGO-BLACK.svg';
import './App.css';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Header from './components/header'
import Landing from './components/landing'


function App() {
  return (
    <div className="App">

      <body className="App-body">
        <Header/>
        <Landing/>
      </body>

      <footer className="App-footer">
        <p className="texto">  Volkswagen Digital:HUB Barcelona - Internal</p>
        <img src={logo2} className="App-logo2" alt="logo" />
      </footer>

    </div>
  );
}
  
export default App;
