import React, { useState, useEffect, useCallback, useMemo } from "react";
import axios from "axios";
import { BrowserRouter as Router, Route, Routes} from "react-router-dom"; 
import { NewsContextProvider } from "../contexts/NewsContext";
import Navbar from "./components/Navbar";
import NewsPage from "./components/News";
import ArticlePage from "./components/ArticlePage";
import Newsletter from "./components/newsletter";


const API_BASE_URL = "http://34.64.73.28:8080";

const App = () => {
  const [newsItems, setNewsItems] = useState([]);
  const [isLoading, setLoading] = useState(true);
  const [searchQuery, setSearchQuery] = useState("");
  const [filteredNewsItems, setFilteredNewsItems] = useState([]);

  const fetchNews = useCallback(async () => {
    try {
      const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
      const response = await axios.get(`${API_BASE_URL}/User/main`, { headers });
      setNewsItems(response.data);
      setLoading(false);
    } catch (error) {
      console.log(error);
    }
  }, []);

  //get query string
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  const tag = urlParams.get('tag');
  const fetchNewByTag = useCallback(async (tag) => {
    try {
      const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
      const response = await axios.get(`${API_BASE_URL}/User/tag/`+tag, { headers });
      setNewsItems(response.data);
      setLoading(false);
    } catch (error) {
      console.log(error);
    }
  }, []);

  const author_id = urlParams.get('author_id');
  const fetchNewByAuthor_id = useCallback(async (author_id) => {
    try {
      const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
      const response = await axios.get(`${API_BASE_URL}/User/author/`+author_id, { headers });
      setNewsItems(response.data);
      setLoading(false);
    } catch (error) {
      console.log(error);
    }
  }, []);

  const filteredNews = useMemo(() => {
    return newsItems.filter((item) =>
      item.title.toLowerCase().includes(searchQuery.toLowerCase())
    );
  }, [newsItems, searchQuery]);

  useEffect(() => {
    if (searchQuery.length > 0) {
      setFilteredNewsItems(filteredNews);
    } else {
      setFilteredNewsItems(newsItems);
    }
  }, [filteredNews, newsItems, searchQuery]);

  useEffect(() => {
    if (tag != null) {
      fetchNewByTag(tag)
    } else if (author_id != null) {
      fetchNewByAuthor_id(author_id)
    } else {
      fetchNews();
    }
  }, [fetchNews]);

return (
  <NewsContextProvider
    value={{
        newsItems,
        setNewsItems,
        isLoading,
        setLoading,
        fetchNews,
        setSearchQuery,
        searchQuery,
        filteredNewsItems,
        setFilteredNewsItems,      }}
    >
    <Navbar />
    {/* <Newsletter /> */}
      <Router> 
        <Routes>
          <Route path="/" element={<NewsPage key={filteredNewsItems.length} />}> </Route>
          <Route path="/article/:id" element={<ArticlePage />} > </Route>
        </Routes>
      </Router>
    </NewsContextProvider>
    
  );
};

export default App;
