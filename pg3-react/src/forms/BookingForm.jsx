import { useState } from 'react';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import moment from 'moment-timezone';




const BookingForm = () => {
    const [propertyId, setPropertyId] = useState('');
    const [buyerId, setBuyerId] = useState('');
    const [date, setDate] = useState('');

   
    const handleDateChange = (selectedDate) => {
        // Convert the selected date to GMT
        const gmtDate = moment(selectedDate).tz('Etc/GMT').toDate();
        setDate(gmtDate);
    };
    

    const handlesubmit = (e) => {
        e.preventDefault();
        const booking = { propertyId, buyerId, date}

        fetch('http://localhost:8001/bookings/create',
        // fetch('http://localhost:8000/bookings',
        {
            method: 'POST',
            headers: { "Content-Type" : "application/json" },
            body: JSON.stringify(booking)
        })
        
        setPropertyId('');
        setBuyerId('');
        setDate('');
        
        
    }

    return (
        <div>
        <form onSubmit={handlesubmit} className= "bookingform">
            <label>Property ID: </label>
            <input type="text"
            required value={propertyId}
            onChange={(e) => setPropertyId(e.target.value)} />

            <br /><br />

            <label>Buyer ID: </label>
            <input type="text"
            required value={buyerId}
            onChange={(e) => setBuyerId(e.target.value)} />

            <br /><br />

            <label>Date & Time: </label>
            
            <DatePicker 
            showTimeSelect
            minTime={new Date(0, 0, 0, 10, 0)}
            maxTime={new Date(0, 0, 0, 19, 0)}
            selected={date}
            // onChange={(date) => setDate(date)}
            onChange={handleDateChange}
            dateFormat="MMMM d, yyyy h:mmaa"/>
            

            <br /><br />
            <div className='bookingbutton'>
            <button>Book</button>
            </div>

        </form>
        
        
        </div>

    )

    

    

}
export default BookingForm;