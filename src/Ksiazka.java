/* *********************************************************************************************************************************
The code shows the book class:

* Class fields:

title - stores the title of the book.
yearRelease - stores the year of publication of the book.
author - stores an object of the Author class, which represents the author of the book.

* Constructor:

Book(String title, int yearRelease) - creates a new object of the Book class with the given title and year of publication.
Access methods:

getTitle() - returns the title of the book.
getYearRelease() - returns the year of publication of the book.
getAuthor() - returns an object of the Author class, which represents the author of the book.

* Additional methods:

addAuthor(Author author) - sets the author of the book to the given Author object.
removeAuthor(String name) - removes the author of the book, if any, based on the given name. Returns true if the author
has been removed, or false if the author with the given name does not exist or is not assigned to the book.

* author: <Course project, Mariusz Turski >
************************************************************************************************************************ */

public class Ksiazka {
    private String tytul;
    private int rokWydania;
    private Autor autor;

    public Ksiazka(String tytul, int rokWydania) {
        this.tytul = tytul;
        this.rokWydania = rokWydania;
    }

    public String getTytul() {
        return tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public Autor getAutor() {
        return autor;
    }

    public void dodajAutora(Autor autor) {
        this.autor = autor;
    }
    public boolean usunAutora(String imie) {
        if (autor != null && autor.getImie().equals(imie)) {
            autor = null;
            return true;
        }
        return false;
    }
}
