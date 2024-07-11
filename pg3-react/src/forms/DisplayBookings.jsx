import React, { useEffect, useState } from 'react';
import Moment from 'react-moment';


const Displaybookings = () => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    const fetchBookingData = async () => {
      const response = await fetch('http://localhost:8001/bookings/getAll');
    // const response = await fetch('http://localhost:8000/bookings')
      const data = await response.json();
      setBookings(data);
    
    };

    fetchBookingData();
  }, [bookings]);
    
   
    return(
        <div>
            <table className="table-striped">
                <thead>
                    <tr>
                        <th>Property ID</th>
                        <th>Buyer ID</th>
                        <th>Date & Time</th>
                    </tr>
                </thead>
                <tbody>
                     {bookings.map(booking => (
                     <tr>
                        <td>{booking.propertyId}</td>
                        <td>{booking.buyerId}</td>
                        {/* <td>{booking.date}</td> */}
                        <td><Moment format="dddd, DD/MM/YYYY, h:mm a">{booking.date}</Moment></td>
                     </tr>
                     ))}
                </tbody>
            </table>
        </div>
    )
     
}
 
export default Displaybookings;