import React, { useEffect, useState } from 'react';
import Students from './components/Students';
import './App.scss';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Students />
      </header>
    </div>
  );
}

export default App;
