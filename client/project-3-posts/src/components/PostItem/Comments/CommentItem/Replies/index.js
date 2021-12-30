import { useState, useEffect } from "react";
import Comment from "../";

// given a list of replies, render them:
const Replies = (props) => {
  return (
    <div>
      {props.replies.map((reply) => (
        <div className="row">
          <div className="col-1"></div>
          <div className="col-11">
            <Comment
              postId={props.postId}
              comment={reply}
              comments={props.replies}
              setComments={props.setReplies}
              key={reply.id}
            />
          </div>
        </div>
      ))}
    </div>
  );
};

export default Replies;
