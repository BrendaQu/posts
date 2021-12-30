import axios from 'axios';
import React, {useEffect, useState} from 'react';
import Posts from './Post';

const URL_FOR_POSTS = 'http://localhost:11001/postfeed/usersearch/';

async function retrievePostsByUser(userId){
    return axios.get(URL_FOR_POSTS+userId)
    .then(response => response.data)
    .catch(error => console.error(error))
}

const Feed = () => {

    const [postsToRender, setPostsToRender] = useState([]);

    const getPostsForUser = async (e) => {
        e.preventDefault();
        let postsRetrieved = await retrievePostsByUser(1);
        console.log("********s")
        console.log(postsRetrieved)
        setPostsToRender(postsRetrieved);
    }

    return(
        <div>
            <button className="btn btn-block" onClick={getPostsForUser}>Click to retrieve the posts</button>
            {
                postsToRender.map(post => <Posts data={post} />)
            }
        </div>
    )

    
    
}

export default Feed;