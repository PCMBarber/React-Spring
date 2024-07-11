import React, { useEffect, useState } from 'react';

const Displaybuyers = () => {
  const [buyers, setBuyers] = useState([]);

  useEffect(() => {
    const fetchBuyerData = async () => {
      const response = await fetch('http://localhost:8001/buyers/getAll');
      const data = await response.json();
      setBuyers(data);
    
    };

    fetchBuyerData();
  }, [buyers]);
    
   
    return(
        <div>
            <table className="table-striped">
                <thead>
                    <tr>
                        <th>Buyer Id</th>
                        <th>First Name</th>
                        <th>Surname</th>
                    </tr>
                </thead>
                <tbody>
                     {buyers.map(buyer => (
                     <tr>
                        <td>{buyer.buyerId}</td>
                        <td>{buyer.first}</td>
                        <td>{buyer.last}</td>
                     </tr>
                     ))}
                </tbody>
            </table>
        </div>
    )
     
}
 
export default Displaybuyers;
 

 
