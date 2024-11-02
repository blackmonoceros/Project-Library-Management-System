/* *********************************************************************************************************************************
The code shows a class called "Loan". Below is a description of each element of the code:

* Class fields:

LoanDate: Private field of type String that stores the loan date.
ReturnDate: Private field of type String that stores the return date.
Book: Private field of type Book that stores a Book class object.
Reader: Private field of type Reader that stores a Reader class object.

* Constructor:

The "Loan" class constructor accepts four parameters: LoanDate, ReturnDate, Book, and Reader.

The constructor initializes the class fields using the values ​​passed as arguments.

* Access methods:

getLoanDate(): This method returns the value of the LoanDate field.
setDataWypożyczenia(String dataWypożyczenia): This method sets the value of the dataWypożyczenia field based on the passed argument.
getDataZwrotu(): This method returns the value of the dataZwrotu field.
setDataZwrotu(String dataZwrotu): This method sets the value of the dataZwrotu field based on the passed argument.
getKsiazka(): This method returns an object of the Book class stored in the book field.
setKsiazka(Ksiazka ksiazka): This method sets the value of the book field based on the passed Book class object.
getCzytelnik(): This method returns an object of the Reader class stored in the reader field.
setCzytelnik(Czytelnik czytanek): This method sets the value of the reader field based on the passed Reader class object.

* author: <Project, Mariusz Turski > ********************************************************************************************************************************* */

public class Wypozyczenie {
    private String dataWypozyczenia;
    private String dataZwrotu;
    private Ksiazka ksiazka;
    private Czytelnik czytelnik;

    public Wypozyczenie(String dataWypozyczenia, String dataZwrotu, Ksiazka ksiazka, Czytelnik czytelnik) {
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
        this.ksiazka = ksiazka;
        this.czytelnik = czytelnik;
    }
    public String getDataWypozyczenia() {
        return dataWypozyczenia;
    }
    public void setDataWypozyczenia(String dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }
    public String getDataZwrotu() {
        return dataZwrotu;
    }
    public void setDataZwrotu(String dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }
    public Ksiazka getKsiazka() {
        return ksiazka;
    }
    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }
}