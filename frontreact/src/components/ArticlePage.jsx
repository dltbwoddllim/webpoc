import React, { useState, useEffect } from "react";
import axios from "axios";
import "moment/locale/en-gb";
import { useParams } from "react-router-dom";

const API_BASE_URL = "http://34.64.73.28:8080";

const ArticlePage = () => {
  const { id } = useParams();
  const [article, setArticle] = useState(null);

  useEffect(() => {
    const fetchArticle = async () => {
      try {
        const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
        const response = await axios.get(`${API_BASE_URL}/User/article/${id}`, { headers });
        console.log(response.data)
        setArticle(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchArticle();
  }, [id]);

  if (!article) {
    return <div>Loading...</div>;
  }

  const { name, title, subtitle, imageurl, imagesource, date, tag, text } = article;

  return (
    <div className="container mx-auto px-6 py-10 md:py-24">
      <article className="max-w-3xl mx-auto">
        <div class="mt-3 font-semibold text-pink-500 text-left"><a href={`http://localhost:3000?tag=${tag}`}>{tag}</a></div>
        <h1 className="text-3xl md:text-4xl font-bold mb-4 md:mb-6 font-roboto">
          {title}
        </h1>
        <div>
          <img
            src={imageurl}
            alt="Image"
            className="w-full mb-0 rounded-lg shadow-lg dark:shadow-black/20"
          />
          <small
              className=" text-right p-0 rounded-bl-lg text-gray-500"
              >
            <p>{imagesource}</p>
          </small>
        </div>

          <div className="text-left">
            <span className="text-gray-600 dark:text-gray-400 font-roboto">
              Published <u>{date}</u>
              {/* by &nbsp;
            <a href={`http://localhost:3000/?author_id=${article.author_id}&author_name=${name}`} className="text-gray-500 font-medium">
              {name}
            </a> */}
            </span>
          </div>
          <div className="mt-2 text-lg leading-7 font-roboto">
            <div dangerouslySetInnerHTML={{ __html: text }}></div>
          </div>
        </article>
      </div>
  );
};

export default ArticlePage;
