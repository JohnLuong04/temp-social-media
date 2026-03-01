import {useNavigate} from "react-router-dom";
import {useState} from "react";
import "./Signup.css"


//Author: Jason Ha 

export default function SignupPage(){
    const navigate = useNavigate();

    const [newUserData, setUserData] = useState({
        username: "",
        password: "",
        confirm_password: ""
    })

    function post_function(){
        const sendmessage = async () => {
        try {
            const response = await fetch('http://localhost:8080/user/text', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    message: "data"
                })
            });

            const data = await response.text();
            console.log(data);

            } catch (error) {
                console.log('Error:', error);
            }
        };
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
        navigate("/home")

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
                aria-label={"Username field"}
                name={"username"}
                value={newUserData.username}
                onChange={handleChange}
                required={true}
            />
            <input
                type={"password"}
                placeholder={"Password"}
                aria-label={"Password field"}
                name={"password"}
                value={newUserData.password}
                onChange={handleChange}
                required={true}
            />
            <input
                type={"password"}
                placeholder={"confirm_password"}
                aria-label={"Password confirmation field"}
                name={"confirm_password"}
                value={newUserData.confirm_password}
                onChange={handleChange}
                required={true}
            />
            <button className={"create-button"}>Create Account</button>
        </form>
    )
}