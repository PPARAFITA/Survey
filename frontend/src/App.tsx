import React from 'react';
import './App.css';
import RoutesProvider from './core/routes.component';
import { Grid } from '@mui/material';
import { Footer, Header } from './common/components';



function App() {
  return (
    //   <Grid container spacing={1}>
    //   <div className="App">
    //     <Header />
    //     <div className='main'>
    //       <RoutesProvider />
    //     </div>
    //     <Footer/>
        
    //   </div>
    
    //  </Grid>

    <Grid container spacing={1}>
      <div className="App">
        <Grid item xs={12}>
          <Header />
        </Grid>
        <Grid item xs={12}>
          <div className='main'>
            <RoutesProvider />
          </div>
        </Grid>
        <Grid item xs={12}>
          <Footer/>
        </Grid>
      </div>
    </Grid>
  );
}

export default App;
