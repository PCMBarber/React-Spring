import { useState } from 'react';

const BuyerForm = () => {
    const [first, setFirst] = useState('');
    const [last, setLast] = useState('');

    const handlesubmit = (e) => {
        e.preventDefault();
        const buyer = { first, last }

        fetch('http://localhost:8001/buyers/create',
        {
            method: 'POST',
            headers: { "Content-Type" : "application/json" },
            body: JSON.stringify(buyer)
        })
        
        setFirst('');
        setLast('');
            
    }

    return (
        <div>
        <form onSubmit={handlesubmit} className= "buyerform">
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
            <div className='buyerbutton'>
            <button>Register</button>
            </div>

        </form>
        
        
        </div>

    )

    

    

}
export default BuyerForm;