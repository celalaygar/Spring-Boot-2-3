import React from 'react'
import ApiService from "../Services/ApiService";
import { withTranslation } from 'react-i18next';

const LanguageSelector = (props) => {


    const onchangeLanguage = lg => {
        const { i18n } = props;
        i18n.changeLanguage(lg);
        ApiService.changeLanguage(lg);

    };

    return (
        <div className="col-sm-12">
            <hr />
            <img src="https://www.countryflags.io/tr/flat/32.png" style={{ "cursor": "pointer" }} onClick={() => onchangeLanguage("tr")} alt="Turkısh Flag" />
            <img src="https://www.countryflags.io/gb/flat/32.png" style={{ "cursor": "pointer" }} onClick={() => onchangeLanguage("en")} alt="England Flag" />

        </div>
    );
};


export default withTranslation()(LanguageSelector);
