import CreatePost from './components/CreatePost';
// import RetrievePosts from './components/RetrievePosts';
import Feed from './components/Feed'
import './App.css';
import CommentTest from './components/CommentTest/';


function App() {
  return (
    <div className="container">
      <br />
      <CreatePost />
      <br />
      {/* <RetrievePosts /> */}
      <Feed />
      <PostPage/>
      {/* <PostFeed />
      <CommentTest/> */}
      {/* <PostPage/>
      <PostFeed /> */}
      <CommentTest/>
    </div>
  );
}

export default App;
