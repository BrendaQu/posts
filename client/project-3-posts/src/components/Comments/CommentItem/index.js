import axios from "axios";
import styles from './style.module.css';
import {useState, useEffect} from 'react';

const Comment = (props) => {

    // reply value of input field:
    const [reply, setReply] = useState("");
    // all current replies to this field:
    const [replies, setReplies] = useState([]);

    // update the reply value:
    const onChangeHandler = (e) => {
        setReply(e.target.value);
    }

    // send reply to database:
    const onSubmitHandler = (e) => {
        e.preventDefault();
        // don't send empty reply
        if (reply === "") {
            return;
        }
        // TODO: GET THIS NAME FROM THE USER
        var author = "Replier"
        var replyObject = {
            description: reply,
            date: Date.now(),
            author: author,
        }
        // send this reply to the server
        axios.post(`http://localhost:11001/comments/reply?postId=${props.postId}&parentId=${props.comment.id}`, replyObject)
        .then(response => {
            console.log(response);
            setReply("");
            setReplies([...replies, response.data]);}
        )
        .catch(err => console.error(err))
    }

    // delete comment from database:
    const deleteComment = () => {
        axios.delete(`http://localhost:11001/comments/${props.comment.id}`)
        // delete comment from state:
        .then(response => {
            props.setComments(props.comments.map(comment => {
                if (comment.id === props.comment.id) {
                    return response.data;
                }
                return comment;
            }))
        })
        .catch(error => console.error(error));
    }

    // get replies for this comment:
    useEffect(() => {
        console.log("here");
        // fetch comments for this post from the database
        axios.get(`http://localhost:11001/comments/reply/${props.comment.id}`)
        // update state:
        .then(response => setReplies(response.data))
        .catch(err => console.error(err))
    }, [])

    return (
        <div className = {styles.comment}>
            {props.comment.description} by {props.comment.author}
            <button onClick = {deleteComment}>X</button>
            <br/>
            <form onSubmit = {onSubmitHandler}>
                <input onChange = {onChangeHandler} value = {reply} placeholder="Reply"></input>
            </form>
            {replies.map(reply => 
                <div className = "row">
                    <div className = "col-1"></div>
                    <div className = "col-11">
                        <Comment postId = {props.postId} comment={reply} comments = {replies} setComments = {setReplies} key={reply.id}/>
                    </div>
                </div>
            )}
        </div>
    )
}
export default Comment;