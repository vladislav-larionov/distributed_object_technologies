package org.acme.rest.client.person;

public class Company {
    private String user;
    private String catchPhrase;
    private String bs;

    public Company(String user, String catchPhrase, String bs) {
        this.user = user;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public Company() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "user='" + user + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
