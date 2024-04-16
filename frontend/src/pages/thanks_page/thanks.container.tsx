import React from 'react';
import thankimage from '../../assets/thanks.svg'
import { CustomButton } from '../../common/components';
import './thanks.styles.css';
import Divider from '@mui/material/Divider';


const LITERALS = {
    p1: "Thank you for answering the Team mood thermometer!",
    p2: 'We really appreciate your feedback',
    p3: 'Interested in the results?',
    p4: 'Take a moment to analyze the results of the team mood thermometer. ' +
        'The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.',
    p5: 'If you want to know more go to '
}

export const Thanks = () => {

    return (
        <body id='body' className="main">
            <div className="App-thanks">
                <div className="item-container">
                    <p className="header5">
                        {LITERALS.p1}
                    </p>
                    <span className='span'> {LITERALS.p2}</span>
                </div>
                <img src={thankimage} className='thanks-image' alt="logo" />

            </div>
            <Divider className='divider'></Divider> 
            <div className='form'>
                <p className="header5">
                    {LITERALS.p3}
                </p>
                <p>
                    {LITERALS.p4}
                </p>
            </div>
            <div className='Button'>
                <CustomButton color={'blue'} description={"Analyze the results"} path={"/Results"}  isDisabled= {true}/>
            </div>

            <p className='link-more'>
                {LITERALS.p5}<a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">
                    <span className='More-information'>more information</span></a>
            </p>
        </body>

    )
};

