import { useState } from "react";
import axios from "axios";

const AddComment = (props) => {

    const [comment, setComment] = useState('');

    // update the state with the comment that
    // we enter in the input box:
    const onChangeHandler = (event) => {
        setComment(event.target.value);
    }

    // when we submit, send the comment to the database:
    const onSubmitHandler = (event) => {
        event.preventDefault();
        if(comment == "") {
            return;
        }
        // TODO: get author's name from somewhere...
        var author = 'Anonymous';
        // send comment to the database
        axios.post(`http://localhost:11001/comments/${props.postId}`, {
            description: comment,
            author: author,
            date: Date.now()
        })
        // update the comments component:
        .then(response => props.setComments([...props.comments, response.data]))
        .catch(error => console.error(error));
        // reset the input field to be empty:
        setComment("");
    }

    return (
        <div>
            <form onSubmit = {onSubmitHandler}>
                <input type = 'text' value = {comment} onChange={onChangeHandler}/>
                <input type = 'submit' value = 'Add Comment'/>
            </form>
        </div>
    )
}

export default AddComment;