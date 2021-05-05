package org.acme.rest.json.person;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private double salary;
    private String currency;
    private int id;

    public Person(String firstName, String lastName, double salary, int id, String currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.id = id;
        this.currency = currency;
    }

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.salary = 0;
        this.id = 0;
        this.currency = "RUB";
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", currency='" + currency + '\'' +
                ", id=" + id +
                '}';
    }

    public double editCurrency(String newCurrency, double coeff) {
        this.currency = newCurrency;
        this.salary *= coeff;
        return this.salary;
    }
}
