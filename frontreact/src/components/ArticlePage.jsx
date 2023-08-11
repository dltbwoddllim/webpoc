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
        const response = await axios.get(`${API_BASE_URL}/User/article/${id}`,{headers});
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
    <div className="max-w-3xl mx-auto p-4">
      <h1 className="text-3xl font-bold mb-2">{title}</h1>
      <div className="flex justify-between text-gray-500 mb-4">
        <div className="flex items-start">
          <p className="mr-4">By {name}</p>
          <p>{moment(date).format("LL")}</p>
        </div>
      </div>
      <div dangerouslySetInnerHTML={{ __html: text }} className="text-lg leading-7"></div>
    </div>

  );
};

export default ArticlePage;
