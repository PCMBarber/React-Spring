import SellerForm from "../forms/SellerForm";
import Displaysellers from "../forms/DisplaySellers";


const Manageseller = () => {


    return(
        <>
        <div className="reg-seller">

        <p className="formtitle">New Seller Registration</p>
        <br />
        <SellerForm />       
        </div>

        <div>
            <Displaysellers />
        </div>
        </>
    );
}



export default Manageseller;