import React from 'react'; 
import { Route, Routes } from 'react-router-dom';   
import { App } from '../pages/landing/landing_page_container' 
import {Results} from '../pages/results_page/results.container'
import { Thanks } from '../pages/thanks/thanks.container';
import { FormMood } from '../pages/form_page/form.container'; 

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