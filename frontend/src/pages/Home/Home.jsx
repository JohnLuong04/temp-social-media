import { useLocation } from "react-router-dom"
import { useState, useEffect } from "react";


/*
    - Link to Profile (Show: Nickname or Description)
    - Create a Post
    - Showcase your post
    - Edit your Post

    Future:
    Use JSON Web Token to store local session data instead of server

*/

function Post({ postData, handleChange, submitPost}){
    return (
        <div className = "post">
            <div className = "post-header">
                <label>Title</label>
                <input 
                    name = "title"
                    value = {postData.title}
                    onChange = {handleChange}
                    placeholder="Title"
                />
            </div>
            <div className = "post-content">
                <label>Content</label>
                <textarea
                        name = "content"
                        value = {postData.content}
                        onChange = {handleChange}
                        placeholder="What's on your mind?"
                />
            </div>
            <button className = "post-button"
                onClick = {submitPost}
            >Post</button>
        </div>
    )
}

function PostList({posts, fetchPosts}){

    useEffect(() => {
        fetchPosts();
    }, []);

    return (
        <div className = "post-list">
            <h2>Posts</h2>
            {posts.map((post, index) => (
                <div className = "post" key={index}>
                    <h3>{post.title}</h3>
                    <p>{post.content}</p>
                    <small>{post.username}</small>
                </div>
            ))}
        </div>
    )
}

export default function Home(){
    const location = useLocation();
    const user = location.state?.userData;

    const [postData, setPostData] = useState({
        title: "",
        content: ""
    });

    const [posts, setPosts] = useState([
        {
            username: "",
            title: "",
            content: "",
            postId: "",
            created_at: ""
        }
    ]);

   function handleChange(e) {
        const { name, value } = e.target;
        setPostData(prev => ({ ...prev, [name]: value }));
    }

    async function submitPost(){
        try{
                const response = await fetch('http://localhost:8080/post/create', {
                    method: 'POST',
                    headers:{
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({title: postData.title, content: postData.content, username: user.username})
                });
                const data = await response.text();
                if(!response.ok){
                    console.log("Failed to create post")
                    return;
                }
                console.log("Post created successfully:", data);
            }
            catch(error){
                console.log(error)
        }
    }

    /**
     * Might remove getAll to getSome because if were talking about scability imagine loading millions :skull:
     */
    async function fetchPosts(){
        try{
            const response = await fetch('http://localhost:8080/post/getAll');
            if(!response.ok){
                throw new Error('Failed to fetch getAll post');
            }
            const data = await response.json();
            setPosts(data);
        }catch(error){
            console.log(error)
        }
    }
     
    return (
        <main>

        <h1>Home</h1>
        <h2>{user?.username}</h2>
        <Post postData={postData} handleChange={handleChange} submitPost={submitPost} />
        <PostList posts={posts} fetchPosts={fetchPosts}/>
        </main>
    )
}