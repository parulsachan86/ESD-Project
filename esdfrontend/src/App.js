import logo from './logo.svg';
import './App.css';

import Login from './component/Login';
import Add from './component/AddData';

function App() {
  var user = JSON.parse(window.sessionStorage.getItem('user'))
  // console.log("App js",user)
  return (

    <>
    {
      (user!==null) && (
        <div className='d-flex justify-content-end'>
          <button className='btn btn-danger'
          onClick={()=>{
            window.sessionStorage.removeItem('user')
            window.location.reload(true)
    }}>Logout</button>
        </div>
      )
    }
    
    {
      (user===null) && (
        <>
        <div className="col-6 offset-3">
        
        <h3 className='heading'>Employee login Page </h3>
        </div>
        <Login/>
        
        </>
      )
    }
    {
      (user!==null) && (
        <>
          <Add />
        </>
      )
    }
    </>

  );
}

export default App;
