import React, { useEffect, useState } from 'react';

const Displaysellers = () => {

  const [sellers, setSellers] = useState([]);

  useEffect(() => {
    const fetchSellerData = async () => {
      const response = await fetch('http://localhost:8001/sellers/getAll');
      const data = await response.json();
      setSellers(data);
    
    };

    fetchSellerData();
  }, [sellers]);  

     
    return(
        <div>
            <table className="table-striped">
                <thead>
                    <tr>
                        <th>Seller Id</th>
                        <th>First Name</th>
                        <th>Surname</th>
                    </tr>
                </thead>
                <tbody>
                    
                     {sellers.map(seller => (
                     <tr>
                        <td>{seller.sellerId}</td>
                        <td>{seller.first}</td>
                        <td>{seller.last}</td>
                     </tr>
                     ))}
                </tbody>
            </table>
        </div>
    )
     
}
 
export default Displaysellers;