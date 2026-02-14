import {useState} from "react";
import { useLocation } from "react-router-dom"

/*

    - Link to Profile (Show: Nickname or Description)
    - Create a Post
    - Showcase your post
    - Edit your Post

    Future:
    Use JSON Web Token to store local session data instead of server

*/

export default function Home(){
    const location = useLocation();
    const user = location.state?.userData;

    console.log(user);

    return (
        <main>

        <h1>Home</h1>
        <h2>{user?.username}</h2>

        </main>
    )
}