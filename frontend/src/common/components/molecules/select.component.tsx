import { Box, FormControl, InputLabel, MenuItem, Select, SelectChangeEvent } from '@mui/material';
import './list.styles.css';
import { useEffect } from 'react';
import { getQuestions } from '../../../services/question';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';
import React, { useState } from 'react';
import { getResults } from '../../../services/mocks/mockresults';
// import { getResultsb } from '../../../services/results';

interface Props {
    month?: boolean;
    kpi?: boolean;
    teamId: string;
    onSelectionChange: (value: string) => void;
}

interface Question {
    questionId: string;
    question: string;
}

interface traffic_light {
    green: string;
    orange: string;
    red: string;
}

interface Result {
    questionId: string;
    questionType: string;
    question: string;
    response: traffic_light
}

const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

const { data_results, data_results_months } = getResults();


export const CustomSelect: React.FC<Props> = ({ month, kpi, teamId, onSelectionChange }) => {

    const [selectedValue, setSelectedValue] = useState<string>("");
    const [questionsData, setQuestionsData] = React.useState<Question[]>([]);
    const [showChart, setShowChart] = useState<boolean>(false);
    const [deletedLastQuestion, setDeletedLastQuestion] = useState<boolean>(false);

    useEffect(() => {

        getQuestions()
            .then(response => {
                setQuestionsData(response.data);
            })
            .catch(error => {
                console.error('Error fetching questions:', error);
            });
    }
        , []);

        if ( questionsData.length > 0 && !deletedLastQuestion){
            setQuestionsData(prevQuestionsData => prevQuestionsData.slice(0, -1));
            setDeletedLastQuestion(true);
        }
    const label_select = month ? "Month" : "KPI";
    const groupby = label_select.toLowerCase();
    const text_placeholder = month ? "Select the month you are interested in" : "Select the KPI you are interested in";
    

 
    const handleChange = (event: SelectChangeEvent<string>) => {
      
        const selectedValue = event.target.value;
        setSelectedValue(selectedValue);  
        onSelectionChange(selectedValue);
        console.log(selectedValue);
        console.log(groupby);
        console.log("TEAM", teamId)


        

        // const Results = getResultsb( teamId,groupby,selectedValue);
        // setSelectedValue(event.target.value); 
        // onSelectionChange(selectedValue);

        setShowChart(true);
    };



    return (
        <Box sx={{ minWidth: 450 }}>
            <div className='select'>
                <FormControl className='select' sx={{ m: 2, minWidth: 200 }}>

                    <InputLabel id="team_questions"
                        sx={{
                            left: '-3px',
                            top: '-6px',
                        }}>{label_select} </InputLabel>
                    <Select
                        labelId="team_results"
                        id="select_results"
                        value={selectedValue}
                        onChange={handleChange}
                        label={label_select}
                        placeholder={text_placeholder}
                        sx={{ minWidth: 200,
                            marginBottom: 1  }}>
                        <MenuItem value="" disabled>
                            <em>{text_placeholder}</em>
                        </MenuItem>
                        {month && months.map((month, index) => (
                            <MenuItem key={index} value={month}>{month}</MenuItem>
                        ))}
                        {kpi && questionsData.map((questionItem: Question) => (
                            <MenuItem key={questionItem.questionId} value={questionItem.question}>{questionItem.question}</MenuItem>
                        ))}

                    </Select>
                </FormControl>
            </div>
            {month && showChart && (
                <BarChart width={1800} height={300} data={data_results}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" /> {/*  question */} 
                    <YAxis />
                    <Tooltip />
                    <Bar dataKey="Green" fill="#64A844" barSize={20} /> {/*  response.green */}
                    <Bar dataKey="Orange" fill="#FF9B00" barSize={20}/>
                    <Bar dataKey="Red" fill="#DA0C1F" barSize={20}/>
                </BarChart>
            )}

            {kpi && showChart && (

                <BarChart width={1800} height={400} data={data_results_months} >
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" /> {/*  month */} 
                    <YAxis />
                    <Tooltip />
                    <Bar dataKey="Green" fill="#64A844" barSize={15}/> {/*  response.green */}
                    <Bar dataKey="Orange" fill="#FF9B00" barSize={15}/>
                    <Bar dataKey="Red" fill="#DA0C1F" barSize={15} />
                </BarChart>)}
        </Box >
    );
}
 
