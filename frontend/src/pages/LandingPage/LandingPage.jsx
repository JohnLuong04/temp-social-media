import "./LandingPage.css"
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";

//Author: John Luong

export default function LandingPage(){
    const navigate = useNavigate();

    const [userData, setUserData] = useState({
        username: "",
        password: ""
    });

    function handleChange(e){
        setUserData(prev => ({
            ...prev,
            [e.target.name]: e.target.value
        }));
    }

    async function handleSubmit(e){
        e.preventDefault();
        // Do something for backend, delete console log
        console.log(userData);
        // should authenticate if user exists before navigating to home page
        // for now just checking if anything has been entered
        if(userData.username && userData.password){
            navigate("/home");
        }
    }

    // Replace h1 with actual app name
    // replace img with our own logo or something else
    return (
        <main className="landing-page">
            <section className="landing-page-left">
                <h1 className={"app-name-landing-page"}>Temp Social Media Name</h1>
                <img
                    className={"app-logo-landing-page"}
                    src={"/src/assets/react.svg"}
                    alt={"App Logo"}
                />
            </section>

            <section className="landing-page-right">
                <form className={"login-form"} onSubmit={handleSubmit}>
                    <input
                        type={"text"}
                        placeholder={"Username"}
                        aria-label={"Username field"}
                        name={"username"}
                        value={userData.username}
                        onChange={handleChange}
                        required={true}
                    />
                    <input
                        type={"password"}
                        placeholder={"Password"}
                        aria-label={"Password field"}
                        name={"password"}
                        value={userData.password}
                        onChange={handleChange}
                        required={true}
                    />
                    <button className={"login-button"}>Log in</button>
                </form>

                <p className={"sign-up-prompt"}>
                    Don't have an account?
                    <Link to={"/sign-up"} className={"sign-up-link"}> Create Account</Link>
                </p>
            </section>
        </main>
    )
}