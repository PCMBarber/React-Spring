// import sellersData from '../data/sellersData.json';
import React, { useEffect, useState } from 'react';

function PropertyFilter() {
  const [items, setItems] = useState([]);
  const [filter, setFilter] = useState('');
  const [locations, setLocations] = useState([]);

  useEffect(() => {
    // fetch('./sellersData.json')
    // fetch('../data/sellersData.json')
    fetch('http://localhost:8001/properties/getAll')
      .then(response => response.json())
      .then(data => {
        setItems(data);
        const uniqueLocations = [...new Set(data.map(item => item.location))];
        setLocations(uniqueLocations);
      })
  }, []);

  const handleFilterChange = (e) => {
    setFilter(e.target.value);
  };

  const filteredItems = items.filter(item =>
    filter === '' || item.location === filter
  );

  return (
    <div className="filterform">

      <h4>Search Properties</h4>

      <select value={filter} onChange={handleFilterChange}>
        <option value="">All Locations</option>
        {locations.map(location => (
          <option key={location} value={location}>{location}</option>
        ))}
      </select>

      <ul>
        {filteredItems.map(item => (
          <li key={item.id}>{item.location}</li>
        ))}
      </ul>

    </div>
  );
}

export default PropertyFilter;
