import { useState } from 'react';
import Displaysellers from './DisplaySellers';

const PropertyForm = () => {
    const [type, setType] = useState('');
    const [location, setLocation] = useState('');
    const [bedrooms, setBedrooms] = useState('');
    const [bathrooms, setBathrooms] = useState('');
    const [price, setPrice] = useState('');
    const [imageUrl, setImageUrl] = useState('https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg');

    const handlesubmit = (e) => {
        e.preventDefault();
        const property = { type, location, bedrooms, bathrooms, price, imageUrl }

        fetch('http://localhost:8001/properties/create',
        {
            method: 'POST',
            headers: { "Content-Type" : "application/json" },
            body: JSON.stringify(property)
        })
        
        setType('');
        setLocation('');
        setBedrooms('');
        setBathrooms('');
        setPrice('');
        
            
    }

    return (
        <div>
        <form onSubmit={handlesubmit} className= "sellerform">
            <label>Type: </label>
            <input type="text"
            required value={type}
            onChange={(e) => setType(e.target.value)} />

            {/* <br /><br /> */}

            <label>Location: </label>
            <input type="text"
            required value={location}
            onChange={(e) => setLocation(e.target.value)} />

            {/* <br /><br /> */}

            <label>Bedrooms: </label>
            <input type="text"
            required value={bedrooms}
            onChange={(e) => setBedrooms(e.target.value)} />

            <br /><br />

            <label>Bathrooms: </label>
            <input type="text"
            required value={bathrooms}
            onChange={(e) => setBathrooms(e.target.value)} />

            {/* <br /><br /> */}

            <label>Price: </label>
            <input type="number"
            required value={price}
            onChange={(e) => setPrice(e.target.value)} />

            {/* <br /><br /> */}

            <label>ImageUrl: </label>
            <input type="text"
            required value={imageUrl}
            onChange={(e) => setImageUrl(e.target.value)} />

            <br /><br />

            <div className='sellerbutton'>
            <button>Register</button>
            </div>

        </form>
        
        
        </div>

    )

    

    

}
export default PropertyForm;