import { Route, Routes } from 'react-router-dom';    
import { Thanks } from '../pages/thanks_page/thanks.container'
import { FormMood } from '../pages/form_page/form.container'
import { App } from '../pages/landing_page/landing.container' 
import {Results} from '../pages/results_page/results.container'
import React from 'react'; 

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