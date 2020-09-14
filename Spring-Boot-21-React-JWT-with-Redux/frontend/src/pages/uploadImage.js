import React, { Component } from 'react'

var image;
export default class UploadImageComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            image: null
        };

        this.onChangeData = this.onChangeData.bind(this);
    }

    onChangeData(type, event) {
        const stateData = this.state;
        if (type === "image" && event && event[0]) {
            stateData[type] = URL.createObjectURL(event[0]);
            this.setState({ stateData });
        }
    }
    render() {
        return (
            <div>
                <h5>Upload Image Form</h5>
                <hr />
                <img src={this.state.image} />
                <h1>Select Image</h1>
                <input 
                    type="file" 
                    name="myImage" 
                    style={{ height: "100px", width: "100px" }} 
                    onChange={e => this.onChangeData('image', e.target.files)} />

                
            </div>
        )
    }
}
