\# WF-002 Logowanie / Wylogowanie



\*\*Aktor:\*\* Niezalogowany użytkownik (logowanie), Zalogowany użytkownik (wylogowanie)  

\*\*Cel:\*\* Uzyskanie dostępu do funkcji systemu po zalogowaniu oraz zakończenie sesji  

\*\*Priorytet:\*\* Wysoki



\## Opis

Użytkownik może zalogować się do systemu podając poprawne dane. Użytkownik zalogowany może się wylogować.



\## Kryteria akceptacji

\- System umożliwia logowanie przy poprawnych danych.

\- System odrzuca logowanie przy błędnych danych.

\- Po zalogowaniu użytkownik ma dostęp do funkcji dla zalogowanych (np. timeline).

\- System umożliwia wylogowanie i po wylogowaniu użytkownik traci dostęp do funkcji dla zalogowanych.



\## Scenariusz główny – logowanie

1\. Użytkownik otwiera formularz logowania.

2\. Wprowadza dane (np. login/email i hasło).

3\. Zatwierdza formularz.

4\. System weryfikuje dane i loguje użytkownika.

5\. System przekierowuje użytkownika na stronę główną (np. timeline).



\## Scenariusze alternatywne – logowanie

A1. Błędne dane → system pokazuje komunikat i nie loguje użytkownika.  

A2. Brak wymaganych danych → system prosi o uzupełnienie.



\## Scenariusz główny – wylogowanie

1\. Użytkownik wybiera opcję „Wyloguj”.

2\. System kończy sesję użytkownika.

3\. System przekierowuje do widoku publicznego lub logowania.



\## Scenariusze alternatywne – wylogowanie

B1. Sesja wygasła wcześniej → system przenosi do logowania.



