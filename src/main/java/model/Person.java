package model;

public class Person {

    public String firstname;
    public String lastname;

    public Person (String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString () {
        return this.firstname + " " + this.lastname;
    }

}
