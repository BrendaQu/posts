import axios from 'axios';
import React, { useState, useEffect } from 'react'
import Post from './Post';

const PostFeed = () => {

    const [posts, setPosts] = useState([]);
    const [searchText, setSearchText] = useState("");

    useEffect(() => {

        axios.get("http://localhost:11001/postfeed")
            .then((response) => {
                setPosts(response.data); //Set the posts array to the filtered content
            })
            .catch((error) => {
                console.error(error); //Print error to console
            })
    }, [])


    const sortByTimeOldFirst = () => {

        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if(post1.creationDate < post2.creationDate){
                return -1; //post1 should be second
            }
            else if(post1.creationDate > post2.creationDate){
                return 1; //post1 should be first
            }
            else{
                return 0; //Are the same
            }
        });
        setPosts(sortedPosts);
    }

    const sortByTimeNewFirst = () => { //METHOD FOR SORTING POSTS BY CREATION DATE, NEWEST FIRST

        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if(post1.creationDate < post2.creationDate){
                return 1; //post1 should be first
            }
            else if(post1.creationDate > post2.creationDate){
                return -1; //post1 should be second
            }
            else{
                return 0; //Are the same
            }
        });  
        setPosts(sortedPosts);
    }

    const searchChangeHandler = (event) => { //For posts search bar
        const { name, value } = event.target;
        setSearchText(value);
    }
    const searchSubmitHandler = (event) => { //Change the posts array

        event.preventDefault(); //No page refresh
        axios.get(`http://localhost:11001/postfeed/textsearch/${searchText}`)
        .then((response) => {
            setPosts(response.data); //Set the state to this new array (unsorted)
        })
        .catch((error) => {
            console.error(error)
        });
    }
    ////////////////////// MAKING FAKE POSTS AND USERS FOR TESTING
    let owner1 = {
        id: 1,
        name: "Peter Lankton",
        email: "p.lankton@gmail.com"
    }
    let post1 = {
        id: 101,
        title: "Chum Bucket Advertisement",
        description: "This restaurant is simply the best.",
        owner: owner1
    }

    let owner2 = {
        id: 2,
        name: "Eugene Krabs",
        email: "krabs@gmail.com"
    }
    let post2 = {
        id: 102,
        title: "Krusty Krab 2 Advertisement",
        description: "Hello! I like money!",
        owner: owner2
    }

    let owner3 = {
        id: 3,
        name: "Spongebob Squarepants",
        email: "square@gmail.com"
    }
    let post3 = {
        id: 103,
        title: "Krusty Krab Appreciation Post",
        description: "The Krusty Krab is the bestest place to work!",
        owner: owner3
    }

    let postArray = [post1, post2, post3];
    /////////////////////////////////////

    return (
        <>
        <form className="text-center mb-4" onSubmit={searchSubmitHandler}>
                <input className="w-50" type="text" onChange={searchChangeHandler} placeholder="Search for a post..." name="searchbar" />
                <button type="submit">Go!</button>
                
            </form>
        <button onClick={sortByTimeOldFirst}>Sort By Oldest</button>
        <button onClick={sortByTimeNewFirst}>Sort By Newest</button>
            <div className="container d-flex justify-content-center">
                
                {posts.length === 0 ?

                    <h1> It's quiet in here. Make a post!</h1>

                    :
                    <ol>
                        {
                            posts.map(post => {
                                return <li key={post.id}><Post data={post} /></li>
                            })
                        }
                    </ol>

                }
            </div>

        </>
    );

}

export default PostFeed;