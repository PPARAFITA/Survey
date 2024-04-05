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
    p7: 'Extra ball! Would you like to add something else?'
}


// Define un tipo para los datos de la encuesta
interface SurveyItem {
    questionId: string;
    question: string;
    optionDTOList: any[];
    surveyId: string;
}

interface Question {
    questionId: string;
    question: string;
    type: string;
    answer1: string;
    answer2: string;
    answer3: string;
}
 interface Answer {
    answerId: string;
    surveyId:   string;
    questionId: string;
    optionId:   string; 
}

interface FormData {
    answers: { [questionId: string]: Answer };
    comments: string;
}

export const FormMood = () => {

    const [allQuestionsAnswered, setAllQuestionsAnswered] = useState(false);
    const [selectedTeam, setSelectedTeam] = useState<string>('');


    const [formData, setFormData] = useState<FormData>({
        answers: {},
        comments: ''
    });

      const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleOptionChange = ( answerId : string, questionId: string, optionId: string, surveyId: string) => {

        const updatedAnswers: { [questionId: string]: Answer } = { ...formData.answers };
        const teamId = selectedTeam;

        updatedAnswers[questionId] = { answerId, questionId, optionId, surveyId };

        setFormData({
            ...formData,
            answers: updatedAnswers
        });
  
        getQuestions().then(response => {
            const questionsData = response.data;
            // Verificar si todas las preguntas han sido respondidas
            const allQuestionsAnswered = Object.keys(formData.answers).length + 1 === questionsData.length && selectedTeam !== '';
            setAllQuestionsAnswered(allQuestionsAnswered);
        }).catch(error => {
            console.error('Error fetching questions:', error);
        });
    };



    // Function Submit Form 
    function handleSubmit(event: FormEvent<HTMLFormElement>) {


        // event.preventDefault();  

        // Obtener las preguntas
        // getQuestions().then(response => {
        //     const questionsData = response.data; 
        //     // Verificar si no se han respondido todas las preguntas
        //     if (formData.answers.length === 0 || questionsData.length !== formData.answers.length) {
        //         setIsEmpty(true);  
        //     } else {
        //         // Todas las preguntas están respondidas, continuar con el envío del formulario
        //         console.log('Form submitted');
        //         setIsEmpty(false);  
        //         // Envío a Backend
        //     }
        // }).catch(error => {
        //     console.error('Error fetching questions:', error); 
        // });


        if (allQuestionsAnswered) {
            console.log('Form submitted');           
            // Envío a Backend
            const formDataToSend = {
                answers: formData.answers,
                comments: formData.comments
            };
    
            // Post
            fetch('http://localhost:8080/api/v1/thermometer/answer', {
                method: 'POST',
                headers: {
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

        } else {
            console.log('Not all questions answered');
        }



        // //  Funciona con Mockdata
        // const survey = getSurveyData(); 


        // // const question_length = survey.length();

        // // Verificar si hay datos en el formulario
        // if (formData.answers.length === 0 || getQuestions.length !== formData.answers.length) {
        //     setShowPopup(true);
        //     event.preventDefault();
        //     return;
        // }
        // else {
        //     console.log('Form submitted');

        // }


        // Obtener los datos del formulario 
        console.log(formData);

    };


    //  Funciona con getSurvey Mock
    // const survey = getSurveyData();
    // const [question, setQuestion] = React.useState('');
    // const [questionData, setQuestionsData] = React.useState<Question[]>([]);


    // React.useEffect(() => {
    //     getQuestions()
    //         .then(response => {
    //             console.log(response.data);
    //             // setQuestionsData(response.data);
    //         })
    //         .catch(error => {
    //             console.error('Error fetching data:', error);
    //         });
    // }, []);

    // Funciona con getSurvey Backend 
    // const questions = getQuestions();

    // const surveyb = getSurvey();

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

console.log(questionOptions[0].surveyId);

                {/* Funciona con getSurvey Backend */}
                <div className="item-container">
                    {surveyData.map((surveyItem) => {
                        const questionOptions = surveyItem.optionDTOList.filter(option => option.questionId === surveyItem.questionId);
                        if (questionOptions.length > 0) {
                            console.log("TESTTESTESTES")
                            console.log(questionOptions[0].surveyId);
                        return (
                            <div key={surveyItem.questionId}>
                                <RadioButtonsGroup
                                    questionId={surveyItem.questionId}
                                    question={surveyItem.question}
                                    surveyId={questionOptions[0].surveyId}
                                    options={questionOptions}
                                    onOptionChange={handleOptionChange}
                                />
                                <Divider className='divider'></Divider>
                            </div>
                        );}
                    })}

                </div>



                {/* Funciona con getSurvey mockdata */}

                {/* <div className="item-container">
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
               */}
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
                    <CustomButton color={'blue'} description={"Submit"} path={"/Thanks"} actionButton={(event) => handleSubmit(event as any)} isDisabled={!allQuestionsAnswered} />
                </div>
            </div>
        </form >
    )
};