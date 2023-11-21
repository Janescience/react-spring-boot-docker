import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import Permutation from "./components/permutation.component";
import FindOddInt from "./components/findoddint.component";
import CountSmileys from "./components/countsmileys.component";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <a href="/permutation" className="navbar-brand m-1">
            janescience
          </a>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/permutation"} className="nav-link">
                Permutation
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/findoddint"} className="nav-link">
                Find ODD Numbers
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/countsmileys"} className="nav-link">
                Count Smileys Faces
              </Link>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<Permutation/>} />
            <Route path="/permutation" element={<Permutation/>} />
            <Route path="/findoddint" element={<FindOddInt/>} />
            <Route path="/countsmileys" element={<CountSmileys/>} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;
