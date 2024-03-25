import * as React from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import './radio-button.styles.css';
import { SelectChangeEvent } from '@mui/material';
import axios from 'axios';

interface Props {
    questionId: string;
    question: string;
    answer1: string;
    answer2: string;
    answer3: string;
}


interface Question {
    answers: any;
    questionId: string;
    question: string;
    type: string;
}




export const RadioButtonsGroup: React.FC<Props> = ({ questionId, question, answer1, answer2, answer3 }) => {


    const username = 'user';
    const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
    const credentials = btoa(`${username}:${password}`);

    let [question1, setQuestion] = React.useState('');
    const [questionsData, setQuestionsData] = React.useState<Question[]>([]);

    React.useEffect(() => {
        axios.get('/api/v1/thermometer/question', {
            headers: {
                'Authorization': `Basic ${credentials}`
            }
        })
            .then(response => {
                console.log(response.data);
                setQuestionsData(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    const handleChange = (event: SelectChangeEvent) => {

  
        const selectedAnswer = event.target.value;
        const selectedQuestion = questionsData.find(question => question.question === question1);
    
        // if (selectedQuestion) {
            // const selectedAnswerId = selectedQuestion.answers.find((answer: { answer: string; }) => answer.answer === selectedAnswer)?.answer_id;
            // console.log("Selected question ID:", selectedQuestion.questionId);
            console.log("Selected answer ID:", selectedAnswer);
            console.log("Selected question ID:", questionId);
            // Aquí puedes hacer lo que necesites con los IDs recuperados
        // }

        // // eslint-disable-next-line @typescript-eslint/no-unused-vars
        // const selectedQuestion = event.target.value as string;
        // // eslint-disable-next-line no-self-compare
        // const selectedQuestionId = questionsData.find(question => question.question === question.question);
        // console.log("Selected team:", selectedQuestion);
        // console.log("Selected team:", selectedQuestionId);
        // // console.log("Selected team:", selectedTeam);
        // // console.log(selectedTeam?.teamName);

        // // if (selectedTeam) {
        // //   setTeam(selectedTeam.teamId);
        // // }

        // const selectedquestion = event.target.value as string;
        // const selectedQuestionId = event.target.value as string;
        // console.log(questionid2);
        // console.log({ selectedQuestionId });
        // // const selectedTeamId = event.target.value as string;
        // const selectedQuestion = questionData.find(question => question.question === selectedQuestion);
        // console.log("Selected question:", selectedQuestion);
        // // console.log("Selected team:", selectedTeam);
        // // console.log(selectedTeam?.teamName);

        // // if (selectedTeam) {
        // //   setTeam(selectedTeam.teamId);
        // // }
    };

    return (
        <FormControl>
            <FormLabel id="demo-radio-buttons-group-label" className='question'>{question}</FormLabel>
            <RadioGroup
                aria-labelledby="demo-radio-buttons-group-label"
                name="radio-buttons-group"
                onChange={handleChange}
            >
                <FormControlLabel className='RadioButton' value={'green'} control={<Radio className="GreenButton" />} label={answer1} />
                <FormControlLabel className='RadioButton' value={'orange'} control={<Radio className="OrangeButton" />} label={answer2} />
                <FormControlLabel className='RadioButton' value={'red'} control={<Radio className="RedButton" />} label={answer3} />
            </RadioGroup>
        </FormControl>
    );
}