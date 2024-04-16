/* eslint-disable array-callback-return */
import React, { useState, type FormEvent } from 'react';
import '../../App.css';
import './form.styles.css';
import RadioButtonUnchecked from '@mui/icons-material/RadioButtonUnchecked';
import TextField from '@mui/material/TextField';
import { getQuestions } from '../../services/question';
import Divider from '@mui/material/Divider';
import { CustomButton, RadioButtonsGroup, SelectList } from '../../common';

const LITERALS = {
    header: 'Welcome to the Digital Hub Survey',
    p1: 'Feel free, the form is completely anonymous. Sorry, but all questions are mandatory  🤓.',
    p2: 'Select your team and Hey Ho, Let’s Go 🤟',
    p3: 'Feelings traffic lights',
    p4: 'Doesn’t mean Perfect. It just means the squad is happy with this, and see no major need for improvement right now.',
    p5: 'Means there are some important problems that need addressing, but it’s not a disaster.',
    p6: ' Means this really sucks and needs to be improved. ',
    p7: 'Extra ball! Would you like to add something else?'
}

interface SurveyItem {
    questionId: string;
    question: string;
    optionDTOList: any[];
    surveyId: string;
}
interface Answer {
    answerId?: string;
    surveyId: string;
    questionId: string;
    optionId?: string;
    valorAnswer?: string;
}

interface FormData {
    answers: { [questionId: string]: Answer };
}

export const FormMood = () => {

    const [allQuestionsAnswered, setAllQuestionsAnswered] = useState(false);
    const [selectedTeam, setSelectedTeam] = useState<string>('');
    const [formData, setFormData] = useState<FormData>({
        answers: {}
    });


    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {

        const { value } = event.target;
        if (surveyData.length > 0) {
            const questionId = surveyData[surveyData.length - 1].questionId;

            setFormData(prevState => ({
                ...prevState,
                answers: {
                    ...prevState.answers,
                    [questionId]: {
                        answerId: "",
                        questionId: questionId,
                        optionId: "",
                        surveyId: surveyData[0].optionDTOList[0].surveyId,
                        valorAnswer: value
                    }
                }
            }));
        }
    };

    const [surveyData, setSurveyData] = useState<SurveyItem[]>([]);

    React.useEffect(() => {
        const fetchSurveyData = async () => {
            try {
                const response = await getQuestions();
                setSurveyData(response.data);
            } catch (error) {
                console.error('Error fetching survey data:', error);
            }
        };
        fetchSurveyData();
    }, []);

    const handleOptionChange = (answerId: string, questionId: string, optionId: string, surveyId: string, valorAnswer: string, event: React.ChangeEvent<HTMLInputElement>) => {

        // const teamId = selectedTeam;
        event.preventDefault();
        let answer_length = 0;

        const updatedAnswers: { [questionId: string]: Answer } = { ...formData.answers };
        if (updatedAnswers) {
            // updatedAnswers[questionId] = { answerId, questionId, optionId, surveyId, valorAnswer };
            updatedAnswers[questionId] = { answerId, questionId, optionId, surveyId, valorAnswer };


            answer_length = allQuestionsAnswered ? Object.keys(formData.answers).length : Object.keys(formData.answers).length + 1;
        }

        setFormData({
            ...formData,
            answers: updatedAnswers
        });

        getQuestions().then(response => {
            // const questionsData = response.data; 
            const allQuestionsAnswered = answer_length === surveyData.length - 1 && selectedTeam !== '';
            setAllQuestionsAnswered(allQuestionsAnswered);
        }).catch(error => {
            console.error('Error fetching questions:', error);
        });
    };




    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        const username = 'user';
        const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
        const credentials = btoa(`${username}:${password}`);

        const postData = Object.values(formData.answers).map(answer => ({
            answerId: '',
            surveyId: answer.surveyId,
            questionId: answer.questionId,
            optionId: answer.optionId,
            valorAnswer: answer.valorAnswer,
        }));


        let formDataToSend;


        if (allQuestionsAnswered) {
            console.log('Form submitted');
          
            formDataToSend = postData;

        } else {
            console.log('Not all questions answered');
        }

        fetch('/api/v1/thermometer/answer', {
            method: 'POST', 
            headers: {
                Authorization: `Basic ${credentials}`,
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataToSend),

        })

            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al enviar los datos al backend');
                }
                console.log('Datos enviados correctamente al backend');
            })
            .catch(error => {
                console.error('Error al enviar los datos al backend:', error);
            });
    }

    return (
        <form onSubmit={handleSubmit}>
            <div className='item-container'>
                <div className="item-container">
                    <div className='form'>
                        <h2 className='header5'> {LITERALS.header}</h2>
                        <p className='text'>
                            {LITERALS.p1} <br />
                            {LITERALS.p2}
                        </p>
                        <SelectList onTeamSelect={(teamId) => setSelectedTeam(teamId)}></SelectList>
                    </div>
                </div>
                <div className="item-container">
                    <div className='sombreado'>
                        <p className='header1' > {LITERALS.p3}   </p>
                        <br />
                        <RadioButtonUnchecked name='answer' className='RedButton' id='uncheckedbutton' />   <span> {LITERALS.p4} </span><br />
                        <RadioButtonUnchecked name='answer' className='GreenButton' id='uncheckedbutton' />   <span> {LITERALS.p5} </span><br />
                        <RadioButtonUnchecked name='answer' className='OrangeButton' id='uncheckedbutton' />   <span> {LITERALS.p6} </span><br />
                    </div>
                </div>

                <div className="item-container">
                    {surveyData.map((surveyItem) => {
                        const questionOptions = surveyItem.optionDTOList.filter(option => option.questionId === surveyItem.questionId);
                        if (questionOptions.length > 0) {
                            console.log(questionOptions[0].surveyId);
                            return (
                                <div key={surveyItem.questionId}>
                                    <RadioButtonsGroup
                                        questionId={surveyItem.questionId}
                                        question={surveyItem.question}
                                        surveyId={questionOptions[0].surveyId}
                                        options={questionOptions}
                                        onOptionChange={(answerId, questionId, optionId, surveyId, valor_answer, event) => handleOptionChange(answerId, questionId, optionId, surveyId, valor_answer, event)}
                                    />
                                    <Divider className='divider'></Divider>
                                </div>
                            );
                        }
                    })}

                </div>

                <p className='Title'>{LITERALS.p7} </p>
                <div className='container'>
                    <TextField id="input-comment"
                        name="valor_answer"
                        placeholder='Write your comments, thoughts, suggestions, requests, petitions...'
                        variant='outlined'
                        className='input'
                        onChange={handleInputChange}
                        label='I would like to tell you about...' />
                </div>
                <div>
                    <CustomButton color={'blue'} description={"Submit"} path={"/Thanks"} actionButton={(event) => handleSubmit(event as any)} isDisabled={!allQuestionsAnswered} />
                </div>
            </div>
        </form >
    )
};