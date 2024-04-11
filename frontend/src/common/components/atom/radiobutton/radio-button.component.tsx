import * as React from "react";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import "./radio-button.styles.css";

//Propiedades de question
interface OptionDTO {
  optionId: string;
  surveyId: string;
  questionId: string;
  valorOption: string;
  color: string;
}

interface Props {
  questionId: string;
  question: string;
  options: OptionDTO[];
  onOptionChange?: (answerID: string, questionId: string, optionId: string, surveyId: string, valor_answer: string, event: React.ChangeEvent<HTMLInputElement>) => void;
  surveyId: string;
}


export const RadioButtonsGroup: React.FC<Props> = ({
  questionId,
  question,
  options,
  surveyId,
  onOptionChange,
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

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {

    const optionId = event.target.value;
    console.log("Option value:", optionId);
    console.log("Question value:", questionId);


    // Comprobar que están informado antes de llamar  a handleOptionChange
    if (onOptionChange) {
      onOptionChange('', questionId, optionId, surveyId, '', event);
    }
  };


  // const optionId = parseInt(event.target.value); // Convierte el valor de cadena a número
  // onOptionChange(questionId, optionId);
  // console.log("Selected question ID:", questionId);
  // console.log("Selected question ID:", optionId);


  return (

    <div className="RadioButton">
      <div className="question">
        {question}
        <RadioGroup
          aria-labelledby="radio-buttons-group-label"
          name="radio-buttons-group"
          onChange={(event) => onOptionChange && onOptionChange('', questionId, event.target.value, surveyId, '', event)}
        >

          {options.map(option => (
            <FormControlLabel
              key={option.optionId}
              value={option.optionId}
              control={<Radio style={{ color: option.color }} />}
              label={option.valorOption}
            />
          ))}
        </RadioGroup>
      </div>
    </div>
  );
};
