import React, { useState, type FormEvent } from 'react';
import '../../App.css';
import SelectList from '../../common/components/molecules/list.component';
import RadioButtonUnchecked from '@mui/icons-material/RadioButtonUnchecked';
import { CustomButton, RadioButtonsGroup } from '../../common';
import './form.styles.css';
import TextField from '@mui/material/TextField';
import { getQuestions } from '../../services/question';
import Divider from '@mui/material/Divider';
 

import { getSurveyData } from '../../services/mocks/mockquestion'; //MOCKDATA
// import { getSurvey }  from '../../services/survey'; BACKEND
// import { getSurvey } from '../../services/survey';

const LITERALS = {
    header: 'Welcome to the Digital Hub Survey',
    p1: 'Feel free, the form is completely anonymous. Sorry, but all questions are mandatory  🤓.',
    p2: 'Select your team and Hey Ho, Let’s Go 🤟',
    p3: 'Feelings traffic lights',
    p4: 'Doesn’t mean Perfect. It just means the squad is happy with this, and see no major need for improvement right now.',
    p5: 'Means there are some important problems that need addressing, but it’s not a disaster.',
    p6: ' Means this really sucks and needs to be improved. ',
    p7: 'Extra ball! Would you like to add something else?',
    p8: 'Close',
    p9: 'Please complete the survey before submitting it'
}


// Define un tipo para los datos de la encuesta
// interface SurveyItem {
//     questionId: number;
//     question: string;
//     optionDTOList: any[];   
// }

// interface Question {
//     questionId: string;
//     question: string;
//     type: string;
//     answer1: string;
//     answer2: string;
//     answer3: string;
// }


interface FormData {
    answers: { questionId: number; optionId: number; surveyId: number }[];
    comments: string
}

export const FormMood = () => {

    const [showPopup, setShowPopup] = useState(false);


    const [formData, setFormData] = useState<FormData>({
        // answers: [] as { questionId: number; optionId: number }[] ;
        answers: [],
        comments: ''
    });
    console.log(formData);


    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleOptionChange = (questionId: number, optionId: number, surveyId: number) => {
        setFormData({
            ...formData,
            answers: [
                ...formData.answers,
                { questionId, optionId, surveyId }
            ]
        });
    };



    // Function Submit Form 
    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        

    //  Funciona con getSurvey Backend 
    const survey = getSurveyData();

   // const question_length = survey.length();

        // Verificar si hay datos en el formulario
        if (formData.answers.length === 0 || survey.length !== formData.answers.length ) {
            setShowPopup(true);
            event.preventDefault();
            return; 
        }
        else {
            console.log('Form submitted');
        }


        // Obtener los datos del formulario 
        console.log(formData);

    };


    //  Funciona con getSurvey Backend 
    const survey = getSurveyData();


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

    // Funciona con getSurvey Backend 
    // const questions = getQuestions();
    // const surveyb = getSurvey();
    // console.log("test");
    // console.log(surveyb);
    // const [surveyData, setSurveyData] = useState<SurveyItem[]>([]); 
    // React.useEffect(() => {
    //     const fetchSurveyData = async () => {
    //         try {
    //             const response = await getQuestions();
    //             setSurveyData(response.data);
    //         } catch (error) {
    //             console.error('Error fetching survey data:', error);
    //         }
    //     };

    //     fetchSurveyData();
    // }, []);

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



                {/* Funciona con getSurvey Backend */}
                {/* <div className="item-container">
                {surveyData.map((surveyItem) => {
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

                </div> */}



                {/* Funciona con getSurvey mockdata */}

                <div className="item-container">
                    {survey.map((surveyItem) => {
                        const questionOptions = surveyItem.optionDTOList.filter(option => option.questionId === surveyItem.questionId);

                        return (
                            <div key={surveyItem.questionId}>
                                <RadioButtonsGroup
                                    questionId={surveyItem.questionId}
                                    question={surveyItem.question}
                                    options={questionOptions}
                                    onOptionChange={(questionId, optionId) => handleOptionChange(questionId, optionId, surveyItem.optionDTOList[0].surveyId)} />
                                <Divider className='divider'></Divider>
                            </div>
                        );
                    })}

                </div>
              

                {/* 
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
                        name="comments"
                        placeholder='Write your comments, thoughts, suggestions, requests, petitions...'
                        variant='outlined'
                        className='input'
                        value={formData.comments}
                        onChange={handleInputChange}
                        label='I would like to tell you about...' />
                </div>
                <div>
                    <CustomButton color={'blue'} description={"Submit"} path={"/Thanks"} actionButton={(event) => handleSubmit(event as any)} />
                </div>
            </div>


            {showPopup && (
                <div className="popup">
                    <h2>ERROR!</h2>
                    <p id='h2'>{LITERALS.p9}</p>

                    <CustomButton color={'white'} description={LITERALS.p8} path={"/FormMood"}  actionButton ={() => setShowPopup(false)}/> 
                   
                </div>
            )}
        </form >
    )
};