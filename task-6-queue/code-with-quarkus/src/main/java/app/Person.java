package app;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<String> phones;

    public Person(String firstName, String lastName, ArrayList<String> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = new ArrayList<String>();
    }

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.phones = new ArrayList<String>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "app.Person: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(phones, person.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phones);
    }
}
