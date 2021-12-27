import './App.css';
import PostPage from './pages/PostPage';
import PostFeed from './components/PostFeed';
import CommentTest from './components/CommentTest/';

function App() {
  return (
    <div className="App">
      <PostPage/>
      <PostFeed />
      <CommentTest/>
    </div>
  );
}

export default App;
