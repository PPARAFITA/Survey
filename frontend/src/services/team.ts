import axios from 'axios';

const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);


export const getTeams = () => {
    return axios.get('/api/v1/thermometer/team', {
        headers: {
            'Authorization': `Basic ${credentials}`
        }
    })
    
    }
    
