import axios from "axios";

const Comment = (props) => {
    // delete comment from database:
    const deleteComment = () => {
        axios.delete(`http://localhost:11001/comments/${props.comment.id}`)
        // delete comment from state:
        .then(response => props.setComments(props.comments.filter(comment => comment.id !== props.comment.id)))
        .catch(error => console.error(error));
    }
    return (
        <div>
            {props.comment.description} by {props.comment.author}
            <button onClick = {deleteComment}>X</button>
        </div>
    )
}
export default Comment;