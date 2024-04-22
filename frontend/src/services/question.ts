import axios from 'axios';

const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);

 

export const getQuestions = (teamId: string) => {

    console.log(teamId)
    return axios.get(`/api/v1/thermometer/question/${teamId}`, {
        headers: {
            'Authorization': `Basic ${credentials}`
        }
    })

}
