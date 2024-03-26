import * as React from "react";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import "./radio-button.styles.css";
import { SelectChangeEvent } from '@mui/material';
import axios from 'axios';

interface OptionDTO {
  optionId: number;
  surveyId: number;
  questionId: number;
  valorOption: string;
  color: string;
}

interface Props {
  questionId: number;
  question: string;
  options: OptionDTO[];
  onOptionChange: (questionId: number, optionId: number) => void;
  // answer1: string;
  // color1: string;
  // answer2: string;
  // answer3: string;
}

interface Question {
  answers: any;
  questionId: string;
  optionId:string;
  question: string;
  type: string;
}


export const RadioButtonsGroup: React.FC<Props> = ({
  questionId,
  question,
  options,
  onOptionChange
  // answer1,
  // color1,
  // answer2,
  // answer3,
}): React.JSX.Element => {


  // const username = 'user';
  // const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
  // const credentials = btoa(`${username}:${password}`);

  let [question1, setQuestion] = React.useState('');
  const [questionsData, setQuestionsData] = React.useState<Question[]>([]);

  // React.useEffect(() => {
  //     axios.get('/api/v1/thermometer/question', {
  //         headers: {
  //             'Authorization': `Basic ${credentials}`
  //         }
  //     })
  //         .then(response => {
  //             console.log(response.data);
  //             setQuestionsData(response.data);
  //         })
  //         .catch(error => {
  //             console.error('Error fetching data:', error);
  //         });
  // }, []);

  const handleChange = (event: SelectChangeEvent) => {

     
      // Cuando se cambia la opción, llama a la función onOptionChange y pasa la opción seleccionada
      const optionId = parseInt(event.target.value); // Convierte el valor de cadena a número
        // Cuando se cambia la opción, llama a la función onOptionChange y pasa el questionId y el optionId
        onOptionChange(questionId, optionId);
 

    // const selectedAnswer = event.target.value;
    const selectedQuestion = questionsData.find(question => question.question === question1);
    // const selectedAnswer = questionsData.find(options =>  === question1);
    // console.log(color1);
    // if (selectedQuestion) {
    // const selectedAnswerId = selectedQuestion.answers.find((answer: { answer: string; }) => answer.answer === selectedAnswer)?.answer_id;
    // console.log("Selected question ID:", selectedQuestion.questionId);
    // console.log("Selected answer ID:", selectedAnswer);
    console.log("Selected question ID:", questionId);
    console.log("Selected question ID:", optionId);
    // Aquí puedes hacer lo que necesites con los IDs recuperados
    // }
  };
  return (

    <div className="RadioButton">
      <div className="question">
        {question}
        <RadioGroup
          aria-labelledby="radio-buttons-group-label"
          name="radio-buttons-group"
          onChange={handleChange}
        >
          {options.map(option => (
            <FormControlLabel
              key={option.optionId}
              className='RadioButton1'
              value={option.valorOption}
              control={<Radio style={{ color: option.color }} />}
              label={option.valorOption}
            />
          ))}
        </RadioGroup>
      </div>
    </div>

    // <div className="RadioButton">
    //   <div className="question">
    //     {question}
    //     <RadioGroup
    //       aria-labelledby="radio-buttons-group-label"
    //       name="radio-buttons-group"
    //       onChange={handleChange}
    //     >
    //       <div className="answer">
    //         {/* <FormControlLabel
    //           className='RadioButton1' value={'green'} 
    //           control={<Radio className="GreenButton" />}
    //           label={answer1}
    //         /> */}
    //         <FormControlLabel
    //           className='RadioButton1' value={'green'}
    //           control={<Radio style={{ color: color1 }} />}
    //           label={answer1}
    //         />
    //         <FormControlLabel
    //           className='RadioButton1' value={'orange'}
    //           control={<Radio className="OrangeButton" />}
    //           label={answer2}
    //         />
    //         <FormControlLabel
    //           className='RadioButton1' value={'red'}
    //           control={<Radio className="RedButton" />}
    //           label={answer3}
    //         />
    //       </div>
    //     </RadioGroup>
    //   </div>
    // </div>
  );
};
