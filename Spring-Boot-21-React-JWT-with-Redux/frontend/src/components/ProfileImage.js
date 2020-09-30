import React from 'react'
import defaultPicture from "../assets/profile.png"



const ProfileImage = (props) => {
    const {width, height, imageSource, newimage,username} = props;

    return (
            <img 
                className="rounded-circle shadow" 
                width={width} 
                height={height}
                src={newimage || imageSource}  
                onError={event => event.target.src = defaultPicture } 
                alt={username+'-progile-icon'} />
    )
}

export default ProfileImage
