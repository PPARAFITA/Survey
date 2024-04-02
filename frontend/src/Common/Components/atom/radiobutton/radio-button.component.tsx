import * as React from "react";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import "./radio-button.styles.css";
import { SelectChangeEvent } from '@mui/material';


// interface Question {
//   answers: any;
//   questionId: string;
//   optionId:string;
//   question: string;
//   type: string;
// }

//Propiedades de question
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
  onOptionChange: (questionId: number, optionId: number, surveyId:number ) => void;
}


export const RadioButtonsGroup: React.FC<Props> = ({
  questionId,
  question,
  options,
  onOptionChange
}): React.JSX.Element => {

  // let [question1, setQuestion] = React.useState('');
  // const [questionsData, setQuestionsData] = React.useState<Question[]>([]);

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

    // const optionId = parseInt(event.target.value); // Convierte el valor de cadena a número
    // onOptionChange(questionId, optionId);
    // console.log("Selected question ID:", questionId);
    // console.log("Selected question ID:", optionId);

    const optionValue = event.target.value;
    console.log("Option value:", optionValue); // Verifica el valor recibido

    const optionId = parseInt(optionValue);
    if (!isNaN(optionId)) {
        onOptionChange(questionId, optionId, options[questionId].surveyId);
        console.log("Selected question ID:", questionId);
        console.log("Selected option ID:", optionId);
        console.log("Survey ID:",options[questionId].surveyId)
    } else {
        console.error("Invalid option value:", optionValue);
    }

    // const selectedAnswer = event.target.value;
    // const selectedQuestion = questionsData.find(question => question.question === question1);
    // const selectedAnswer = questionsData.find(options =>  === question1);
    // console.log(color1);
    // if (selectedQuestion) {
    // const selectedAnswerId = selectedQuestion.answers.find((answer: { answer: string; }) => answer.answer === selectedAnswer)?.answer_id;
    // console.log("Selected question ID:", selectedQuestion.questionId);
    // console.log("Selected answer ID:", selectedAnswer);
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
              value={option.optionId}
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
