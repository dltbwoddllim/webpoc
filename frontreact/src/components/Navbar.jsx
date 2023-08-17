import React, { useContext, useState } from "react";
import { NewsContext } from "../../contexts/NewsContext";
import logo from '../assets/logo.gif';
function Navbar() {
  const { setSearchQuery, searchQuery } = useContext(NewsContext);

  const handleSearch = (e) => {
    setSearchQuery(e.target.value);
  };

  return (
<nav className="flex items-center justify-center bg-white-800 p-2">
  <div className="flex-shrink-0 text-white mr-6">
    <a
      href="/"
      className="cursor-pointer transition-all duration-500 hover:text-blue-500"
    >
      <img src={logo} alt="Logo" className="h-10" />
    </a>
  </div>
  {/* <form className="w-full max-w-sm p-2">
    <div className="flex items-center border-b-2 border-blue-500 py-2">
      <input
        className="appearance-none bg-transparent border-none w-full text-white mr-3 py-1 px-1 leading-tight focus:outline-none"
        type="text"
        placeholder="Search by title"
        value={searchQuery}
        onChange={handleSearch}
      />
    </div>
  </form> */}
</nav>

    // <nav className="flex items-center justify-between flex-wrap bg-gray-800 p-2">
    //   <div className="flex items-center flex-shrink-0 text-white mr-6">
    //     <a
    //       href="/"
    //       className="text-xl font-bold cursor-pointer text-white transition-all duration-500 hover:text-blue-500"
    //     >
    //       Crypdonuts
    //     </a>
    //   </div>
    //   <form className="w-full max-w-sm p-2">
    //     <div className="flex items-center border-b-2 border-blue-500 py-2">
    //       <input
    //         className="appearance-none bg-transparent border-none w-full text-white mr-3 py-1 px-1 leading-tight focus:outline-none"
    //         type="text"
    //         placeholder="Search by title"
    //         value={searchQuery}
    //         onChange={handleSearch}
    //       />
    //     </div>
    //   </form>
    // </nav>
  );
}

export default Navbar;
