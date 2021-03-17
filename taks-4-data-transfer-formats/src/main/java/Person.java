import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<String> phones;
    private Address address;

    public Person(String firstName, String lastName, ArrayList<String> phones, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
        this.address = address;
    }
    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.phones = new ArrayList<String>();
        this.address = null;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Person: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                ", address=" + address +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(phones, person.phones) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phones, address);
    }
}
