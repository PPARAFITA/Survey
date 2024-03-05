import React from 'react';
import Stack from '@mui/material/Stack'; 
import '../../App.css';
import * as com from '../../common/components/index';


function App() {
    return (
        <div className="App">
            <body className="App-Body" id="texto_body">
                <p className="texto_body">
                    Your insights are crucial for us to cultivate a positive work environment.
                    Please take a moment to share your thoughts in our Team mood thermometer, as your feedback guides us in enhancing our team dynamics and ensuring everyone's well-being.
                    <br></br>
                    <br></br>
                    The form is completely anonymus and you will take less than 2 minutes (only 11 multiple choice questions).
                </p>

                <div className='Button'>
                    <Stack direction="row" spacing={2}>
                        <com.CustomButton  color={"blue"} description={"Start the Survey"} path={"/Thanks"} />
                    </Stack>
                </div>


                <div className="form"></div>

                <div className="línea-horizontal"></div>
                <p className="texto_header">Interested in the results?</p>

                <p className="texto_body">
                    Take a moment to analyze the results of the team mood thermometer.
                    The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.</p>

                <div className='Button'>
                    <com.CustomButton color={"white"} description={"Analyze the results"} path={"/Thanks"} />
                </div>

                <p className="More-information">
                    If you want to know more go to <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">more information</a>
                </p>

            </body>
        </div>
    )
}
;

export default App;
