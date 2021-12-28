import React from 'react'
import ReactButton from '../../components/ReactButton';
import LikeDislike from '../../components/Like_Dislike';
import ReactCounter from '../../components/ReactCounter';

const PostPage = () => {
    return (
        <div>
            <ReactButton />
            <ReactCounter />
            <LikeDislike />
        </div>
    )
}

export default PostPage;