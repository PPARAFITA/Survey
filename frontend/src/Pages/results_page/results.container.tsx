import './results.styles.css';
import SelectList from '../../common/components/molecules/list.component';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormLabel from '@mui/material/FormLabel';
import Radio from '@mui/material/Radio';
import { CustomSelect } from '../../common/components/molecules/select.component';
import React, { useState } from 'react';

const LITERALS = {
    header: 'Analyze the results',
    p1: 'Visualize the info by',
    p2: 'Select your team and Hey Ho, Let’s Go 🤟',
    p3: 'Feelings traffic lights',
    p4: 'Doesn’t mean Perfect. It just means the squad is happy with this, and see no major need for improvement right now.',
    p5: 'Means there are some important problems that need addressing, but it’s not a disaster.',
    p6: ' Means this really sucks and needs to be improved. ',
    p7: 'Extra ball! Would you like to add something else?'
}


export const Results = () => {

    const [selectedTeam, setSelectedTeam] = useState<string>('');
    const [selectedOption, setSelectedOption] = useState<string>('month');
    const [showMonthSelector, setShowMonthSelector] = useState<boolean>(true);
    const [showKpiSelector, setShowKpiSelector] = useState<boolean>(false);

    const handleOptionChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { value } = event.target;
        setSelectedOption(value);
        if (value === 'month') {
            setShowMonthSelector(true);
            setShowKpiSelector(false);
        } else if (value === 'kpi') {
            setShowMonthSelector(false);
            setShowKpiSelector(true);
        }
    };

    return (

        <div className='item-container'>
            <h2 className='header5'> {LITERALS.header}</h2>
            <SelectList onTeamSelect={(teamId) => setSelectedTeam(teamId)}></SelectList>
            <FormLabel id="info_select">{LITERALS.p1}</FormLabel>
            <RadioGroup
                aria-labelledby="radio_group_results"
                defaultValue="month"
                name="radio-buttons-group"
                onChange={handleOptionChange}>
                <FormControlLabel value="month" control={<Radio />} label="Month" />
                <FormControlLabel value="kpi" control={<Radio />} label="KPI" />
            </RadioGroup>
            {showMonthSelector && <CustomSelect month={true} kpi={false} onSelectionChange={(value: string) => setSelectedOption(value)} />}
            {showKpiSelector && <CustomSelect month={false} kpi={true} onSelectionChange={(value: string) => setSelectedOption(value)} />}

        </div>
    )
};