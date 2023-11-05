import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import pl from "../assets/locales/pl/translation.json"
import en from "../assets/locales/en/translation.json"

const resources = {
    pl: {
        translation: pl,
    },
    en: {
        translation: en
    }
}

i18n
    .use(LanguageDetector)
    .use(initReactI18next)
    .init({
        resources,
        debug: true,
        fallbackLng: 'pl',
        interpolation: {
            escapeValue: false,
        },
    });

export default i18n;