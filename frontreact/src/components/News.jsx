import React, { useContext, useState, useCallback } from "react";
import "moment/locale/en-gb";
import { NewsContext } from "../../contexts/NewsContext";
import axios from "axios";
import Loading from "./Loading";

const API_BASE_URL = "http://34.22.93.133:8080";

const NewsPage = () => {
  const { newsItems, isLoading, filteredNewsItems } = useContext(NewsContext);
  const news = filteredNewsItems.length ? filteredNewsItems : newsItems;

  const itemsPerPage = 9;

  var index = "";
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  const tag = urlParams.get('tag');
  const author_name = urlParams.get('author_name');

  if (tag != null) {
    index = tag;
  } else if (author_name != null) {
    index = author_name;
  }
  else {
    index = "Latest News!"
  }
  const startIndex = 0;
  const endIndex = startIndex + itemsPerPage;

  const [currentItems, setCurrentItems] = useState(news?.slice(startIndex, endIndex));
  var lastItemid = currentItems[currentItems.length - 1];
  console.log(lastItemid)
  const fetchNews = useCallback(async (lastItemid) => {
    try {
      var url = "";
      const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
      if (tag != null) {url = (`${API_BASE_URL}/User/tag/${tag}/id/${lastItemid}`)}
      else{url = (`${API_BASE_URL}/User/main/afterid/${lastItemid}`)}
      console.log(url)
      const response = await axios.get(url, { headers });
      setCurrentItems(currentItems => [...currentItems, ...response.data]); // Update currentItems using prevState
      console.log(currentItems)
      setLoading(false);
    } catch (error) {
      console.log(error);
    }
  }, []);

  //if loadmore button is clicked, fetch more news after last itemid andthen newsItems = newsItems + response.data load article
  const handleLoadMore = () => {
    fetchNews(lastItemid.article_id);
  };



  return (
    <div className="container mx-auto px-4 sm:px-6 lg:px-8 py-8">
      {isLoading ? (
        <Loading />
      ) : (
        <>
          <div class="container mx-auto my-16 px-4 md:px-8">
            <section class="mb-12 text-center">
              <h2 class="text-2xl md:text-3xl font-semibold mb-6">{index}</h2>
              <div className="border border-gray-300 border-t-2 border-b-0 border-r-0 border-l-0">
              </div>
              <div class="grid gap-6 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4 mt-3">
                {currentItems.map((item) => (
                  <div key={item.article_id} class="mb-8">
                    <div class="relative overflow-hidden rounded-lg shadow-lg bg-gray-100 dark:bg-gray-800 transform transition-transform duration-300 hover:scale-105">
                      <img src={item.imageurl} class="w-full h-48 object-cover" alt="Article Thumbnail" />
                      <a href={`/article/${item.article_id}`}>
                        <div class="absolute inset-0 opacity-0 transition duration-300 ease-in-out hover:opacity-100"></div>
                      </a>
                    </div>
                    <div class="mt-3 font-semibold text-pink-500 text-left"><a href={`?tag=${item.tag}`}>{item.tag}</a></div>
                    <a href={`/article/${item.article_id}`}>
                      <h5 class="text-lg font-semibold my-1 text-left">{item.title}</h5>
                    </a>
                    <p class="mb-4 text-gray-600 dark:text-gray-300 text-left">
                      <small>Published on <u>{item.date}</u> 
                      {/* by <a href={`?author_id=${item.author_id}&author_name=${item.name}`} class="text-gray-500">{item.name}</a> */}
                      </small>
                    </p>
                  </div>
                ))}
              </div>
            </section>
          </div>
          <div>
          </div>
          <div className="flex justify-center my-6">
            <button
              className="bg-pink-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
              onClick={handleLoadMore}
            >
              Load More
            </button>
          </div>
          {/* <Pagination
            currentPage={currentPage}
            handlePageChange={handlePageChange}
            totalPages={totalPages}
          /> */}
        </>
      )}
    </div>
  );
};

export default NewsPage;
