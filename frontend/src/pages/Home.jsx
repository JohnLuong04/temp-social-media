import {useState} from "react";
import { useLocation } from "react-router-dom"

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