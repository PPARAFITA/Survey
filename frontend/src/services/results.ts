import axios from 'axios';

const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);

interface Results {
    teamId: string;
    month?: boolean;
    selectedValue: string;
    kpi?: boolean;
    resultquestionId?: string | null;
}

export const getResultsb = (results: Results) => {
    const { teamId, month, kpi, selectedValue } = results;

    if (month) {
        return axios.get(`/api/v1/thermometer/resultMonth?month=${selectedValue}&teamId=${teamId}`, {
            headers: {
                'Authorization': `Basic ${credentials}`
            }
        })
    }
    else if (kpi) {
        return axios.get(`/api/v1/thermometer/resultKPI?questionId=${results.resultquestionId}&teamId=${teamId}`, {
            headers: {
                'Authorization': `Basic ${credentials}`
            }
        });
    } else {
        // En caso de que no se proporcione ni 'month' ni 'questionId'
        console.error('Se necesita proporcionar month o questionId en los resultados.');
        return null; // O podrías lanzar una excepción si prefieres.
    }
};



