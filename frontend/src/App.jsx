import {createBrowserRouter, RouterProvider} from 'react-router-dom'
import LandingPage from "./pages/LandingPage/LandingPage.jsx";
import Home from "./pages/Home/Home.jsx";
import SignupPage from "./pages/Signup/Signup.jsx";

export default function App() {

    const router = createBrowserRouter([
        {path: '/', element: <Home />},
        {path: '/home', element: <Home />},
        {path: '/sign-up', element: <SignupPage/>}
    ])

    return <RouterProvider router={router}/>
}