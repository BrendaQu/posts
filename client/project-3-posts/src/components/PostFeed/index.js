import React from 'react'
import Post from './Post';

const PostFeed = () => {

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
            <div className="container d-flex justify-content-center">
                {postArray.length === 0 ? 

                    <h1> It's quiet in here. Make a post!</h1>
                    
                    :

                    postArray.map(post => {
                        return <Post data={post} />
                    })
                }
            </div>

        </>
    );

}

export default PostFeed;