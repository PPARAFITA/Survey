import React from 'react';
import './App.css';
import RoutesProvider from './core/routes.component';
import { Footer, Header } from './common';
import { Grid } from '@mui/material';



function App() {
  return (
    <Grid container spacing={1}>
      <div className="App">
        <Header />
        
        <div className='main'>
          <RoutesProvider />
        </div>

       <Footer />

      </div>
    </Grid>
  );
}

export default App;
