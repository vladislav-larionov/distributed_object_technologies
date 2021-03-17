package ru.krista.edu.distrib.tech.socket;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class PortScanner {
    public static void main(String[] args) throws IOException {
        for (int port = 1; port <= 65535; port++)
        {
            if (isPortUsed(port))
                System.out.println(port + " is used");
        }
    }

    static boolean isPortUsed(int port) throws IOException {
        try {
            Socket socket = new Socket("localhost", port);
            socket.close();
            return true;
        } catch (ConnectException ex) {
            return false;
        } catch (SocketException ex) {
            return false;
        }
    }
}
