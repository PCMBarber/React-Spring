import { useState } from 'react';
import Displaysellers from './DisplaySellers';

const SellerForm = () => {
    const [first, setFirst] = useState('');
    const [last, setLast] = useState('');

    const handlesubmit = (e) => {
        e.preventDefault();
        const seller = { first, last }

        fetch('http://localhost:8001/sellers/create',
        {
            method: 'POST',
            headers: { "Content-Type" : "application/json" },
            body: JSON.stringify(seller)
        })
        
        setFirst('');
        setLast('');
            
    }

    return (
        <div>
        <form onSubmit={handlesubmit} className= "sellerform">
            <label>First Name: </label>
            <input type="text"
            required value={first}
            onChange={(e) => setFirst(e.target.value)} />

            <br /><br />

            <label>Surname: </label>
            <input type="text"
            required value={last}
            onChange={(e) => setLast(e.target.value)} />

            <br /><br />
            <div className='sellerbutton'>
            <button>Register</button>
            </div>

        </form>
        
        
        </div>

    )

    

    

}
export default SellerForm;