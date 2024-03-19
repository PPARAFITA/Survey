import React from 'react';
import thankimage from '../../assets/thanks.svg'
import '../../App.css';
import * as com from '../../common/components/index';




const LITERALS = {
    p1: " Thank you for answering the Team mood thermometer!",
    p2: 'We really appreciate your feedback',
    p3: 'Interested in the results?',
    p4: 'Take a moment to analyze the results of the team mood thermometer. ' +
        'The data is grouped by team and it is possible to view it by month to have a global view of the situation or by KPI to gain a deeper understanding of the evolution of a specific variable over time.',
    p5: 'If you want to know more go to'
}


function Thanks() {

    return (
        <div className="App">
            <body className="App-Body" id="texto_body">
                <p className="texto_header">
                    {LITERALS.p1}
                </p>
                <p id="texto_body">
                    {LITERALS.p1}
                </p>
                <img src={thankimage} className="App-thanks" alt="logo" />
                <div className="form"></div>

                <div className="línea-horizontal"></div>

                <p className="texto_header">{LITERALS.p3}</p>

                <p id="texto_body">
                    {LITERALS.p4}</p>

                <div className='Button'>
                    <com.CustomButton color={'blue'} description={"Analyze the results"} path={"/Thanks"} />
                </div>

                <p className="More-information">
                    {LITERALS.p5}  <a href="https://engineering.atspotify.com/2014/09/squad-health-check-model/">more information</a>
                </p>

            </body>
        </div>
    )
}
;

export default Thanks;
