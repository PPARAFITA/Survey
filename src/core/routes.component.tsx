import { Route, Routes } from 'react-router-dom';
import  { App } from '../Pages/landing_page/landing.container'
import Thanks_page from '../Pages/thanks_page/thanks.container'
import { FormMood } from '../Pages/form_page/form.container'
import React from 'react';

function RoutesProvider() {

    return (
        <Routes>
            <Route path='/' element={<App />} />
            <Route path='/Thanks' element={<Thanks_page />} />
            <Route path='/FormMood' element={<FormMood />} />
        </Routes>
    )
}
export default RoutesProvider;