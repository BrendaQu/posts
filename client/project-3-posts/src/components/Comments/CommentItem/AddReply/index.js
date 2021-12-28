import { useState, useEffect } from "react";
import axios from "axios";


// form to add a reply to a comment:
const AddReply = (props) => {

    // reply value of input field:
    const [reply, setReply] = useState("");

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
        axios.post(`http://localhost:11001/comments/reply?postId=${props.postId}&parentId=${props.commentId}`, replyObject)
        .then(response => {
            console.log(response);
            setReply("");
            props.setReplies([...props.replies, response.data]);}
        )
        .catch(err => console.error(err))
    }
    
    return (
        <form onSubmit = {onSubmitHandler}>
            <input onChange = {onChangeHandler} value = {reply} placeholder="Reply"></input>
        </form>
    )
}

export default AddReply;