import React, { useState, useEffect } from 'react';
import PropertySearch from './PropertySearch';
import PropertyList from './PropertyList';
import '../App.css'

const SearchProperties = () => {
  const [searchCriteria, setSearchCriteria] = useState({});
  const [filteredProperties, setFilteredProperties] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('http://localhost:8001/properties/getAll');
      const data = await response.json();
      setFilteredProperties(data);
    };

    fetchData();
  }, []);

  useEffect(() => {
    const fetchFilteredData = async () => {
      const response = await fetch('http://localhost:8001/properties/getAll');
      const data = await response.json();

      const filtered = data.filter(property => {
        const meetsPrice = searchCriteria.price ? property.price <= searchCriteria.price : true;
        const meetsBedrooms = searchCriteria.bedrooms ? property.bedrooms >= searchCriteria.bedrooms : true;
        const meetsBathrooms = searchCriteria.bathrooms ? property.bathrooms >= searchCriteria.bathrooms : true;
        const meetsGarden = searchCriteria.garden ? property.hasGarden === searchCriteria.garden : true;
        const meetsLocation = searchCriteria.location ? property.location == searchCriteria.location : true;
        return meetsPrice && meetsBedrooms && meetsBathrooms && meetsLocation && meetsGarden;
      });

      setFilteredProperties(filtered);
    };

    fetchFilteredData();
  }, [searchCriteria]);

  return (
    <div className="">
        {/* <h1 className="head-prop-search">Property Search</h1> */}
        <div className="mng-property">
          <p className="formtitle">Filter Property</p>
          <br />
            <PropertySearch setSearchCriteria={setSearchCriteria} />    
          </div>

      <PropertyList properties={filteredProperties} />
    </div>
  );
};

export default SearchProperties;

  
