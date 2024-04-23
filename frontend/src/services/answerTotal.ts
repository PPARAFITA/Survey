import axios from 'axios';

const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);


interface Results {
    teamId: string;
    resultquestionId?: string | null;
}


export const getanswerTotal = (results: Results) => {

    const { teamId, resultquestionId } = results;
    return axios.get(`/api/v1/thermometer/answer/totalAnswerByYear?questionId=${resultquestionId}&teamId=${teamId}`, {
        headers: {
            'Authorization': `Basic ${credentials}`
        }});
};