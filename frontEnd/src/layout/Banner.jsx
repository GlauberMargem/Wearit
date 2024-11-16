import React from 'react';
import './Banner.css'
import BannerImage from "../images/banner.png"

function Banner() {
    return (
        <div className='banner-container'>
            <img className='banner-img' src={BannerImage} alt="Banner Principal" />
        </div>
    )
}

export default Banner