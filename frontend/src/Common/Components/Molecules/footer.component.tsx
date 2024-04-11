import React from 'react';
import logoDH from '../../../assets/DH_LOGO-BLACK.svg';
import Grid from '@mui/material/Grid';
import './footer.styles.css';

const LITERALS ={footer: 'Volkswagen Digital:HUB Barcelona - Internal' }

export const Footer = () => {
    return (

        <Grid item ml={1}>
            <div id="footer" className='App-footer'>
                <Grid item xs={12} textAlign="start">
                    <p className="texto-footer"> {LITERALS.footer}</p>
                </Grid>
                <Grid item xs={12} textAlign="end"> 
                    <img src={logoDH} className="App-logoDH" alt="logo" />
                </Grid>
            </div>
        </Grid>
    )
}



