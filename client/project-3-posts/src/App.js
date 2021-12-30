import CreatePost from './components/CreatePost';
// import RetrievePosts from './components/RetrievePosts';
import Feed from './components/Feed';
import PostFeed from './components/PostFeed';
import './App.css';
import PostPage from './pages/PostPage';


function App() {
  return (
    <div className="container">
      <br />
      <CreatePost />
      <br />
      {/* <RetrievePosts /> */}
      {/* <Feed /> */}
      <PostFeed />
      <PostPage/>
      {/* <PostFeed />
      <CommentTest/> */}
      {/* <PostPage/>
      <PostFeed /> */}
    </div>
  );
}

export default App;
