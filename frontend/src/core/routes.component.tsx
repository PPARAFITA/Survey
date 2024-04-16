import { Route, Routes } from 'react-router-dom';    

import React from 'react'; 
import { App } from '../pages/landing_page/landing_page.container';
import { Thanks } from '../pages/thanks_page/thanks.container';
import { FormMood } from '../pages/form_page/form.container';
import { Results } from '../pages/results_page/results.container';

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