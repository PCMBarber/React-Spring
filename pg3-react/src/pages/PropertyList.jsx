import React from 'react';
import PropertyCard2 from '../forms/PropertyCard2';

const PropertyList = ({ properties }) => {
  return (
    <div className="prop-list">
      {properties.length > 0 ? (
        properties.map(property => (
          <PropertyCard2 key={property.id} property={property} />
        ))
      ) : (
        <p>No properties found</p>
      )}
    </div>
  );
};

export default PropertyList;