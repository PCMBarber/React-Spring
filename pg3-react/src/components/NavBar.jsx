import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className= "Navbar">    
      <h1>WE-SELL-ANY-HOUSE Estate Agents</h1>      
      <ul>
        <li className= "Navbar1">
          <Link to="/">Home</Link>
        </li>
        <li className= "Navbar1">
          <Link to="/manageseller">Manage Seller</Link>
        </li>
        <li className= "Navbar1">
          <Link to="/managebuyer">Manage Buyer</Link>
        </li>
        <li className= "Navbar1">
          <Link to="/manageproperties">Manage Properties</Link>
        </li>
        <li className= "Navbar1">
          <Link to="/searchproperties">Search Properties</Link>
        </li>
        <li className= "Navbar1">
          <Link to="/managebooking">Manage Bookings</Link>
        </li>
      </ul>
      </nav>    
  );
}

export default Navbar;
