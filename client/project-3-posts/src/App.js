import './App.css';
import PostPage from './pages/PostPage';
import CreatePostPage from './pages/CreatePostPage';
import FeedPage from './pages/FeedPage';
import { Route, Routes } from 'react-router-dom';


function App() {
  return (
    <div className="container">
      <Routes>
        <Route path="/feed" element={<FeedPage />} />
        <Route path="/create" element={<CreatePostPage />} />
        <Route path="/post/:id" element={<PostPage />} />
      </Routes>
    </div>
  );
}

export default App;
