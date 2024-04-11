import { Route, Routes } from 'react-router-dom';    
import { Thanks } from '../Pages/thanks_page/thanks.container'
import { FormMood } from '../Pages/form_page/form.container'
import {Results} from '../Pages/results_page/results.container'
import React from 'react';
import App from '../App';

function RoutesProvider() {
  
    return (
        <Routes>
            <Route path='/' element={<App />} />
            <Route path='/Thanks' element={<Thanks />} />
            <Route path='/FormMood' element={<FormMood />} />
            <Route path='/Results' element={<Results/>}/>
        </Routes>
    )
}
export default RoutesProvider;