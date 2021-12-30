import React, { useState, useEffect } from "react";
import mintUp from "../../imgs/mintUp.png"
import mintDown from "../../imgs/mintDown.png"
import mintUpUnClicked from "../../imgs/mintUpUnclicked.png"
import mintDownUnClicked from "../../imgs/mintDownUnclicked.png"
import axios from "axios";

function LikeDislike(props) {

    console.log(props);

    const [postLikes, setPostLikes] = useState({
        numLikes: props.data.upmints,
        numDislikes: props.data.downmints,
        disableLike: false,
        disableDislike: false,
    });

    function onClickHandler(event){
        if(event.target.value === "like" && !postLikes.disableDislike){
            setPostLikes({
                ...postLikes,
                numLikes: (postLikes.numLikes + 1),
                disableLike: true,
                disableDislike: false,
            })
        }else if(event.target.value === "dislike" && !postLikes.disableLike){
            setPostLikes({
                ...postLikes,
                numDislikes: (postLikes.numDislikes + 1),
                disableDislike: true,
                disableLike: false,
            })
        }else if(event.target.value === "like" && postLikes.disableDislike){
            setPostLikes({
                ...postLikes,
                numLikes: (postLikes.numLikes + 1),
                numDislikes: (postLikes.numDislikes - 1),
                disableLike: true,
                disableDislike: false,
            })
        }else if(event.target.value === "dislike" && postLikes.disableLike){
            setPostLikes({
                ...postLikes,
                numLikes: (postLikes.numLikes - 1),
                numDislikes: (postLikes.numDislikes + 1),
                disableDislike: true,
                disableLike: false,
            })
        }else if(event.target.value === "cancel" && postLikes.disableLike){
            setPostLikes({
                ...postLikes,
                numLikes: (postLikes.numLikes - 1),
                disableLike: false,
                disableDislike: false,
            })
        }else if(event.target.value === "cancel" && postLikes.disableDislike){
            setPostLikes({
                ...postLikes,
                numDislikes: (postLikes.numDislikes - 1),
                disableDislike: false,
                disableLike: false,
            })
        }
    }

    useEffect(() => {
        var post = props.data;
        post.upmints = postLikes.numLikes;
        post.downmints = postLikes.numDislikes;
        axios.put('http://localhost:11001/posts', post)
        .then(response => console.log(response.data))
    }, [postLikes])

    const elementUp = (<input height="120" type="image" onClick={onClickHandler} value="like" src={mintUpUnClicked} draggable="false" />)
    const elementUpClicked = (<input height="120" type="image" onClick={onClickHandler} value="cancel" src={mintUp} draggable="false" />)
    const elementDown = (<input height="120" type="image" onClick={onClickHandler} value="dislike" src={mintDownUnClicked} draggable="false" />)
    const elementDownClicked = (<input height="120" type="image" onClick={onClickHandler} value="cancel" src={mintDown} draggable="false" />)

    return (
        <div>
            {postLikes.disableLike? elementUpClicked : elementUp} 
            {postLikes.disableDislike? elementDownClicked : elementDown}<br/>
            <div>{postLikes.numLikes}</div>
            <div>{postLikes.numDislikes}</div>
        </div>
    )
}


export default LikeDislike
