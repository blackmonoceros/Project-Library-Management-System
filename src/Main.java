/* *** ... * Choice of option
We initialize the variable choice to 0. Starts a do-while loop, which executes until choice equals 11.
In the do-while loop, the user can choose different options. Based on the user's choice, the appropriate
action is performed.

* Here is a description of each choice:

1. Add book to library: The user provides the title and year of publication of the book, and then the book is added to
the library.

2. Remove book from library: The user provides the title of the book, and then the book is removed from the library.

3. Add author to book: The user provides the title of the book, the author, and the author's date of birth. The author is added to the
author list.

4. Remove author from book: The user provides the title of the book and the author to be removed. The author is removed from the author list.

5. Add reader to library: The user provides the name, surname, and library card number of the reader. The reader
is added to the library.

6. Remove reader from library: The user provides the name and surname of the reader to be removed. The reader is removed from the
library.
7. Display list of books and readers: Information about books and readers in the
library is displayed.
8. Borrow a book: The user enters the reader's library card number and the title of the book to borrow.

The book is borrowed.
9. Display borrowed books: Information about borrowed books is displayed.

10. Generate available books report: A report containing information about available books is generated.

11. Exit: The program ends.

* Close the scanner:
At the end of the program, the close() method is called on the Scanner object to release resources.

* author: <Certificate project, Mariusz Turski >
****************************************************************************************************************************** */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Autor> autorzy = new ArrayList<>();
        Biblioteka biblioteka = new Biblioteka();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj książkę do biblioteki");
            System.out.println("2. Usuń książkę z biblioteki");
            System.out.println("3. Dodaj autora do ksiazki");
            System.out.println("4. Usuń autora z ksiazki");
            System.out.println("5. Dodaj czytelnika do biblioteki");
            System.out.println("6. Usuń czytelnika z biblioteki");
            System.out.println("7. Wyświetl listę książek i czytelników");
            System.out.println("8. Wypożycz książkę");
            System.out.println("9. Wyświetl wypożyczone książki");
            System.out.println("10. Wygeneruj raport dostępnych książek");
            System.out.println("11. Wyjście");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Podaj tytuł książki:");
                    String tytul = scanner.nextLine();
                    System.out.println("Podaj rok wydania książki:");
                    int rokWydania = scanner.nextInt();
                    scanner.nextLine();

                    Ksiazka ksiazka = new Ksiazka(tytul, rokWydania);
                    biblioteka.dodajKsiazke(ksiazka);
                    System.out.println("Dodano książkę do biblioteki.");
                    break;
                case 2:
                    System.out.println("Podaj tytuł książki do usunięcia:");
                    String tytulUsun = scanner.nextLine();
                    biblioteka.usunKsiazke(tytulUsun);
                    System.out.println("Usunięto książkę z biblioteki.");
                    break;
                case 3:
                    System.out.println("Podaj tytuł książki:");
                    String tytulKsiazki = scanner.nextLine();
                    System.out.println("Podaj autora:");
                    String autor = scanner.nextLine();
                    System.out.println("Podaj datę urodzenia autora:");
                    String dataUrodzenia = scanner.nextLine();
                    Autor nowyAutor = new Autor(autor, "", dataUrodzenia);
                    for (Autor a : autorzy) {
                        if (a.getImie().equals(autor)) {
                            nowyAutor = a;
                            break;
                        }
                    }
                    Ksiazka ksiazkaDoDodaniaAutora = biblioteka.znajdzKsiazke(tytulKsiazki);
                    if (ksiazkaDoDodaniaAutora != null) {
                        ksiazkaDoDodaniaAutora.dodajAutora(nowyAutor);
                        System.out.println("Autor dodany do książki.");
                    } else {
                        System.out.println("Nie znaleziono książki.");
                    }
                    break;
                case 4:
                    System.out.println("Podaj tytuł książki:");
                    String tytulKsiazki1 = scanner.nextLine();
                    System.out.println("Podaj autora do usunięcia:");
                    String autorDoUsuniecia = scanner.nextLine();
                    Ksiazka ksiazkaDoUsunieciaAutora = biblioteka.znajdzKsiazke(tytulKsiazki1);
                    if (ksiazkaDoUsunieciaAutora != null) {
                        boolean autorUsuniety = ksiazkaDoUsunieciaAutora.usunAutora(autorDoUsuniecia);
                        if (autorUsuniety) {
                            System.out.println("Autor usunięty z książki.");
                        } else {
                            System.out.println("Nie znaleziono autora w książce.");
                        }
                    } else {
                        System.out.println("Nie znaleziono książki.");
                    }
                    break;
                case 5:
                    System.out.println("Podaj imię czytelnika:");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko czytelnika:");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj numer karty bibliotecznej:");
                    String numerKarty = scanner.nextLine();

                    Czytelnik czytelnik = new Czytelnik(imie, nazwisko, numerKarty);
                    biblioteka.dodajCzytelnika(czytelnik);
                    System.out.println("Dodano czytelnika do biblioteki.");
                    break;
                case 6:
                    System.out.println("Podaj imię czytelnika do usunięcia:");
                    String imieUsun = scanner.nextLine();
                    System.out.println("Podaj nazwisko czytelnika do usunięcia:");
                    String nazwiskoUsun = scanner.nextLine();
                    biblioteka.usunCzytelnika(imieUsun, nazwiskoUsun);
                    System.out.println("Usunięto czytelnika z biblioteki.");
                    break;
                case 7:
                    biblioteka.wyswietlListeKsiazek();
                    biblioteka.wyswietlListeCzytelnikow();
                    break;
                case 8:
                    System.out.println("Podaj numer karty bibliotecznej czytelnika:");
                    String numerKartyWypozycz = scanner.nextLine();
                    System.out.println("Podaj tytuł książki do wypożyczenia:");
                    String tytulWypozycz = scanner.nextLine();
                    System.out.println("Podaj datę wypożyczenia:");
                    String dataWypozyczenia = scanner.nextLine();
                    System.out.println("Podaj datę zwrotu:");
                    String dataZwrotu = scanner.nextLine();

                    biblioteka.wypozyczKsiazke(numerKartyWypozycz, tytulWypozycz, dataWypozyczenia, dataZwrotu);
                    break;
                case 9:
                    biblioteka.wyswietlWypozyczoneKsiazki();
                    break;
                case 10:
                    biblioteka.generujRaport();
                    break;
                case 11:
                    System.out.println("Do widzenia!");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                    break;
            }
            System.out.println();
        }
        while (choice != 11);
        scanner.close();
    }
}
