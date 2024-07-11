import React, { useEffect, useState } from 'react';
import PropertyCard from './PropertyCard';

const Displayproperties = () => {

  const [properties, setProperties] = useState([]);

  useEffect(() => {
    const fetchPropertiesData = async () => {
      const response = await fetch('http://localhost:8001/properties/getAll');
      const data = await response.json();
      setProperties(data);
    
    };

    fetchPropertiesData();
  }, [properties]);  

     
    return(
        <div className="items-grid">
            {properties.map((item) => (
                <PropertyCard {...item}/> )  )}
        </div>
    )
     
}

export default Displayproperties;