const surveyData = [
    {
      "questionId": 0,
      "question": "Delivering Value",
      "questionType": "traffic_light",
      "optionDTOList": [
        {
          "optionId": 1,
          "surveyId": 1,
          "questionId": 0,
          "valorOption": "We deliver great stuff! We're proud of it and our stakeholders are really happy.",
          "color": "green"
        },
        {
          "optionId": 2,
          "surveyId": 1,
          "questionId": 0,
          "valorOption": "Neutral",
          "color": "orange"
        },
        {
          "optionId": 3,
          "surveyId": 1,
          "questionId": 0,
          "valorOption": "We deliver crap. We feel ashamed to deliver it. Our stakeholders hate us.",
          "color": "red"
        }
      ]
    },
    {
      "questionId": 1,
      "question": "Easy to release",
      "questionType": "trafiic_light",
      "optionDTOList": [
        {
          "optionId": 4,
          "surveyId": 1,
          "questionId": 1, 
          "valorOption": "Releasing is simple, safe, painless and mostly automated.",
          "color": "green"
        },
        {
          "optionId": 5,
          "surveyId": 1,
          "questionId": 1,
          "valorOption": "Neutral",
          "color": "orange"
        },
        {
          "optionId": 6,
          "surveyId": 1,
          "questionId": 1,
          "valorOption": "Releasing is risky, painful, lots of manual work and takes forever.",
          "color": "red"
        }
      ]
    },
    {
      "questionId": 2,
      "question": "Team",
      "questionType": "traffic_light",
      "optionDTOList": [
        {
            "optionId": 7,
            "surveyId": 1,
            "questionId": 2, 
            "valorOption": "Releasing is simple, safe, painless and mostly automated.",
            "color": "green"
          },
          {
            "optionId": 8,
            "surveyId": 1,
            "questionId": 2,
            "valorOption": "Neutral",
            "color": "orange"
          },
          {
            "optionId": 9,
            "surveyId": 1,
            "questionId": 2,
            "valorOption": "Releasing is risky, painful, lots of manual work and takes forever.",
            "color": "red"
          }
      ]
    }
  ];

  export const getSurveyData = () => {
     
    return surveyData;
  }