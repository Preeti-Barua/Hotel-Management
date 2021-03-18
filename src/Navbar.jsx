import React from 'react';
import {NavLink} from 'react-router-dom';
const Navbar = () =>{
    return(
        <>
        <div className="container-fluid nav_bg">
            <div className='row'>
              <div className="col-10 mx-auto">
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <NavLink className="navbar-brand" to="/">
                HOTEL EMARALD WELCOMES YOU
                </NavLink>
                <button 
                className="navbar-toggler" 
                type="button" 
                data-toggle="collapse" 
                data-target="#navbarSupportedContent" 
                aria-controls="navbarSupportedContent" 
                aria-expanded="false" 
                aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse"
                 id="navbarSupportedContent">

                <ul className="navbar-nav ml-auto mb-2 mb-lg-0">
                <li className="nav-item active">

                <NavLink 
                className="nav-link active" 
                to="/Home">Home <span class="sr-only"></span></NavLink>
                </li>
                <li className="nav-item">
                <NavLink className="nav-link" to="/Contacts">
                Contacts</NavLink>
                </li>
                <li className="nav-item">
                <NavLink className="nav-link" to="/Reception">
                Reception</NavLink>
                </li>
                <li className="nav-item">
                <NavLink className="nav-link" to="/Admin">
                Admin</NavLink>
                </li>
                </ul>

            </div>
            </nav>
            </div>
            </div>
        </div>
        </>
    );
};

export default Navbar;