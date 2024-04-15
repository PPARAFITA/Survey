import axios from 'axios';

const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);

export const getQuestions = () => {
return axios.get('/api/v1/thermometer/question/c252189e-82af-48f3-aa40-188606a1a741', {
    headers: {
        'Authorization': `Basic ${credentials}`
    }
})

}
