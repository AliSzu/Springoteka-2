# Java-SpringBoot
Program, który łączy się z bazą danych oraz tworzy endpointy REST-owe dla GET/POST/PUT oraz DELETE. Do łączenia się z bazą danych, program używa frameworku Spring

## Działalność
- Program łączy się z bazą danych stworzoną w PostgreSQl. Uwaga! Żeby się połączyć z bazą trzeba w ```application.yml``` wpisać odpowiednią nazwe bazy, hasło etc.
- Baza danych, z którą łączy się program zawiera 5 tabel. W tym zawierają się 2 relacje OnetoMany oraz 2 relacje ManytoMany
- Stworzone są endpointy REST-owe dla EDIT/POST/PUT/DELETE
- Aplikacja można uruchomić w środowisku IDE oraz w Tomcacie. Aby uruchomić aplikację w Tomcatcie wystarczy wybrać opcje ```[clean, install]``` w zakładce Mavev. Wtedy w folderze ```target``` pojawi się plik ```WebApp.war```, który należy użyć w Tomcatcie aby program został uruchomiony
- Program używa uwierzytelniania do wszystkich tabel, dlatego podgląd z aplkiacji Postman lub Swagger nie będzie dostępny. Uwierzytelnianie jest na poziomie aplikacji frontendowej.

