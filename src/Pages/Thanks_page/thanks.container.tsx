import React from 'react';
import thankimage from '../../assets/thanks.svg' 
import '../../App.css';
import * as com from '../../common/components/index';


function Thanks() {

    return (
        <div className="App">
           <body className="App-Body" id="texto_body">



                <p className="texto_header">
                    Thank you for answering the Team mood thermometer!
                </p>
                <p  id= "texto_body">
                    We really appreciate your feedback
                </p>
                <img src={thankimage} className="App-thanks" alt="logo" />
                <div className="form"></div>

                <div className="línea-horizontal"></div>

                <p className="texto_header">Interested in the results?</p>

                <p    id= "texto_body">
                    Take a moment to analyze the results of the team mood thermometer.
                    The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.</p>

                <div className='Button'>
                    <com.CustomButton color={"blue"} description={"Analyze the results"} path={"/Thanks"} />
                </div>

                <p className="More-information">
                    If you want to know more go to <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">more information</a>
                </p>

            </body>
        </div>
    )
}
;

export default Thanks;
