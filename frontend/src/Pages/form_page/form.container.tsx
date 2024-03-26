import React, { useState, type FormEvent } from 'react';
import '../../App.css';
import SelectList from '../../common/components/molecules/list.component';
import RadioButtonUnchecked from '@mui/icons-material/RadioButtonUnchecked';
import { CustomButton, RadioButtonsGroup } from '../../common';
import './form.styles.css';
import TextField from '@mui/material/TextField';
import { getQuestions } from '../../services/question';
import { getSurveyData } from '../../services/mocks/mockquestion';
// import { getSurvey } from '../../services/survey';

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




// interface Question {
//     questionId: string;
//     question: string;
//     type: string;
//     answer1: string;
//     answer2: string;
//     answer3: string;
// }

// Function Submit Form 


export const FormMood = () => {


    const [formData, setFormData] = useState({
        answers: [] as { questionId: number; optionId: number }[] 
    });

    const handleOptionChange = (questionId: number, optionId: number) => {
        setFormData({
            ...formData,
            answers: [
                ...formData.answers,
                { questionId, optionId }
            ]
        });
    };


    function handleSubmit(event: FormEvent<HTMLFormElement>) {

        console.log('Form submitted');
        console.log('test');
        event.preventDefault();

        // Obtener los datos del formulario 
        console.log(formData.answers);

    };
    const survey = getSurveyData();
    // const surveyb = getSurvey();

    // const [question, setQuestion] = React.useState('');
    // const [questionData, setQuestionsData] = React.useState<Question[]>([]);


    React.useEffect(() => {
        getQuestions()
            .then(response => {
                console.log(response.data);
                // setQuestionsData(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);



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

                        <SelectList></SelectList>
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
                    {survey.map((surveyItem) => {
                        const questionOptions = surveyItem.optionDTOList.filter(option => option.questionId === surveyItem.questionId);

                        return (
                            <div key={surveyItem.questionId}>
                                <RadioButtonsGroup
                                    questionId={surveyItem.questionId}
                                    question={surveyItem.question}
                                    options={questionOptions} 
                                    onOptionChange={(selectedOption: any) => handleOptionChange(surveyItem.questionId,surveyItem.optionDTOList[surveyItem.questionId].optionId)} />
                                <div className="divider"></div>
                            </div>
                        );
                    })}

                </div>


                {/* 
<div key={survey.questionId}>

                            <RadioButtonsGroup
                                questionId={survey.questionId}
                                question={survey.question}
                                answer1={survey.optionDTOList.length > 0 ? survey.optionDTOList[0].valorOption : ''}
                                color1={survey.optionDTOList.length > 0 ? survey.optionDTOList[0].color : ''}
                                answer2={survey.optionDTOList.length > 0 ? survey.optionDTOList[1].valorOption : ''}
                                answer3={survey.optionDTOList.length > 0 ? survey.optionDTOList[2].valorOption : ''} />
                            <div className="divider"></div>
                        </div> */}
                {/* {questionData.map((questionData) => (
                        <div key={questionData.questionId}>
                            <RadioButtonsGroup questionId={questionData.questionId} question={questionData.question} answer1={questionData.answer1} answer2={questionData.answer2} answer3={questionData.answer3} />
                            <div className="divider"></div>
                        </div>
                    ))} */}
                {/* {mockData.map((dataItem) => (
                        <div key={dataItem.id}>
 
                            <RadioButtonsGroup questionId = {dataItem.question} question = {dataItem.question} answer1={dataItem.answer1} answer2={dataItem.answer2} answer3={dataItem.answer3} />
                            <div className="divider"></div>
                        </div>
                    ))} */}


                <p className='Title'>{LITERALS.p7} </p>
                <div className='container'>
                    <TextField id="input-comment"
                        placeholder='Write your comments, thoughts, suggestions, requests, petitions...'
                        variant='outlined'
                        className='input'
                        label='I would like to tell you about...' />
                </div>
                <div>
                    <CustomButton color={'blue'} description={"Submit"} path={"/Thanks"} actionButton={(event) => handleSubmit(event as any)} />
                </div>
            </div>
        </form >
    )
};