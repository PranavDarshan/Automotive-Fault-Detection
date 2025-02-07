import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider } from './context/ThemeContext';
import { Sidebar } from './components/Sidebar';
import { Dashboard } from './pages/Dashboard';
import { Reports } from './pages/Reports';
import { Vehicless } from './pages/Vehicles';

function App() {
  return (
    <Router>
      <ThemeProvider>
        <div className="min-h-screen bg-gray-100 dark:bg-gray-900">
          <Sidebar />
          <div className="lg:ml-64">
            <Routes>
              <Route path="/" element={<Dashboard />} />
              <Route path="/reports" element={<Reports />} />
              <Route path="/vehicles" element={<Vehicless />} />
            </Routes>
          </div>
        </div>
      </ThemeProvider>
    </Router>
  );
}

export default App;