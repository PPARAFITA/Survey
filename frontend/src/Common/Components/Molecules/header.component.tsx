import React from 'react';
import thermometer from '../../../assets/thermometer.svg'; 
import team_mood1 from '../../../assets/Vector.svg';
import Grid from '@mui/material/Grid';
import './header.styles.css';

export const Header =() =>{
     return (

        <Grid  item ml={1}   >
            <div className='App-header'>
                <img src={thermometer} className="App-thermometer" alt="logo" />
                <img src={team_mood1} className="Team_image" alt="logo" />
            </div>
        </Grid>
    )
}
 