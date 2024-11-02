/* *******************************************************************************************************************************************
* At the beginning of the code there are imports that allow you to use different classes and interfaces. In this case,
the classes FileWriter (used to write text data to a file), IOException (The IOException class is
an exception that is thrown when an input/output error occurs during file or stream operations),
ArrayList (is an implementation of a dynamic array that can store elements of any type),
Collections (contains methods for manipulating collections, such as sorting, searching, and more),
Comparator (is a functional interface that is used to compare objects and define custom comparisons),
and List (is an interface that represents an ordered collection of elements that can contain duplicates)
from the java.io package and the classes Library, Book, Reader, and Loan defined in the same file.

* The Library class:

The Library class is the main class in the library system. It contains three lists: books, readers, and loans,
which store information about books, readers, and loans.

The Library constructor method initializes these lists as empty lists.

The addBook method adds a new book to the book list and sorts the list by the year of publication of the books.

The removeBook method removes a book with the given title from the book list.

The addReader method adds a new reader to the readers list.

The removeReader method removes a reader with the given name and surname from the readers list.

The displayBookList method displays all saved books from the book list.

The findBook method is responsible for searching for a Book object based on the given title.

The displayReaderList method displays all saved readers from the readers list.

The borrowBook ​​method allows a reader to borrow a book. It checks if the reader and the book with the given data exist, then creates a Loan object and adds it to the loan list.

The displayLoanBook method displays all borrowed books from the loan list.

The generateReport method generates reports based on available and borrowed books. It creates two objects of the type
StringBuilder - dostepneKsiazki and wypoczczoneKsiazki. Then it iterates through the book list and checks if each
book is borrowed. Based on this, it adds the appropriate information to the appropriate StringBuilder. Finally,
it writes the generated reports to the files "dostepne_ksiazki.txt" and "wypozyczone_ksiazki.txt" using the FileWriter class.

Using the Library class
To use the Library class, you must create an object of this class and call the appropriate methods on this object.

* author: <Credit project, Mariusz Turski >
*************************************************************************************************************************** */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Biblioteka {
    private List<Ksiazka> ksiazki;
    private List<Czytelnik> czytelnicy;
    private List<Wypozyczenie> wypozyczenia;
    public Biblioteka() {
        this.ksiazki = new ArrayList<>();
        this.czytelnicy = new ArrayList<>();
        this.wypozyczenia = new ArrayList<>();
    }
    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
        Collections.sort(ksiazki, Comparator.comparingInt(Ksiazka::getRokWydania));
    }
    public void usunKsiazke(String tytul) {
        ksiazki.removeIf(k -> k.getTytul().equals(tytul));
    }

    public void dodajCzytelnika(Czytelnik czytelnik) {
        czytelnicy.add(czytelnik);
    }
    public void usunCzytelnika(String imie, String nazwisko) {
        czytelnicy.removeIf(c -> c.getImie().equals(imie) && c.getNazwisko().equals(nazwisko));
    }
    public void wyswietlListeKsiazek() {
        System.out.println("Lista wszystkich zapisanych książek:");
        for (Ksiazka ksiazka : ksiazki) {
            System.out.println("Tytuł książki: " + ksiazka.getTytul());
            System.out.println("Rok wydania: " + ksiazka.getRokWydania());
            if (ksiazka.getAutor() != null) {
                System.out.println("Autor: " + ksiazka.getAutor().getImie() + " " + ksiazka.getAutor().getNazwisko());
            }
            System.out.println("-----");
        }
    }
    public Ksiazka znajdzKsiazke(String tytul) {
        for (Ksiazka ksiazka : this.ksiazki) {
            if (ksiazka.getTytul().equals(tytul)) {
                return ksiazka;
            }
        }
        return null;
    }
    public void wyswietlListeCzytelnikow() {
        System.out.println("Lista wszystkich zapisanych czytelników:");
        for (Czytelnik czytelnik : czytelnicy) {
            System.out.println("Imię: " + czytelnik.getImie());
            System.out.println("Nazwisko: " + czytelnik.getNazwisko());
            System.out.println("Numer karty: " + czytelnik.getNumerKarty());
            System.out.println("-----");
        }
    }

    public void wypozyczKsiazke(String numerKarty, String tytul, String dataWypozyczenia, String dataZwrotu) {
        Czytelnik czytelnik = czytelnicy.stream()
                .filter(c -> c.getNumerKarty().equals(numerKarty))
                .findFirst()
                .orElse(null);

        Ksiazka ksiazka = ksiazki.stream()
                .filter(k -> k.getTytul().equals(tytul))
                .findFirst()
                .orElse(null);

        if (czytelnik != null && ksiazka != null) {
            Wypozyczenie wypozyczenie = new Wypozyczenie(dataWypozyczenia, dataZwrotu, ksiazka, czytelnik);
            wypozyczenia.add(wypozyczenie);
            System.out.println("Książka została wypożyczona:");
            System.out.println("Czytelnik: " + czytelnik.getImie() + " " + czytelnik.getNazwisko());
            System.out.println("Tytuł książki: " + ksiazka.getTytul());
            System.out.println("Data wypożyczenia: " + dataWypozyczenia);
            System.out.println("Data zwrotu: " + dataZwrotu);
        } else {
            System.out.println("Nie znaleziono czytelnika lub książki o podanych danych.");
        }
    }

    public void wyswietlWypozyczoneKsiazki() {
        System.out.println("Wypożyczone książki:");
        for (Wypozyczenie wypozyczenie : wypozyczenia) {
            System.out.println("Czytelnik: " + wypozyczenie.getCzytelnik().getImie() + " " + wypozyczenie.getCzytelnik().getNazwisko());
            System.out.println("Tytuł książki: " + wypozyczenie.getKsiazka().getTytul());
            System.out.println("Data wypożyczenia: " + wypozyczenie.getDataWypozyczenia());
            System.out.println("Data zwrotu: " + wypozyczenie.getDataZwrotu());
        }
    }

    public void generujRaport() {
        StringBuilder dostepneKsiazki = new StringBuilder();
        StringBuilder wypozyczoneKsiazki = new StringBuilder();

        for (Ksiazka ksiazka : ksiazki) {
            boolean jestWypozyczona = wypozyczenia.stream()
                    .anyMatch(w -> w.getKsiazka().equals(ksiazka));

            if (!jestWypozyczona) {
                dostepneKsiazki.append("Tytuł książki: ").append(ksiazka.getTytul()).append("\n");
            } else {
                for (Wypozyczenie wypozyczenie : wypozyczenia) {
                    if (wypozyczenie.getKsiazka().equals(ksiazka)) {
                        wypozyczoneKsiazki.append("Czytelnik: ").append(wypozyczenie.getCzytelnik().getImie()).append(" ").append(wypozyczenie.getCzytelnik().getNazwisko()).append("\n");
                        wypozyczoneKsiazki.append("Tytuł książki: ").append(wypozyczenie.getKsiazka().getTytul()).append("\n");
                        wypozyczoneKsiazki.append("Data wypożyczenia: ").append(wypozyczenie.getDataWypozyczenia()).append("\n");
                        wypozyczoneKsiazki.append("Data zwrotu: ").append(wypozyczenie.getDataZwrotu()).append("\n");
                    }
                }
            }
        }

        try {
            FileWriter dostepneKsiazkiWriter = new FileWriter("dostepne_ksiazki.txt");
            dostepneKsiazkiWriter.write(dostepneKsiazki.toString());
            dostepneKsiazkiWriter.close();

            FileWriter wypozyczoneKsiazkiWriter = new FileWriter("wypozyczone_ksiazki.txt");
            wypozyczoneKsiazkiWriter.write(wypozyczoneKsiazki.toString());
            wypozyczoneKsiazkiWriter.close();

            System.out.println("Raporty zostały wygenerowane i zapisane do plików: dostepne_ksiazki.txt, wypozyczone_ksiazki.txt");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania raportów do plików.");
        }
    }
}


