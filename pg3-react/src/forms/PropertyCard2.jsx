import React from 'react';

const PropertyCard2 = ({ property }) => {
  return (
    <div className="filter-card">
      <img src={property.imageUrl} alt={`${property.location} property`} width={395} height={250}/>
      <p>Property Id: {property.propertyId}</p>
      <p>Type: {property.type}</p>
      <p>Bedrooms: {property.bedrooms}</p>
      <p>Bathrooms: {property.bathrooms}</p>
      <p>Location: {property.location}</p>
      <p>Price: £{property.price}</p>
    </div>
  );
};

export default PropertyCard2;