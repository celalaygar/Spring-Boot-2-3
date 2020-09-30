import i18n from 'i18next';
import {initReactI18next} from "react-i18next";

i18n.use(initReactI18next).init({
    resources: {
      en: {
        translations: {
          'Sign Up': 'Sign Up',
          'Password mismatch': 'Password mismatch',
          "Username *": 'Username *',
          "Password *": 'Password *',
          'Repeat Password *': 'Password Repeat *',
          "Name": 'Name',
          "Surname": 'Surname',
          Login: 'Login',
          Logout: 'Logout',
          HomePage: 'HomePage',
          Users: 'Users',
          Next: 'next >',
          'Page' : 'Page : ',
          'User Detail': 'User Detail',
          Previous: '< previous',
          'Load Failure': 'Load Failure',
          'User not found': 'User not found',
          Edit: 'Edit',
          'Change User Info': 'Change User Info',
          Save: 'Save',
          Cancel: 'Cancel',
          Update: 'Update',
          "Change Image": "Change Image",
          'My Profile': 'My Profile',
          'There are no hoaxes': 'There are no hoaxes',
          'Load old hoaxes': 'Load old hoaxes',
          'There are new hoaxes': 'There are new hoaxes',
          'Delete Hoax': 'Delete Hoax',
          'Are you sure to delete hoax?': 'Are you sure to delete hoax?',
          'Delete My Account': 'Delete My Account',
          'Are you sure to delete your account?': 'Are you sure to delete your account?'
        }
      },
      tr: {
        translations: {
          'Sign Up': 'Kayıt Ol',
          'Password mismatch': 'Aynı şifreyi giriniz',
          "Username *": 'Kullanıcı Adı *',
          "Password *": 'Şifre *',
          'Repeat Password *': 'Şifreyi Tekrarla *',
          "Name": 'İsim',
          "Surname": 'Soyisim',
          Login: 'Sisteme Gir',
          HomePage: 'Anasayfa',
          Logout: 'Çık',
          Users: 'Kullanıcılar',
          Next: 'sonraki >',
          Previous: '< önceki',
          'User Detail': 'Kullanıcı Bilgileri', 
          'Page' : 'Sayfa : ',
          'Load Failure': 'Liste alınamadı',
          'User not found': 'Kullanıcı bulunamadı',
          Edit: 'Düzenle',
          "Change Image": "Resim Değiştirme",
          'Change User Info': 'Kullanıcı bilgilerini Değiştirin',
          Save: 'Kaydet',
          Cancel: 'İptal Et',
          Update: 'Güncelle',
          'My Profile': 'Hesabım',
          'There are no hoaxes': 'Hoax bulunamadı',
          'Load old hoaxes': 'Geçmiş Hoaxları getir',
          'There are new hoaxes': 'Yeni Hoaxlar var',
          'Delete Hoax': `Hoax'u sil`,
          'Are you sure to delete hoax?': `Hoax'u silmek istedğinizden emin misiniz?`,
          'Delete My Account': 'Hesabımı Sil',
          'Are you sure to delete your account?': 'Hesabınızı silmek istediğinizden emin misiniz?'
        }
      }
    },
    fallbackLng: 'tr',
    ns: ['translations'],
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {
      escapeValue: false,
      formatSeparator: ','
    },
    react: {
      wait: true
    }
  });

export default i18n;