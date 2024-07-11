import {Link} from 'react-router-dom'
import '../App.css'
import image1 from '../images/image1.png'

 
const HomePage = () => {
  return (
    <div>
      <div className='text'>
        <h1>Let us help you find the property of your dreams !!</h1>
        <p>We offer a range of properties to suit your needs</p>
        <br ></br>
         <img src={image1} alt="alt text"/>
         </div>
    </div>
  )
}
 
export default HomePage;