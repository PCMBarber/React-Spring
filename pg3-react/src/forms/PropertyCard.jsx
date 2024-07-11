
import React, { useState } from "react";


const PropertyCard = ({ location, bedrooms, bathrooms, type, price, imageUrl }) => {

  let [isButtonPressed, setButtonName] = useState ("Withdraw property")
  let [isPropertyPressed, setPropertyName] = useState ("For Sale")

  const addCart = () => {
    setButtonName(isButtonPressed === "Withdraw property" ? "For Sale" : "Withdraw property" )
    setPropertyName(isPropertyPressed === "For Sale" ? "Withdrawn" : "For Sale")
  }

  return (
    <div className="wrapper">
      <img src={imageUrl} width={395} height={250} alt= "property image" />
      <p className="type">Type: {type}</p>
      <p className="bedrooms">Bedrooms: {bedrooms}</p>
      <p className="bathrooms">Bathrooms: {bathrooms}</p>      
      <p className="location">Location: {location}</p>
      <p className="price">Price: £{price.toLocaleString()}</p>
      <p className="Propstatus">Property Status: {isPropertyPressed}</p>
      <button classname="add-cart-button" onClick={addCart}>
        {isButtonPressed}
      </button>
    </div>
  );
}

export default PropertyCard;