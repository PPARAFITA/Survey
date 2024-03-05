import React from 'react';
import thermometer from '../../../assets/thermometer.svg';
import team_mood from '../../../assets/Team_Mood.svg';


function Header() {

    return (
        <div className='App-header' >

            <img src={thermometer} className="App-thermometer" alt="logo" />
            <img src={team_mood } className="App-team" alt="logo" />
             

        </div>


    )
}

export default Header;