import React, { useContext, useState, useEffect } from "react";
import moment from "moment";
import "moment/locale/en-gb";
import { NewsContext } from "../../contexts/NewsContext";
import Pagination from "./Pagination";
import Loading from "./Loading";

const NewsPage = () => {
  const { newsItems, isLoading, filteredNewsItems } = useContext(NewsContext);
  console.log(filteredNewsItems)
  const news = filteredNewsItems.length ? filteredNewsItems : newsItems;

  const itemsPerPage = 12;
  const [currentPage, setCurrentPage] = useState(1);
  const totalPages = Math.ceil(news.length / itemsPerPage);


  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const currentItems = news?.slice(startIndex, endIndex);

  return (
    <div className="container mx-auto px-4 sm:px-6 lg:px-8 py-8">
      {/* <div className="flex flex-col items-center mb-7">
        <h1 className="text-5xl font-bold mb-2 text-gray-900">
          <span className="text-blue-600">LATEST</span> NEWS
        </h1>
        <div className="w-20 h-1 bg-blue-600 mb-8"></div>
      </div> */}

      {isLoading ? (
        <Loading />
      ) : (
        <>
<div class="container mx-auto my-16 px-4 md:px-8">
  <section class="mb-12 text-center">
    <h2 class="text-2xl md:text-3xl font-semibold mb-6">Latest Articles</h2>
    <div class="grid gap-6 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4">
      {currentItems.map((item) => (
        <div key={item.article_id} class="mb-8">
          <div class="relative overflow-hidden rounded-lg shadow-lg bg-gray-100 dark:bg-gray-800 transform transition-transform duration-300 hover:scale-105">
            <img src={item.subtitle} class="w-full h-48 object-cover" alt="Article Thumbnail" />
            <a href={`/article/${item.article_id}`}>
              <div class="absolute inset-0 opacity-0 transition duration-300 ease-in-out hover:opacity-100"></div>
            </a>
          </div>
          <div class="mt-3 font-semibold text-pink-500 text-left">{item.tag}</div>
          <h5 class="text-lg font-semibold my-1 text-left">{item.title}</h5>
          <p class="mb-4 text-gray-600 dark:text-gray-300 text-left">
            <small>Published on <u>{item.date}</u> by <a href="#!" class="text-gray-500">{item.name}</a></small>
          </p>
        </div>
      ))}
    </div>
  </section>
</div>



          {/* <div class="container mx-auto my-24 md:px-6">
            <section class="mb-16 text-center ">
              <h2 class="text-3xl font-bold mb-8 font-robot">Latest Articles</h2>
              <div class="grid gap-6 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4">
                {currentItems.map((item) => (
                  <div key={item.article_id} class="mb-6">
                    <div class="relative overflow-hidden rounded-lg bg-cover bg-no-repeat shadow-lg dark:shadow-black/20">
                      <img src={item.subtitle} class="w-full h-40 md:h-52 object-cover" alt="Article Thumbnail" />
                      <a href={`/article/${item.article_id}`}>
                        <div class="absolute inset-0 opacity-0 transition duration-300 ease-in-out hover:opacity-100 bg-[hsla(0,0%,98.4%,.15)]">
                        </div>
                      </a>
                    </div>
                    <div class="font-small font-robot text-danger red:text-danger-500 text-left">
                      {item.tag}
                    </div>
                    <h5 class="text-lg font-bold my-1 text-left">{item.title}</h5>
                    <p class="mb-4 text-neutral-500 dark:text-neutral-300 text-left">
                      <small>Published <u>{item.date}</u> by <a href="#!" class="text-dark-500">{item.name}</a></small>
                    </p>
                  </div>
                ))}
              </div>
            </section>
          </div> */}

          <Pagination
            currentPage={currentPage}
            handlePageChange={handlePageChange}
            totalPages={totalPages}
          />
        </>
      )}
    </div>
  );
};

export default NewsPage;
