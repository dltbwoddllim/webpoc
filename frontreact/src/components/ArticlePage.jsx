import React, { useState, useEffect } from "react";
import axios from "axios";
import moment from "moment";
import "moment/locale/en-gb";
import { useParams } from "react-router-dom";

const API_BASE_URL = "http://localhost:8080";

const ArticlePage = () => {
  const { article_id } = useParams();
  const [articleData, setArticleData] = useState(null);

  useEffect(() => {
    async function fetchArticle() {
      try {
        const response = await axios.get(`${API_BASE_URL}/article/${article_id}`);
        setArticleData(response.data);
      } catch (error) {
        console.log(error);
      }
    }

    fetchArticle();
  }, [article_id]);

  if (!articleData) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <div className="text-center">
        <h1 className="text-3xl font-semibold mb-4">{articleData.title}</h1>
        <p className="text-gray-500 mb-2">
          By {articleData.name} | {moment(articleData.date).format("LL")}
        </p>
        <img
          src={articleData.subtitle}
          alt={articleData.title}
          className="w-full h-64 object-cover object-center mb-4"
        />
        <p className="text-gray-700">{articleData.tag}</p>
        <p className="mt-4">{articleData.content}</p>
      </div>
    </div>
  );
};

export default ArticlePage;
