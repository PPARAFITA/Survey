import { Box, FormControl, InputLabel, MenuItem, Select, SelectChangeEvent } from '@mui/material';
import './select.styles.css';
import { useEffect, useState, useMemo } from 'react';
import { getQuestions } from '../../../services/question';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';
import React from 'react';
import { getResults } from '../../../services/mocks/mockresults';
import { Results } from '../../../page/results_page/results.container';
import { getResultsb } from '../../../services/results';
import { AxiosResponse } from 'axios';
import noDataFound from '../../../assets/embarrassed.svg';

interface Props {
    month?: boolean;
    kpi?: boolean;
    teamId: string;
    onSelectionChange: (value: string) => void;
    teamChanged?: boolean;
}

interface Question {
    questionId: string;
    question: string;
}

// interface traffic_light {
//     green: string;
//     orange: string;
//     red: string;
// }

// interface Result {
//     questionId: string;
//     questionType: string;
//     question: string;
//     response: traffic_light
// }

// interface Results {
//     teamId: string;
//     month?: boolean;
//     selectedValue: string;
//     kpi?: boolean;
//     resultquestionId?: string;
// }
const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];


const LITERALS =
{
    p1: 'answers this month',
    p2: 'answers this period'
}


export const CustomSelect: React.FC<Props> = React.memo(({ month, kpi, teamId, onSelectionChange, teamChanged }) => {
    console.log('Componente X renderizado')
    const [questionsData, setQuestionsData] = React.useState<Question[]>([]);

    const [selectedValue, setSelectedValue] = useState<string>("");
    const [showChart, setShowChart] = useState<boolean>(false);
    const [deletedLastQuestion, setDeletedLastQuestion] = useState<boolean>(false);
    const [dataResultsMonth, setDataResultsMonth] = useState<any[]>([]);
    const [dataResultsKpi, setDataResultsKpi] = useState<any[]>([]);

    // const currentMonth = useMemo(() => {
    //     const currentDate = new Date();
    //     const currentMonthNumber = currentDate.getMonth();
    //     setShowChart(true);
    //     return months[currentMonthNumber];

    // }, []);


    // const defaultSelectedValue = useMemo(() => (month ? currentMonth : ""), [currentMonth]);
    // const [selectedValue, setSelectedValue] = useState<string>(defaultSelectedValue);


    // useEffect(() => {
    //     if (!teamChanged) {
    //         setSelectedValue(month ? currentMonth : "");
    //     }
    // }, [teamChanged, currentMonth, month]);




    useEffect(() => {
        getQuestions()
            .then(response => {
                setQuestionsData(response.data);
            })
            .catch(error => {
                console.error('Error fetching questions:', error);
            });
    }
        , [teamChanged]);


    if (questionsData.length > 0 && !deletedLastQuestion) {
        setQuestionsData(prevQuestionsData => prevQuestionsData.slice(0, -1));
        setDeletedLastQuestion(true);
    }



    const label_select = month ? "Month" : "KPI";
    const answers_total = month ? LITERALS.p1 : LITERALS.p2;
    const text_placeholder = month ? "Select the month you are interested in" : "Select the KPI you are interested in";


    const [results, setResults] = useState<any>(null);


    useEffect(() => {
        if (teamChanged) {
            // setSelectedValue("");
            setShowChart(false);
        }
    }, [teamChanged]);

    useEffect(() => {
        if (!selectedValue) return;
        const fetchData = async () => {
            try {
                let resultquestionId = null;
                if (kpi) {
                    const question = questionsData.find(question => question.question === selectedValue);
                    resultquestionId = question ? question.questionId : null;
                }
                const response: AxiosResponse<any> | null = await getResultsb({ teamId, month, selectedValue, kpi, resultquestionId });
                if (response !== null) {
                    if (response.data.length > 0) {
                        setResults(response.data);
                        if (month) {
                            setDataResultsMonth(response.data);
                        }
                        else {
                            setDataResultsKpi(response.data);
                        }
                    }
                    else {
                        setShowChart(false);
                    }
                }


            } catch (error) {
                console.error('Error fetching results:', error);
            }
        };
        fetchData();
        if (teamChanged) {
            fetchData();
        }
        return () => {
            setResults(null)
        };
    }, [selectedValue, kpi, month, teamId, questionsData]);




    const handleChange = (event: SelectChangeEvent<string>) => {

        const selectedValue = event.target.value;
        setSelectedValue(selectedValue);
        onSelectionChange(selectedValue);
        setShowChart(true);

        // const newValue = event.target.value;
        // if (newValue !== selectedValue) {
        //     setSelectedValue(newValue);
        //     onSelectionChange(newValue);
        //     setShowChart(true);
        //     fetchData();
        // }
    };


    const sortedDataResultsKPI = useMemo(() => {
        return dataResultsKpi.sort((a, b) => {
            const monthIndexA = parseInt(a.month) - 1;
            const monthIndexB = parseInt(b.month) - 1;
            return monthIndexA - monthIndexB;
        });
    }, [dataResultsKpi]);

    console.log('sort', sortedDataResultsKPI)


    const dataResultsKPIWithText = sortedDataResultsKPI.map(item => {
        const monthNumber = parseInt(item.month, 10);
        const monthText = months[monthNumber - 1];
        return { ...item, month: monthText };
    });


    const monthOrder: { [month: string]: number } = {
        "january": 1,
        "february": 2,
        "march": 3,
        "april": 4,
        "may": 5,
        "june": 6,
        "july": 7,
        "august": 8,
        "september": 9,
        "october": 10,
        "november": 11,
        "december": 12
    };

    const capitalizeFirstLetter = (str: string) => {
        return str.charAt(0).toUpperCase() + str.slice(1);
    };
    const sortedData = dataResultsKpi.sort((a, b) => {
        const monthA = monthOrder[a.month.toLowerCase()];
        const monthB = monthOrder[b.month.toLowerCase()];

        return monthA - monthB;
    });

    sortedData.forEach(item => {
        item.month = capitalizeFirstLetter(item.month);
    });
    console.log(sortedData)


    return (

        <Box sx={{ minWidth: 450 }}>
            <div className='item_container'>
                <FormControl className='select_team' sx={{ m: 2, minWidth: 200 }}>

                    <InputLabel id="team_questions"
                        sx={{
                            left: '-3px',
                            top: '-6px',
                        }}>{ } </InputLabel>
                    <Select
                        labelId="team_results"
                        value={selectedValue}
                        onChange={handleChange}
                        label={label_select}
                        placeholder={text_placeholder}
                        sx={{
                            minWidth: 200,
                            marginBottom: 1
                        }}>
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
                <><div className='item_container_top'>
                    <span className='boldLocal'>{dataResultsMonth.length}</span>
                    <span> {answers_total}</span>
                </div>
                    <BarChart width={1800} height={300} data={dataResultsMonth}>
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="question"
                            tick={{ fontSize: 10 }} />
                        <YAxis tick={{ fontSize: 10 }} />
                        {/* <Tooltip /> */}
                        <Bar dataKey="response.green" fill="#64A844" barSize={20} />
                        <Bar dataKey="response.orange" fill="#FF9B00" barSize={20} />
                        <Bar dataKey="response.red" fill="#DA0C1F" barSize={20} />
                    </BarChart></>
            )}

            {kpi && showChart && (
                <><div className='item_container_top'>
                    <span className='boldLocal'>{sortedData.length}</span>
                    <span> {answers_total}</span>
                </div>

                    <BarChart width={1800} height={400} data={sortedData} >
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="month"
                            tick={{ fontSize: 10 }} />
                        <YAxis tick={{ fontSize: 10 }} />
                        <YAxis />
                        {/* <Tooltip /> */}
                        <Bar dataKey="response.green" fill="#64A844" barSize={20} />
                        <Bar dataKey="response.orange" fill="#FF9B00" barSize={20} />
                        <Bar dataKey="response.red" fill="#DA0C1F" barSize={20} />
                    </BarChart></>)

            }
            {(selectedValue !== "" && !showChart) && (
                <>
                    <div className='data_nofound'>
                        <img src={noDataFound} height={400} alt="No Data Found" />
                        <p> No DATA FOUND</p>
                    </div>
                </>
            )}
        </Box >

    )
});


