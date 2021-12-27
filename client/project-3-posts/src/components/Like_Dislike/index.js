import React, { useState } from "react";
import mintUp from "../../imgs/mintUp.png"
import mintDown from "../../imgs/mintDown.png"

function LikeDislike() {

    const [postLikes, setPostLikes] = useState({
        numLikes: 0,
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

    const element = (<button onClick={onClickHandler} value="cancel">---</button>)

    return (
        <div>
            
            <input height="75" type="image" onClick={onClickHandler} value="like" disabled={postLikes.disableLike} src={mintUp} /><br/>
            <input height="75" type="image" onClick={onClickHandler} value="dislike" disabled={postLikes.disableDislike} src={mintDown}/><br/>
            {postLikes.disableDislike? element : ""}
            {postLikes.disableLike? element : ""}
            <div>{postLikes.numLikes}</div>
        </div>
    )
}

export default LikeDislike
