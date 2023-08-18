import React, { useContext, useState } from "react";
import { NewsContext } from "../../contexts/NewsContext";
import logo from '../assets/logo.gif';
import {
  Collapse,
  Dropdown,
  initTE,
} from "tw-elements";


function Navbar() {
  initTE({ Collapse, Dropdown });
  const { setSearchQuery, searchQuery } = useContext(NewsContext);

  const handleSearch = (e) => {
    setSearchQuery(e.target.value);
  };


  return (
    <nav className="flex justify-center items-center bg-neutral-50 py-2 text-neutral-600 shadow-lg dark:bg-neutral-700 dark:text-neutral-300 dark:shadow-black/5">
      <div className="flex items-center space-x-4">
        <a href="/" className="cursor-pointer transition-all duration-500 hover:text-blue-500">
          <img src={logo} alt="Logo" className="h-10" />
        </a>
        <div className="relative group">
          <button className="hover:bg-gray-200 font-robot">Topics</button>
          <div className="hidden absolute z-10 top-full left-0 bg-white border shadow group-hover:block">
            <a href="/?tag=NFTS" className="block px-4 py-2 hover:text-blue-500 font-robot">NFTS</a>
            <a href="/?tag=ALTCOINS" className="block px-4 py-2 hover:text-blue-500 font-robot">Altcoins</a>
            <a href="/?tag=DAPPS" className="block px-4 py-2 hover:text-blue-500 font-robot">DAPPS</a>
            <a href="/?tag=REGULATIONS" className="block px-4 py-2 hover:text-blue-500 font-robot">Regulations</a>
            <a href="/?tag=TOOLS" className="block px-4 py-2 hover:text-blue-500 font-robot">Tools</a>
            <a href="/?tag=MARKETS" className="block px-4 py-2 hover:text-blue-500 font-robot">Markets</a>
          </div>
        </div>
        <button className="hover:bg-gray-200 font-robot"><a href="/" className="hover:bg-gray-200 font-robot">Latest</a></button>
      </div>
    </nav>  
  );
}

export default Navbar;
