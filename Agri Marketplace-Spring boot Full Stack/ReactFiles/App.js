import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { FaQuestionCircle, FaPhone, FaInfoCircle } from 'react-icons/fa';
import CommodityPage from './CommodityPage';
import OfferPage from './OfferPage';
import InspectionReport from './InspectionReport';
import Appbar from './Appbar';
import './App.css'; // Importing the CSS file
import UsersPage from './UserPage';
import OrdersPage from './OrderPage';
import BuyerPage from './BuyerPage';
import UserDetails from './UserDetails';
import EditUser from './EditUser';

function App() {
  return (
    <Router>
      <div className="App">
        <Appbar />
        <div className="content">
          <Routes>
            
            <Route path="/" element={<Dashboard />} />
            <Route path="/commodities" element={<CommodityPage />} />
            <Route path="/offers" element={<OfferPage />} />
            <Route path="/inspection-report" element={<InspectionReport />} />
            <Route path="/users" element={<UsersPage/>} />
            <Route path="/orders" element={<OrdersPage/>} />
            <Route path="/users/:id" element={<UserDetails />} />
            <Route path="/users/:id" element={<UserDetails />} /> {/* Add this route */}
                <Route path="/edit-user/:id" element={<EditUser />} /> {/* Add EditUser route */}
               
            <Route path="/buyer" element={<BuyerPage/>} />
            <Route path="/help" element={<Help />} />
            <Route path="/contact-us" element={<ContactUs />} />
            <Route path="/about" element={<About />} />
          </Routes>
         
        </div>
        <footer className="app-footer">
          <div className="footer-icons">
            <Link to="/help" className="icon-link"><FaQuestionCircle size={30} /></Link>
            <Link to="/contact-us" className="icon-link"><FaPhone size={30} /></Link>
            <Link to="/about" className="icon-link"><FaInfoCircle size={30} /></Link>
          </div>
        </footer>
      </div>
    </Router>
  );
}

function Dashboard() {
  return (
    <div className="dashboard">
      <h2>Dashboard</h2>
      <nav>
        <ul>
          <li>
            <Link to="/commodities">Manage Commodities</Link>
          </li>
          <li>
            <Link to="/offers">Manage Offers</Link>
          </li>
          <li>
            <Link to="/inspection-report">Inspection Report</Link>
          </li>
          <li>
            <Link to="/users">Users</Link>
          </li>
          <li>
            <Link to="/users/:id">Payment</Link>
          </li>
          <li>
          <Link to="/orders">Orders</Link>
          </li>
          <li>
            <Link to="/buyer">Go to Buyer Page</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
}

function Help() {
  return (
    <div>
      <h2>Help</h2>
      <p>Here you can find help content...</p>
      <p ><br /><br /></p>

    </div>
  );
}

function ContactUs() {
  return (
    <div>
      <h2>Contact Us</h2>
      <p>Here you can find contact details...</p>
      <p >22I-2526 Waheed Gulzar<br />22I-2554 Tayyab Attiq<br />22I-2470 Ammad Ashraf</p>
    </div>
  );
}

function About() {
  return (
    <div>
      <h2>About Us</h2>
      <p>Here you can find information about us...</p>
      <p >22I-2526 Waheed Gulzar<br />22I-2554 Tayyab Attiq<br />22I-2470 Ammad Ashraf</p>


    </div>
  );
}

export default App;