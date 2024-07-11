
import PropertyCard from "../forms/PropertyCard";
import PropertyForm from "../forms/PropertyForm";
import PropertyFilter from "../forms/PropertyFilter";
import sellersData from '../data/sellersData.json';
import '../App.css'
import Displayproperties from "../forms/DisplayProperties";



const ManageProperty =() => {
      return (
      <>
        <div className="mng-property">
        <p className="formtitle">New Property Registration</p>
        <br />
            <PropertyForm />       
        </div>
        
        <div  className="items-grid">
          <Displayproperties />
          {/* {
            sellersData.properties.map((item) => (
              <PropertyCard{...item}/>              

            ))
          } */}
        </div>
        </>
      
  
  );
  }

export default ManageProperty;