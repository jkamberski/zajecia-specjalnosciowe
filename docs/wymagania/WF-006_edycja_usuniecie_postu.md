WF-006 Edycja i Usuwanie Postów
Aktor: Zalogowany użytkownik (właściciel posta)

Cel: Możliwość edycji treści publikowanych postów oraz usuwania ich z systemu

Priorytet: Wysoki

Opis
Zalogowany użytkownik może edytować treść swoich postów po publikacji lub usunąć je całkowicie. Edycja posta zachowuje pierwotną datę publikacji, ale oznacza post jako "edytowany". Usunięcie posta powoduje jego usunięcie ze wszystkich chronologii, komentarzy i polubień.

Kryteria akceptacji
Użytkownik może edytować tylko swoje posty

Po edycji post zawiera oznaczenie "edytowany" z datą edycji

Tekst posta może być zmieniony

Załączniki mogą być dodane lub usunięte podczas edycji

Użytkownik może usunąć swój post

Po usunięciu post znika ze wszystkich widoków i chronologii

Komentarze do usuniętego posta są usuwane

Polubienia do usuniętego posta są usuwane

Inne użytkownicy nie mogą edytować ani usuwać postów innych ludzi

System wymaga potwierdzenia przed usunięciem posta

Scenariusz główny – edycja posta
Zalogowany użytkownik przegląda swój post.

Użytkownik kliknie opcję "Edytuj".

Post przechodzi w tryb edycji z dostępnym polem tekstowym.

Użytkownik zmienia treść posta.

Użytkownik zatwierdza zmiany kliknięciem "Zapisz".

System aktualizuje treść posta i oznacza go jako "edytowany".

Post wyświetla się z nową treścią oraz informacją o edycji.

Scenariusze alternatywne – edycja
A1. Użytkownik anuluje edycję → post powraca do widoku standardowego bez zmian.

A2. Błąd przy zapisywaniu edycji → system wyświetla powiadomienie o błędzie i oferuje ponowną próbę.

A3. Post zawiera media → użytkownik może usunąć lub dodać nowe załączniki podczas edycji.

A4. Tekst posta jest pusty → system wyświetla komunikat o błędzie i nie pozwala zapisać.

Scenariusz główny – usuwanie posta
Zalogowany użytkownik przegląda swój post.

Użytkownik kliknie opcję "Usuń".

System wyświetla potwierdzenie: "Czy na pewno chcesz usunąć ten post?".

Użytkownik potwierdza usunięcie.

System usuwa post ze wszystkich chronologii.

Komentarze i polubienia związane z postem są usuwane.

Użytkownik widzi komunikat potwierdzający usunięcie.

Scenariusze alternatywne – usuwanie
B1. Użytkownik anuluje usuwanie → post pozostaje bez zmian.

B2. Błąd przy usuwaniu → system wyświetla powiadomienie o błędzie i oferuje ponowną próbę.

B3. Inny użytkownik próbuje edytować/usunąć post → system wyświetla komunikat "Nie masz uprawnień do tej akcji".

B4. Post zawiera komentarze → system usuwa wszystkie komentarze oraz powiadomienia do nich.

Scenariusz główny – wyświetlanie opcji edycji/usuwania
Zalogowany użytkownik przegląda posty.

Jeśli post jest jego autorstwa, wyświetlają się opcje "Edytuj" i "Usuń".

Jeśli post należy do innego użytkownika, opcje są niedostępne.

Kliknięcie menu (np. trzy kropki) wyświetla dostępne opcje.

Scenariusze alternatywne – uprawnienia
C1. Administrator usuwa post użytkownika → post jest usuwany z powodu naruszenia zasad, użytkownik otrzymuje powiadomienie.

C2. Konto zostało dezaktywowane → posty pozostają widoczne (opcjonalnie mogą być archiwizowane).
