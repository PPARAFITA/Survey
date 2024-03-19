import * as React from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import './radio-button.styles.css';

interface Props {  
    question:string;
    answer1: string;
    answer2: string;
    answer3: string;
}


export const RadioButtonsGroup: React.FC<Props> = ({  question , answer1, answer2,  answer3 }) => {

    return (
        <FormControl>
            <FormLabel id="demo-radio-buttons-group-label" className='question'>{question}</FormLabel>
            <RadioGroup
                aria-labelledby="demo-radio-buttons-group-label"
                name="radio-buttons-group"
            >
                <FormControlLabel className='RadioButton' value={answer1} control={<Radio className="GreenButton" />} label={answer1} />
                <FormControlLabel className='RadioButton' value={answer2} control={<Radio className="OrangeButton"  />} label={answer2} />
                <FormControlLabel className='RadioButton' value={answer3} control={<Radio className="RedButton"  />} label={answer3}/>
            </RadioGroup>
        </FormControl>
    );
}