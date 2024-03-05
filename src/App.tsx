import React from 'react';
import './App.css'; 
import RoutesProvider from './core/routes.component';
import * as molec from './common/components/molecules/index'; 


function App() {
  return (
    <div className="App">

      <molec.Header/> 

      <RoutesProvider />

      <molec.Footer/> 

    </div>
  );
}

export default App;
