package ru.krista.edu.distrib.tech.socket;

import java.io.IOException;
import java.net.ConnectException;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            EchoClient client = new EchoClient();
            client.startConnection("localhost", 6000);
            System.out.println(client.readMessage());
            client.stopConnection();
        } catch (ConnectException ex) {
            System.out.println("connect refused");
        }
    }
}
