import * as React from "react";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import "./radio-button.styles.css";

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

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {

    const optionId = event.target.value;


    if (onOptionChange) {
      onOptionChange('', questionId, optionId, surveyId, '', event);
    }
  };
 


  return (

    <div className={'RadioButton'}>
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
