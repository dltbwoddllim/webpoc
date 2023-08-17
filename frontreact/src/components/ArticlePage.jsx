import React, { useState, useEffect } from "react";
import axios from "axios";
import moment from "moment";
import "moment/locale/en-gb";
import { useParams } from "react-router-dom";

const API_BASE_URL = "http://localhost:8080";

const ArticlePage = () => {
  const { id } = useParams();
  const [article, setArticle] = useState(null);

  useEffect(() => {
    const fetchArticle = async () => {
      try {
        const headers = { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:3000' };
        const response = await axios.get(`${API_BASE_URL}/User/article/${id}`, { headers });
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

  const { name, title, subtitle, date, tag, text } = article;

  return (
    <div class="container mx-auto px-6 py-12 md:py-24">
      <article class="max-w-3xl mx-auto">
        <h1 class="text-3xl md:text-4xl font-bold mb-4 md:mb-6 font-roboto">
          {title}
        </h1>
        <img src={subtitle} alt="Image"
          class="w-full mb-6 rounded-lg shadow-lg dark:shadow-black/20" />
        <div class="text-left">
          <span class="text-gray-600 dark:text-gray-400 font-roboto">
            Published <u>{date}</u> by &nbsp;
            <a href="#!" class="text-gray-500 font-medium">
              {name}
            </a>
          </span>
        </div>
        <div class="mt-8 text-lg leading-7 font-roboto">
          <div dangerouslySetInnerHTML={{ __html: text }}></div>
        </div>
      </article>
    </div>

  );
};

export default ArticlePage;
