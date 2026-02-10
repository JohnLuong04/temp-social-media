import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import "./Signup.css"

export default function SignupPage(){

    const [newUserData, setUserData] = useState({
        username: "",
        password: "",
        confirm_password: ""
    })

    function post_function(){
        const sendmessage = async () => {
            try{
                const response = await fetch('http://localhost:8080/user/text', {
                    method: 'POST', //What Method
                    headers: {
                        'Content-Type': 'application/json' //What Content Type
                    },
                    body: JSON.stringify({message: "data"}) //What are we sending
                });
                const data = await response.text(); // Server response await is need for time
                console.log(data)
            } catch(error) {
                console.log('Error:',  error) //Error case nothing important
            }
        }
        sendmessage();
    }

    async function handleSubmit(e){
        e.preventDefault()
        if(newUserData.password !== newUserData.confirm_password){
            console.log("Password does not match")
            return
        }
        //Check if user exist by checking the database
        console.log(newUserData.username);
        console.log(newUserData.password);
        post_function();
    }

    function handleChange(e){
        setUserData(prev => ({
            ...prev,
            [e.target.name]: e.target.value
        }));
    }

    return (
        <form className="signup-form" onSubmit={handleSubmit}>
            <h1>Signup Here</h1>
            <input
                type={"text"}
                placeholder={"Username"}
                name={"username"}
                value={newUserData.username}
                onChange={handleChange}
                required={true}
            />
            <input
                type={"text"}
                placeholder={"Password"}
                name={"password"}
                value={newUserData.password}
                onChange={handleChange}
                required={true}
            />
            <input
                type={"text"}
                placeholder={"confirm_password"}
                name={"confirm_password"}
                value={newUserData.confirm_password}
                onChange={handleChange}
                required={true}
            />
            <button className={"create-button"}>Create Account</button>
        </form>
    )
}