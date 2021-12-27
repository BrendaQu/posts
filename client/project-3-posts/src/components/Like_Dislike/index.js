import React from 'react'

function LikeDislike() {

    let like;
    let numLikes = 100;
    function onClickHandler(event){
        if(like === undefined){
            like = event.target.value;
            if(like === "like"){
                numLikes += 1;
            }else{
                numLikes -= 1;
            }
        }else{
            like = event.target.value;
            if(like === "like"){
                numLikes += 2;
            }else{
                numLikes -=2;
            }
        }
        console.log(numLikes)
    }

    return (
        <div>
            <button onClick={onClickHandler} value="like">Like</button>
            <button onClick={onClickHandler} value="dislike">Dislike</button><br/>
            <div>{numLikes}</div>
        </div>
    )
}

export default LikeDislike
