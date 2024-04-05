import { Box, FormControl, InputLabel, MenuItem, Select, SelectChangeEvent } from '@mui/material';
import './list.styles.css';
import { useEffect } from 'react';
import { getQuestions } from '../../../services/question';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import React, { useState } from 'react';

interface Props {
    month?: boolean;
    kpi?: boolean;
    onSelectionChange: (value: string) => void;
}

interface Question {
    questionId: string;
    question: string;
}

const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

const data = [
    { name: 'group A', value1: 4, value2: 1, value3: 2 },
    { name: 'group B', value1: 3, value2: 6, value3: 5 },
    { name: 'group C', value1: 5, value2: 3, value3: 6 },
    { name: 'Delivering Value', value1: 5, value2: 6, value3: 7 },
    { name: 'Easy to release', value1: 5, value2: 6, value3: 7 },
];

export const CustomSelect: React.FC<Props> = ({ month, kpi, onSelectionChange }) => {

    const [selectedValue, setSelectedValue] = useState<string>("");
    const [questionsData, setQuestionsData] = React.useState<Question[]>([]);
    const [showChart, setShowChart] = useState<boolean>(false);


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


    // Determinar el texto del placeholder y la etiqueta del select
    const label = month ? "Month" : "KPI";

    const text_placeholder = month ? "Select the month you are interested in" : "Select the KPI you are interested in";
    console.log(label)
    console.log(text_placeholder)
    console.log(questionsData)
    console.log(kpi)
    console.log(month)


    // Obtenemos el valor seleccionado para mostrar las gráficas
    const handleChange = (event: SelectChangeEvent<string>) => {


        const selectedValue = event.target.value;
         setSelectedValue(selectedValue); // No es necesario en este caso
        onSelectionChange(selectedValue);

        // setSelectedValue(event.target.value); 
        // onSelectionChange(selectedValue);

        setShowChart(true);
        console.log(selectedValue);
        console.log(label);
        console.log(text_placeholder);
    };



    return (
        <Box sx={{ minWidth: 450 }}>
            <div className='select'>
                <FormControl className='select' sx={{ m: 2, minWidth: 450 }}>

                    <InputLabel id="team_questions"
                        sx={{
                            left: '-3px',
                            top: '-6px',


                        }}>{label} </InputLabel>
                    <Select
                        labelId="team_results"
                        id="select_results"
                        value={selectedValue}
                        onChange={handleChange}
                        label={label}
                        placeholder={text_placeholder}>
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
                    {month && showChart && (
                        <BarChart width={500} height={300} data={questionsData.map(item => ({ question: item.question }))}>
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey={month ? "name" : "question"} />
                            <YAxis />
                            <Tooltip />
                            <Legend />
                            <Bar dataKey="value1" fill="#8884d8" barSize={20} />
                            <Bar dataKey="value2" fill="#82ca9d" barSize={20} />
                            <Bar dataKey="value3" fill="#ffc658" barSize={20} />
                        </BarChart>
                    )}

                    {kpi && showChart && (

                        <BarChart width={500} height={300} data={months} >
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey={kpi ? "question" : "months"} />
                            <YAxis />
                            <Tooltip />
                            <Legend />
                            <Bar dataKey="value1" fill="#8884d8" />
                            <Bar dataKey="value2" fill="#82ca9d" />
                            <Bar dataKey="value3" fill="#ffc658" />
                        </BarChart>)}
                    {/* <BarChart width={500} height={300} data={data}>
      <CartesianGrid strokeDasharray="3 3" />
      <XAxis dataKey="name" />
      <YAxis />
      <Tooltip />
      <Legend />
      <Bar dataKey="value1" fill="#8884d8" />
      <Bar dataKey="value2" fill="#82ca9d" />
      <Bar dataKey="value3" fill="#ffc658" />
    </BarChart> */}
                    {/* <BarChart
                        // component={CustomSVGComponent}
                        xAxis={[{ scaleType: 'band', data: ['group A', 'group B', 'group C'] }]}
                        series={[{ data: [4, 3, 5] }, { data: [1, 6, 3] }, { data: [2, 5, 6] }]}
                        width={500}
                        height={300}
                    /> */}


                </FormControl>
            </div>
        </Box >
    );
}
