import React from 'react';

const Comment = (props) => {
    return(
        <div>
            <h6>{props.data.author}</h6>
            <p>{props.data.description}</p>
        </div>
    )

}

export default Comment;