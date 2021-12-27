import React, { useState } from "react";

function LikeDislike() {

    const [postLikes, setPostLikes] = useState({
        numLikes: 100,
        disableLike: false,
        disableDislike: false,
    });

    function onClickHandler(event){
        if(event.target.value === "like" && !postLikes.disableDislike){
            setPostLikes({
                numLikes: (postLikes.numLikes + 1),
                disableLike: true,
            })
        }else if(event.target.value === "dislike" && !postLikes.disableLike){
            setPostLikes({
                numLikes: (postLikes.numLikes - 1),
                disableDislike: true,
            })
        }else if(event.target.value === "like" && postLikes.disableDislike){
            setPostLikes({
                numLikes: (postLikes.numLikes + 2),
                disableLike: true,
            })
        }else if(event.target.value === "dislike" && postLikes.disableLike){
            setPostLikes({
                numLikes: (postLikes.numLikes - 2),
                disableDislike: true,
            })
        }else if(event.target.value === "cancel" && postLikes.disableLike){
            setPostLikes({
                numLikes: (postLikes.numLikes - 1),
                disableLike: false,
            })
        }else if(event.target.value === "cancel" && postLikes.disableDislike){
            setPostLikes({
                numLikes: (postLikes.numLikes + 1),
                disableDislike: false,
            })
        }
    }

    const element = (<button onClick={onClickHandler} value="cancel">Remove Reaction</button>)

    return (
        <div>
            <button onClick={onClickHandler} value="like" disabled={postLikes.disableLike}>Like</button>
            {postLikes.disableDislike? element : ""}
            {postLikes.disableLike? element : ""}
            <button onClick={onClickHandler} value="dislike" disabled={postLikes.disableDislike}>Dislike</button><br/>
            <div>{postLikes.numLikes}</div>
        </div>
    )
}

export default LikeDislike
