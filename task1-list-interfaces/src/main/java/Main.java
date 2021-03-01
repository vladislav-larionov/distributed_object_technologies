import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        NetworkInterfaceRetriever retriever = new NetworkInterfaceRetriever();
        System.out.printf("IP address: %s\n", retriever.getIpAddress());
        System.out.printf("Mac address: %s\n", retriever.getMacAddress());
        System.out.println("Network Interfaces:");
        retriever.printNetworkInterfaces();
    }
}
