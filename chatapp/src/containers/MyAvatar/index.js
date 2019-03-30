import React, {Component} from 'react';
import {connect} from 'react-redux';
import ReactCrop from 'react-image-crop'
import { pageChange } from "../../store/header/actions";
import { Link } from 'react-router-dom'
import {base64StringtoFile, image64toCanvasRef} from "../../Utils/resuableUtils";

import 'react-image-crop/dist/ReactCrop.css';
import './myAvatar.css'

class MyComponent extends Component {
    constructor(props) {
        super(props);
        this.imagePreviewCanvasRef = React.createRef();
        this.inputRef = React.createRef();
        this.state = {
            showMenu: false,
            crop: {
                aspect: 1/1
            },
            imgSrc:''
        }
    }


    optionClick() {
        console.log("1")
        this.setState({
            showMenu: !this.state.showMenu
        })
    }

    handleFileChange(e) {
        const file = e.target.files[0]
        console.log(file)

        const myFileItemReader = new FileReader()
        myFileItemReader.addEventListener("load", () => {
            console.log(myFileItemReader.result)
            this.setState({
                imgSrc: myFileItemReader.result,
                showMenu:false
            })
            console.log(this)
        }, false)
        myFileItemReader.readAsDataURL(file)
    }

    handleOnCropChange = (crop) => {
        this.setState({crop})
    }

    handleImageLoaded = (image) => {
        console.log(image)
    }


    handleOnCropComplete = (crop, pixelCrop) => {
        console.log(crop, pixelCrop)

        const canvasRef = this.imagePreviewCanvasRef.current
        const imgSrc = this.state.imgSrc

        image64toCanvasRef(canvasRef, imgSrc, pixelCrop)

    }

    saveAvatar = () => {
        const {imgSrc} = this.state
        const fileName = "new_file"
        const myNewCroppedFile = base64StringtoFile(imgSrc, fileName)
        console.log(myNewCroppedFile)
    }

    componentDidMount() {
        let leftButton = (
            <Link to="/Me" className='text-decoration-none'>
                <div>{"<"}</div>
            </Link>
        )
        let rightButton = (
            <div onClick={() => this.optionClick()}>{"..."}</div>
        )
        this.props.pageChange("MyAvatar", leftButton, rightButton)
    }
    render() {
        return (
            <div className="container position-relative">
                {/*<img src={this.props.user.face_image} alt=""/>*/}
                <ReactCrop
                    src= {this.state.imgSrc ? this.state.imgSrc : "https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg"}
                    crop={this.state.crop}
                    onChange={this.handleOnCropChange}
                    onImageLoaded={this.handleImageLoaded}
                    onComplete={this.handleOnCropComplete}
                />

                <br/>
                <p>Preview Canvas Crop</p>
                <div className="row justify-content-center">
                    <canvas className="w-50 h-50" ref={this.imagePreviewCanvasRef}></canvas>
                </div>
                <button className="btn btn-success w-100" onClick={this.saveAvatar}>Save avatar</button>
                {/*<img className=" p-0 w-100 h-50" src="https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg" alt=""/>*/}
                {this.state.showMenu ? <div className="backgroundDark"></div> : null}
                {this.state.showMenu
                    ?
                    <div className='menu p-3'>
                        <input type="file" name="file" onChange={(e) => this.handleFileChange(e)} style={{display:'none'}} ref={this.inputRef}/>
                        <button className="btn btn-outline-info w-100 bg-white text-black-50" onClick={() => this.inputRef.current.click()}>Select image</button>
                        <button
                            className="btn btn-outline-info w-100 bg-white text-black-50 mt-3"
                            onClick={() => this.optionClick()}
                        >
                            Cancel
                        </button>
                    </div>
                    :
                    null
                }
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        user: state.user
    };
}

const actionCreators = {  pageChange }

export default connect(
    mapStateToProps, actionCreators
)(MyComponent);
