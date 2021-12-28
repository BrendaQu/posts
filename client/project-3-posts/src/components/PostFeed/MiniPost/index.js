import React, {useState, useEffect} from 'react'

const MiniPost = (props) => {
    
    const [timeSince, setTimeSince] = useState("");

    useEffect(() => {
        let createdOn = new Date(props.data.creationDate); //Get the date the post was made
        let secondsAgo = (Date.now() - createdOn.getTime()) / 1000;  //Get how long ago this happened relative to now
        console.log(secondsAgo);

        if (secondsAgo < 60) {
            setTimeSince(Math.floor(secondsAgo) + " secs ago");
          } else if (secondsAgo < 3600) {
            setTimeSince(Math.floor(secondsAgo / 60) + " mins ago");
          } else if (secondsAgo < 86400) {
            setTimeSince(Math.floor(secondsAgo / 3600) + " hours ago");
          } else if (secondsAgo < 604800) {
            setTimeSince(Math.floor(secondsAgo / 86400) + " days ago");
          } else if (secondsAgo < 2592000) {
            setTimeSince(Math.floor(secondsAgo / 604800) + " weeks ago");
          } else {
            setTimeSince(Math.floor(secondsAgo / 2592000) + " month(s) ago");
          }
    }, [])



    let prettyDate = new Date(props.data.creationDate);
    return (
        <>
            <div className="wrapper text-center border border-4 shadow w-50">
                <h1>{props.data.title}</h1>
                <p>{props.data.description}</p>
                <p>By User No. {props.data.userId}</p>
                <p>On {(prettyDate.getMonth() + 1)}/{(prettyDate.getDate())}/{(prettyDate.getFullYear())} at {prettyDate.getHours()}:{(prettyDate.getMinutes() < 10) ? "0" + prettyDate.getMinutes() : prettyDate.getMinutes()}
                                {prettyDate.getHours() < 12 ? "am" : "pm"}</p>
                <p>({timeSince})</p>
                <p> Upmints: {props.data.upmints}</p>
                <p> Downmints: {props.data.downmints}</p>
                <p> {props.data.commentList.length} comments</p>
            </div>
        </>
    );

}

export default MiniPost;