/* ************************************************************************************************************************************
The code shows a class called "Reader". Below is a description of each element of the code:

* Class fields:

name: Private String field that stores the reader's first name.
lastname: Private String field that stores the reader's last name.
cardnumber: Private String field that stores the reader's card number.

* Constructor:

The constructor of the "Reader" class takes three parameters: first name, last name, and cardnumber. The constructor initializes
the class fields using the values ​​passed as arguments.

* Access methods:

getName(): This method returns the value of the name field.
setName(String name): This method sets the value of the name field based on the argument passed.
getLastName(): This method returns the value of the lastName field.
setNazwisko(String surname): This method sets the value of the surname field based on the argument passed.
getCardNumber(): This method returns the value of the CardNumber field.
setCardNumber(String CardNumber): This method sets the value of the CardNumber field based on the argument passed.

* author: <Certificate project, Mariusz Turski >
*************************************************************************************************************************** */

public class Czytelnik {
    private String imie;
    private String nazwisko;
    private String numerKarty;

    public Czytelnik(String imie, String nazwisko, String numerKarty) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKarty = numerKarty;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String getNumerKarty() {
        return numerKarty;
    }
    public void setNumerKarty(String numerKarty) {
        this.numerKarty = numerKarty;
    }
}