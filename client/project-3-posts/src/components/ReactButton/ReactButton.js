import React, { useState } from 'react'
import { ReactionBarSelector } from '@charkour/react-reactions'


const ReactButton = () => {

    const [reaction, setReaction] = useState(false)

    function onClickHandler(){
        setReaction(!reaction)
    }

    return(
        <div>
            <button onClick={onClickHandler}>React</button>
            {reaction ? <ReactionBarSelector /> : ""}
        </div>
    )
}

export default ReactButton;