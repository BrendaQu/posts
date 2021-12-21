import React from 'react'

const Post = (props) => {


    return (
        <>
            <div className="wrapper text-center border border-4 shadow w-50">
                <h1>{props.data.title}</h1>
                <p>{props.data.description}</p>
                <p>By {props.data.owner.name}</p>
            </div>
        </>
    );

}

export default Post;