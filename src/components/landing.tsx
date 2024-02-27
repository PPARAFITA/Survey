import React from 'react';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';


function Landing() {

    return (

        <div id="landing" className='landing' >
            <p>Your insights are crucial for us to cultivate a positive work environment. Please take a moment to share your thoughts
                in your Team Mood Thermometer, as your feedback guides us in enhancing our team dynamics and ensuring everyone's well-being. 
            </p>

            <p>The form is completely anonymus and you will take less than 2 minutes (only 11 multiple choice questions)</p>

            <Button id="btnstart" href="#">START THE SURVEY</Button>
    
        </div>

    )
}

export default Landing;