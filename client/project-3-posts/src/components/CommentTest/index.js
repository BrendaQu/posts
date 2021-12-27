import Comments from '../Comments'

const CommentTest = () => {
    // create a dummy post object to test comments:
    const dummyPost = {
        id: 1,
        userId: 1,
        title: 'New Post',
        description: 'This is a new post',
        img: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60'
    }
    return (
        <div>
            <Comments post = {dummyPost}/>
        </div>
    )
}

export default CommentTest;