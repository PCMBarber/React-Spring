import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Navbar from './components/NavBar';
import HomePage from './pages/HomePage';
import Managebooking from './pages/ManageBooking';
import Managebuyer from './pages/ManageBuyer';
import Manageproperties from './pages/ManageProperties';
import Manageseller from './pages/ManageSelller';
import SearchProperties from './pages/SearchProperties';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar />
      <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/manageseller" element={<Manageseller />} />
          <Route path="/managebuyer" element={<Managebuyer />} />
          <Route path="/manageproperties" element={<Manageproperties />} />
          <Route path="/searchproperties" element={<SearchProperties />} />
          <Route path="/managebooking" element={<Managebooking />} />
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
