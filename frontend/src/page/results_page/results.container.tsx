import './results.styles.css';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormLabel from '@mui/material/FormLabel';
import Radio from '@mui/material/Radio';
import { CustomSelect, SelectList } from '../../commons';
import React, { useEffect, useState } from 'react';
import { ReactComponent as EmptyStateSVG } from '../../assets/empty_state.svg';

import { ReactComponent as EmptyStateSVG2 } from '../../assets/Empty_State2.svg';



const MemoizedSelectList = React.memo(SelectList);

const LITERALS = {
    header: 'Analyze the results',
    p1: 'Visualize the info by',
    p2: 'Select filters'
}

export const Results = () => {

    const [selectedTeam, setSelectedTeam] = useState<string>('');
    // eslint-disable-next-line
    const [selectedOption, setSelectedOption] = useState<string>('month');
    const [showMonthSelector, setShowMonthSelector] = useState<boolean>(true);
    const [showKpiSelector, setShowKpiSelector] = useState<boolean>(false);
    const [teamChanged, setTeamChanged] = useState<boolean>(false);
    const [showEmptyState, setShowEmptyState] = useState<boolean>(true);

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

    const handleTeamSelect = (teamId: string) => {
        setSelectedTeam(teamId);
        setTeamChanged(true);
    };


    useEffect(() => {
        if (teamChanged) {
            setTeamChanged(false);
            setShowEmptyState(true);
        }
    }, [teamChanged]);


    return (

        <div className="App">
            <div className='item-container'>
                <h2 className='header5'> {LITERALS.header}</h2>
            </div>
            <div className='item-container'>
                <MemoizedSelectList onTeamSelect={handleTeamSelect}></MemoizedSelectList>
            </div>
            <div className='item-radiobutton'>
                <FormLabel className="info_select">{LITERALS.p1}</FormLabel>
                <RadioGroup
                    sx={{
                        display: 'flex',
                        flexDirection: 'row',
                    }}
                    className='results_radiobutton'
                    aria-labelledby="radio_group_results"
                    defaultValue="month"
                    name="radio-buttons-group"
                    onChange={handleOptionChange}>
                    <FormControlLabel value="month" control={<Radio />} label="Month" />
                    <FormControlLabel value="kpi" control={<Radio />} label="KPI" />
                </RadioGroup>
            </div>
            {selectedTeam && showMonthSelector && <CustomSelect month={true} kpi={false} teamId={selectedTeam}
                onSelectionChange={(value: string) => {
                    setSelectedOption(value);
                    setShowEmptyState(false);
                }} teamChanged={teamChanged} />}
            {selectedTeam && showKpiSelector && <CustomSelect month={false} kpi={true} teamId={selectedTeam} onSelectionChange={(value: string) => {
                setSelectedOption(value);
                setShowEmptyState(false);
            }} teamChanged={teamChanged} />}

            {showEmptyState && (
                <>
                    <div className='data_filters'>
                        <p className='title'>
                            {LITERALS.p2} </p>
                        <EmptyStateSVG2></EmptyStateSVG2>
                    </div>
                </>
            )}

        </div>
    )
};