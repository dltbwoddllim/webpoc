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
        const response = await axios.get(`${API_BASE_URL}/User/article/${id}`);
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
    <div>
      <h2>{title}</h2>
      <p>{subtitle}</p>
      <p>Author: {name}</p>
      <p>Date: {moment(date).format("LL")}</p>
      <p>Tag: {tag}</p>
      <div>{text}</div>
    </div>
  );
};

export default ArticlePage;
