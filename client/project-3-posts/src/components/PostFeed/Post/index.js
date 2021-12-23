import React from 'react'

const Post = (props) => {


    let prettyDate = new Date(props.data.creationDate);
    return (
        <>
            <div className="wrapper text-center border border-4 shadow w-50">
                <h1>{props.data.title}</h1>
                <p>{props.data.description}</p>
                <p>By User No. {props.data.userId}</p>
                <p>On {(prettyDate.getMonth() + 1)}/{(prettyDate.getDate())}/{(prettyDate.getFullYear())} at {prettyDate.getHours()}:{(prettyDate.getMinutes() < 10) ? "0" + prettyDate.getMinutes() : prettyDate.getMinutes()}
                                {prettyDate.getHours() < 12 ? "am" : "pm"}</p>
                <p> Upmints: {props.data.upmints}</p>
                <p> Downmints: {props.data.downmints}</p>
            </div>
        </>
    );

}

export default Post;