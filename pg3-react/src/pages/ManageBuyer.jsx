import DisplayBuyers from "../forms/DisplayBuyers";
import BuyerForm from "../forms/BuyerForm";

const Managebuyer = () => {


    return(
        <>
        <div className="reg-buyer">

        <p className="formtitle">New Buyer Registration</p>
        <br />
        <BuyerForm />       
        </div>

        <div>
            <DisplayBuyers />
        </div>
        </>
    );
}



export default Managebuyer;