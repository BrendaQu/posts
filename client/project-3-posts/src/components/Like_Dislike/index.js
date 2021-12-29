import React, { useState } from "react";
import mintUp from "../../imgs/mintUp.png"
import mintDown from "../../imgs/mintDown.png"
import mintUpUnClicked from "../../imgs/mintUpUnclicked.png"
import mintDownUnClicked from "../../imgs/mintDownUnclicked.png"

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

    const elementUp = (<input height="120" type="image" onClick={onClickHandler} value="like" src={mintUpUnClicked} draggable="false" />)
    const elementUpClicked = (<input height="120" type="image" onClick={onClickHandler} value="cancel" src={mintUp} draggable="false" />)
    const elementDown = (<input height="120" type="image" onClick={onClickHandler} value="dislike" src={mintDownUnClicked} draggable="false" />)
    const elementDownClicked = (<input height="120" type="image" onClick={onClickHandler} value="cancel" src={mintDown} draggable="false" />)

    return (
        <div>
            {postLikes.disableLike? elementUpClicked : elementUp} 
            {postLikes.disableDislike? elementDownClicked : elementDown}<br/>
            <div>{postLikes.numLikes}</div>
        </div>
    )
}


export default LikeDislike
