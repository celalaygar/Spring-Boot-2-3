
import React from 'react'
import { Link } from 'react-router-dom';
import defaultPicture from "../assets/profile.png"
import { BACKEND_IMAGE_URL } from '../Shared/config';
import ProfileImage from './ProfileImage';


const UserListItem = (props) => {

    const {user, index} = props;
    let imageSource = defaultPicture;
    
    if(user.image){
        imageSource= BACKEND_IMAGE_URL + user.image;
    }
    return (
        <Link to={'/user/'+user.username} className="list-group-item list-group-item-action" >
            <ProfileImage 
                width="32" 
                height="32" 
                imageSource={imageSource} 
                username={user.username} 
            /> 
            <span className="pl-3">{index} : {user.username} </span>
        </Link>
    )
}

export default UserListItem
