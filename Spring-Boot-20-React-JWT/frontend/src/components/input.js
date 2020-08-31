
import React from 'react'

const Input = (props) => {
    const {label,error,name,valueName,onChangeData,type, placeholder} = props;
    const className= error ? "form-control is-invalid" : "form-control";
   
        return (
            <div className="form-group">
                <label htmlFor="exampleInputEmail1">{label}</label>
                <input
                    type={type} className={className}
                    name={name}
                    onChange={e => onChangeData(name, e.target.value)}
                    value={valueName}
                    placeholder={placeholder} required />
                <div className="invalid-feedback">{error}</div>
            </div>
        );
}
export default Input;