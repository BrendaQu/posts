import React, { useState } from 'react'
import axios from 'axios'


const ReactButton = (props) => {

    const [showReactions, setShowReactions] = useState(false)

    const [reaction, setReaction] = useState({
        userId: "",
        // postId: props.data.postId,
        reaction: "",
    })

    function onClickHandler(event){
        setReaction({
            ...reaction,
            reaction: event.target.value
        })
        axios.post('http://localhost:11001/reactions', reaction)
        .then((response) => {
            console.log("Reaction saved")
        })
        .catch((error) => {
            console.log(error);
        })
    }

    

    console.log(reaction.reaction)
    return(
        <div>
            <button onClick={() => {setShowReactions(!showReactions); showReactions={showReactions}}}>React</button>
            {showReactions ? <><button onClick={onClickHandler} value="THUMBSUP">&#x1F44D;</button>
            <button onClick={onClickHandler} value="THUMBSDOWN">&#x1F44E;</button>
            <button onClick={onClickHandler} value="LAUGH">&#x1F923;</button>
            <button onClick={onClickHandler} value="CRY">&#x1F622;</button>
            <button onClick={onClickHandler} value="SMILE">&#x1F601;</button>
            <button onClick={onClickHandler} value="FROWN">&#x1F641;</button>
            <button onClick={onClickHandler} value="ANGRY">	&#x1F620;</button>
            <button onClick={onClickHandler} value="HEART">	&#x1F496;</button></> : <></>}
        </div>
    )
}

export default ReactButton;