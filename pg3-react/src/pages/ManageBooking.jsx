import BookingForm from "../forms/BookingForm";
import DisplayBookings from "../forms/DisplayBookings";


const Managebooking = () => {


    return(
        <>
        <div className="manage-booking">

        <p className="formtitle">Book A Viewing</p>
        <br />
        <BookingForm />       
        </div>

        <div>
            <DisplayBookings />
        </div>
        </>
    );
}

export default Managebooking;