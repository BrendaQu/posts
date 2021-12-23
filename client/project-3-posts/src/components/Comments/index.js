import Comment from './CommentItem';
import AddComment from './AddComment';

import { useState, useEffect } from 'react';
import axios from 'axios';

/*
    Example:
    <Comments post = {post}/>
*/
const Comments = (props) => {

    // all of the comments for this post:
    const [comments, setComments] = useState([]);

    useEffect(() => {
        // fetch comments for this post from the database
        axios.get(`http://localhost:11001/comments/${props.post.id}`)
        // update state:
        .then(response => setComments(response.data))
        .catch(err => console.error(err))
    }, [])
    
    return (
        <div>
            {comments.map(comment => <Comment comment={comment} comments = {comments} setComments = {setComments} key={comment.id}/>)}
            <AddComment postId = {props.post.id} comments = {comments} setComments = {setComments}/>
        </div>
    )
}

export default Comments;
