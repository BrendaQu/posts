import React, { useState, useEffect } from 'react'
import axios from 'axios'

const URL_TO_GET_REACTIONS = 'http://localhost:11001/reactions/postId/';
const URL_TO_POST_REACTIONS = 'http://localhost:11001/reactions/';
const URL_TO_UPDATE_REACTIONS = 'http://localhost:11001/reactions/update/';

async function retrieveReactionsOfPost(postId){
    return axios.get(URL_TO_GET_REACTIONS+postId)
            .then(response => response.data)
            .catch(error => console.error(error))
  }

const ReactButton = (props) => {

    const [showReactions, setShowReactions] = useState(false)
    const[reactions, setReactions] = useState([]);
    const [reactionsCount, setReactionsCount] = useState({
        THUMBSUP: 0,
        THUMBSDOWN: 0,
        LAUGH: 0,
        CRY: 0,
        SMILE: 0,
        FROWN: 0,
        ANGRY: 0,
        HEART: 0
    })

    const [reaction, setReaction] = useState({
        userId: "",
        // postId: props.data.postId,
        reaction: "",
    })

    const fetchReactions = async (postId) => {
        const result = await retrieveReactionsOfPost(postId);
        setReactions(result);
  
      };
    
    useEffect(() => {
        fetchReactions(props.data.id)      
    },[]);

    const onClickHandler = (event) =>{
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

    const updateReaction = (event) =>{
        console.log(reactions)
        console.log("post id: " + props.data.id)
        console.log("user id: " + props.data.userId)
    
        const reactionForCurrentUser = reactions.find(reaction => reaction.userId == props.data.userId);
        console.log(reactionForCurrentUser)
    
        const data = {
          postId: props.data.id,
          userId: props.data.userId,
          reaction: event.target.value
        }
        
        if(reactionForCurrentUser === undefined){
          axios.post((URL_TO_POST_REACTIONS+props.data.id), data)
          .then(response => {
            console.log(response)
            setReactions([...reactions, response.data]);
          })
          .catch(error => console.error(error));
        } 
        else {
          axios.put((URL_TO_UPDATE_REACTIONS+reactionForCurrentUser.reactionId), data)
          .then(response => {console.log(response)
            setReactions([ response.data]);})
          .catch(error => console.error(error))
    
        }

        // TODO: update reaction count by recalling axios
        // put components on individual page
        // create global urls for axios calls
        // get rid of console logs
        // add comments
        // clean up code
        // bootstrap react button
        // organize/rename components
        // move Reactions file
    
      }
    
    return(
        <div>
            <button onClick={() => {setShowReactions(!showReactions)}}>React</button>
            {showReactions ? <><button onClick={updateReaction} value="THUMBSUP">&#x1F44D; {props.counts.THUMBSUP}</button>
            <button onClick={updateReaction} value="THUMBSDOWN">&#x1F44E; {props.counts.THUMBSDOWN}</button>
            <button onClick={updateReaction} value="LAUGH">&#x1F923; {props.counts.LAUGH}</button>
            <button onClick={updateReaction} value="CRY">&#x1F622; {props.counts.CRY}</button>
            <button onClick={updateReaction} value="SMILE">&#x1F601; {props.counts.SMILE}</button>
            <button onClick={updateReaction} value="FROWN">&#x1F641; {props.counts.FROWN}</button>
            <button onClick={updateReaction} value="ANGRY">	&#x1F620; {props.counts.ANGRY}</button>
            <button onClick={updateReaction} value="HEART">	&#x1F496; {props.counts.HEART}</button></> : <></>}
        </div>
    )
}

export default ReactButton;