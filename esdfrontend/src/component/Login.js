import { useEffect, useState } from "react"
import axios from 'axios'
import swal from 'sweetalert'

function Login () {

    const [email, setEmail] = useState('')
    const [password,setPassword] = useState('')

    // console.log(email)

    const handleLogin = async(e) => {
        e.preventDefault()

        await axios.post('http://localhost:8080/api/employee/login',{
            email:email,
            password:password
        })
        .then((response)=>{
            console.log(response.data)
            window.sessionStorage.setItem('user', JSON.stringify(response.data))
            window.location.reload(true)
        })
        .catch((error)=>{
            console.log(error)
            swal("Login Failed", "Check email or password!","error")
        })

        setEmail('')
        setPassword('')
    }

    return(
        <>
        <div className="col-6 offset-3">
        <form>
            {/* <!-- Email input --> */}
            <div className="form-outline mb-4">
                <input type="email" id="form1Example1" className="form-control" 
                onChange={(event)=>{
                    setEmail(event.target.value)
                }}
                />
                <label className="form-label" htmlFor="form1Example1"><h6>Email address</h6></label>
            </div>

            {/* <!-- Password input --> */}
            <div className="form-outline mb-4">
                <input type="password" id="form1Example2" className="form-control" 
                onChange={(event)=>{
                    setPassword(event.target.value)
                }}
                />
                <label className="form-label" htmlFor="form1Example2"><h6>Password</h6></label>
            </div>

            {/* <!-- Submit button --> */}
            <button type="submit" className="btn btn-primary btn-block"
            onClick={handleLogin}
            >Sign in</button>
        </form>
        </div>
        </>
    )
}

export default Login