/* *********************************************************************************************************************************
The code shows the Author class, which contains three private fields: firstname, lastname, and dateofbirth. The class has a constructor,
which takes three arguments: firstname, lastname, and dateofbirth, and accessors (getters and setters) for each
field.

* Class fields:
firstname: stores the author's first name.
lastname: stores the author's last name.
dateofbirth: stores the author's date of birth.

* Constructor:
Author(String firstname, String lastname, String dateofbirth): creates a new Author object and initializes the firstname, lastname, and dateofbirth fields with the values ​​passed as constructor arguments.

* Methods:
getFirstname(): returns the author's first name.
setFirstname(String firstname): sets the author's first name to the given value.
getLastname(): returns the author's last name.
setNazwiasko(String surname): Sets the author's surname to the given value.
getDataUrodzina(): Returns the author's date of birth.
setDataUrodzina(String dataUrodzina): Sets the author's date of birth to the given value.

* author: <Project, Mariusz Turski >
*************************************************************************************************************************** */

public class Autor {
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;

    public Autor(String imie, String nazwisko, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
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
    public String getDataUrodzenia() {
        return dataUrodzenia;
    }
    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
}






