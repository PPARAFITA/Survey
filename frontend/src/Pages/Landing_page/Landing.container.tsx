import React from 'react';
import Stack from '@mui/material/Stack';
import '../../App.css';
import { CustomButton } from '../../common';
import Divider from '@mui/material/Divider';
import '../../common/components/atom/button/button.styles.css';
import './landing.styles.css';


const LITERALS = {
    p1: " Your insights are crucial for us to cultivate a positive work environment.Please take a moment to share your thoughts in our Team mood thermometer, as your feedback guides us in enhancing our team dynamics and ensuring everyone's well-being.",
    p2: ' The form is completely anonymus and you will take less than',
    p3: '(only 11 multiple choice questions)',
    p4: ' Take a moment to analyze the results of the team mood thermometer. ' +
        'The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.',
    p5: 'Interested in the results?',
    p6: 'If you want to know more go to '
}


export const App = () => {
    return (
        <div className="App">

            <p className="Body1">
                {LITERALS.p1}
                <br></br>
                <div>
                    {LITERALS.p2} <span className='Body_bold'>2 minutes</span> {LITERALS.p3}
                </div>
                <div className='Button'>
                    <Stack direction="row" spacing={1}>
                        <CustomButton color={'blue'} description={"Start the Survey"} path={"/FormMood"}  />
                    </Stack>
                </div>
            </p>
            <Divider className='divider'></Divider> 
            <p className="Body1">
                <p className="header5">{LITERALS.p5}</p>

                {LITERALS.p4}

                <div className='Button'>
                    <CustomButton color={'white'} description={"Analyze the results"} path={"/Results"} isDisabled= {true} />
                </div>

                <p className='link-more'>
                    {LITERALS.p6}<a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/" target="_blank" rel="noreferrer noopener"  >
                        <span className='More-information'>more information</span></a>

                </p> </p>
        </div>
    )
}



