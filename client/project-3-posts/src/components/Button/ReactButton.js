import React, { useState } from 'react'
import { GithubSelector } from '@charkour/react-reactions'


const ReactButton = () => {

    const [reaction, setReaction] = useState(false)

    function onClickHandler(){
        setReaction(!reaction)
    }

    return(
        <div>
            <button onClick={onClickHandler}>React</button>
            {reaction ? <GithubSelector/> : ""}
        </div>
    )
}

export default ReactButton;