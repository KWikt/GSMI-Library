# GSMI - Gathering, Saving, Managing Invoice Library.

## Do czego służy?
Ma zazadanie ukazać prozpozycję działania prostego programu księgowego.
Można w nim dodawać, usuwać i edytować faktury jak i stałych klijentów.
Wszystkie te czynności można zrobić na osobnych profilach które mają osobny dostęp do swoich własnych danych.

## Jak działać?

1. Urzytkownik rejestruje się wykorzyując link na stronie logowania.
2. Po rejestracji urzytkownik jest przeniesiony na główną stronę gdzie ujży w przyszłości swoje faktury nie zapłacone.
3. Na górze każdej strony będą przyciski funkcyjne pełniące przeróżne role.


### Tworzenie faktury
Klikamy w przycisk na górze strony głównej "Create Invoice",
przenosi nas do podstrony Invoice Creator. Tam trzeba wypełnić wszystkie dane poza opcjonalnym "Notes".

Jeśli nie mamy stworzonego vendora w polu Vendor nie bedziemy mogli nic wybrać.

#### Usuwanie faktury
Jeśli faktura jest Pending albo Overdue, wyświetli się na stronie głównej w tabeli z przyciskiem "Invoice".
Klikając go przeniesie nas do strony "Update Invoice" gdzie na górze ekranu będzie przycisk "Delete Invoice".
Należy uważać ponieważ, program nie pyta o potwierdzenie czynności.

#### Faktury bez Vendora - Blank
Możemy stworzyć fakturę która nie posiada vendora. Faktura ta będzie w kolumnie "Vendor Name" miała słowo klucz Blank.
Te faktury, ukazują się w stronie "List of unowned invoice". Przycisk do strony jest na górze na stronie głównej.

### Tworzenie Vendora
Klikamy w przycisk na górze strony głównej "Create Vendor", przenosi nas do Vendor Creatora
Pola które musimy wypełnić to:

1. Company Name
2. Vat number
3. Address
4. City
5. Bank Account 1
 
i na końcu submit.

#### List of Vendors
Strona jest poświęcona wszystkim vendorom jakich stworzyliśmy.
w niej możemy przejść i edytować profil vendorów oraz sprawdzać ich faktury.

## Słowa do wykładowcy
Program nie posiada praktycznie żadnej walidacji.
Poza domyślną. Tak więc wszystkie maile, telefony itp będzie można wpisywac bezznaczenia tak samo nie posiada walidacji na hasła poza oczywiście 
prostym sprawdzeniem czy hasło się zgadza i czy użytkownik istnieje.


### Instrukcja do Danych
Generalnie wszystko powinno być zrozumiałe z opisów przy polach.
Danych niestety nie mam bo użyłem do programu baze danych H2. 
Niech Pan spróbuje zrobić dwa konta po jednym vendorze pare faktur. Po usuwać vendorów by zobaczyć co się stanie z przypisanymi do nich fakturami.
Edytować rzeczy. 
#### Ps.
Wysłałem Panu zaproszenie na Githubie ale chyba nie zaakceptował Pan albo ja nawaliłem. Tak czy inaczej ponowię próbę dodania Pana do repozytorium jeśli były by problemy z kontaktem
proszę o wysłanie do mnie wiadomości email, który podam w pliku textowym na SAKE.


