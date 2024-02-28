
import React from 'react';
import logo from './Pages/Landing_page/assets/DH_LOGO-BLACK.svg';
import thanks from './Pages/Thanks_page/assets/thanks.svg';
import './App.css';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

const buttonStyle = {
  backgroundColor: 'white', // Color de fondo del botón
  color: '#2196F3',
};

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <title>TEST HA SALTADO A ESTA PÁGina</title>
      </header>


      <body className="App-Body">
        <div className="form"></div>
        <p className="texto_body">
          Thank you for answering the Team mood thermometer!
        </p>
        <img src={thanks} className="App-logo2" alt="logo" />
        <div className="línea-horizontal"></div>
        <p className="texto_header">Interested in the results?</p>

        <p className="texto_body">
          Take a moment to analyze the results of the team mood thermometer.
          The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.
        </p>

        <div className='Button_analyze'>
          <Stack direction="row" spacing={2}>
            <a href="/Thanks"></a>
            <Button style={buttonStyle} variant="contained" onClick={() => { console.info("I'm a button.") }} href="/Thanks_page/Thanks"   >
              Analyze the results
            </Button>
          </Stack>


        </div>
        <p className="texto_body">
          If you want to know more go to <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">more information</a>
        </p>
      </body>
      <footer className="App-footer">
        <p className="texto">  Volkswagen Digital:HUB Barcelona - Internal</p>
        <img src={logo} className="App-logo2" alt="logo" />
      </footer>

    </div>
  );
}

export default App;
