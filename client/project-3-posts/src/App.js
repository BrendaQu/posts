
import CreatePost from './components/CreatePost';
// import RetrievePosts from './components/RetrievePosts';
import Feed from './components/Feed'


function App() {
  return (
    <div className="container">
      <br />
      <CreatePost />
      <br />
      {/* <RetrievePosts /> */}
      <Feed />
    </div>
  );
}

export default App;
