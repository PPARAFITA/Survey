import React from 'react';
import logo2 from './Pages/Landing_page/assets/DH_LOGO-BLACK.svg';
import thermometer from './thermometer.svg';
import './App.css';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Link from './Pages/Thanks_page/Thanks';


const buttonStyle = {
  backgroundColor: 'white', // Color de fondo del botón
  color: '#2196F3',
};

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={thermometer} className="App-thermometer" alt="logo" />
        <p className="texto_header">  Team Mood Thermometer</p>
      </header>

      <body className="App-Body">
        <p className="texto_body">
          Your insights are crucial for us to cultivate a positive work environment.
          Please take a moment to share your thoughts in our Team mood thermometer, as your feedback guides us in enhancing our team dynamics and ensuring everyone's well-being.
          <br></br> 
          The form is completely anonymus and you will take less than 2 minutes (only 11 multiple choice questions).
        </p>

            <div className='Button_start'>
        <Stack direction="row" spacing={2}>
          <a href="/Thanks"></a>
          <Button variant="contained" onClick={() => { console.info("I'm a button.") }} href="/Thanks_page/Thanks"   >
            Start the Survey
          </Button>
        </Stack>
        </div>


        <div className="form"></div>

        <div className="línea-horizontal"></div>
        <p className="texto_header">Interested in the results?</p>

        <p className="texto_body">
          Take a moment to analyze the results of the team mood thermometer.
          The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.</p>

        <div className='Button_analyze'>
          <Stack direction="row" spacing={2}>
            <a href="/Thanks"></a>
            <Button style={buttonStyle} variant="contained" onClick={() => { console.info("I'm a button.") }} href="/Thanks_page/Thanks"   >
              Analyze the results
            </Button>
          </Stack>
        </div>

        <p className="More-information">
          If you want to know more go to <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">more information</a>
        </p>



      <footer className="App-footer">
        <p className="texto">  Volkswagen Digital:HUB Barcelona - Internal</p>
        <img src={logo2} className="App-logo2" alt="logo" />
      </footer>

    </div>
  );
}

export default App;
