import { Route, Routes } from 'react-router-dom';
import Landing_page from '../Pages/landing_page/landing.container'
import Thanks_page from '../Pages/thanks_page/thanks.container'
import React from 'react';

function RoutesProvider() {

    return (
        <Routes>
            <Route path='/' element={<Landing_page />} />
            <Route path='/Thanks' element={<Thanks_page />} />
        </Routes>
    )
}
export default RoutesProvider;