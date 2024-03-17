import React from 'react';
import Stack from '@mui/material/Stack';
import '../../App.css';
import * as com from '../../common/components/index';
import '../../common/components/atom/button/button.styles.css';


const LITERALS = {
    p1: " Your insights are crucial for us to cultivate a positive work environment.Please take a moment to share your thoughts in our Team mood thermometer, as your feedback guides us in enhancing our team dynamics and ensuring everyone's well-being.",
    p2: ' The form is completely anonymus and you will take less than',
    p3: '(only 11 multiple choice questions)',
    p4: ' Take a moment to analyze the results of the team mood thermometer. ' + 
        'The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.',
    p5: 'Interested in the results?'
}


export const App = () => { 
    return (
        <div className="App">
             
                <p className="Body1">
                    {LITERALS.p1}
                    <br></br>
                    <br></br>
                    {LITERALS.p2} <span className='Body_bold'>2 minutes</span> {LITERALS.p3}
            
               

                <div className='Button'>
                    <Stack direction="row" spacing={2}>
                        <com.CustomButton color={'blue'} description={"Start the Survey"} path={"/FormMood"} />
                    </Stack>
                </div>

                <div className="form"></div>

                <div className="línea-horizontal"></div>

                <p className="header5">{LITERALS.p5}</p>

                <p className="Body1">
                    {LITERALS.p4}
                </p>

                <div className='Button'>
                    <com.CustomButton color={'white'} description={"Analyze the results"} path={"/Thanks"} />
                </div>

                <p>
                    If you want to know more go to <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/"><span className='More-information'>more information</span></a>
                </p>
                </p>
        </div>
    )
}
 


