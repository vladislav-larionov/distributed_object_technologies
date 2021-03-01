import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterfaceRetriever {
    InetAddress ip;

    public NetworkInterfaceRetriever() throws UnknownHostException {
        ip = InetAddress.getLocalHost();
    }

    public String getIpAddress() throws UnknownHostException {
        return ip.getLocalHost().getHostAddress();
    }

    public String getMacAddress() throws SocketException, UnknownHostException {
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        if (network == null)
            return "None";
        return byteMacToString(network.getHardwareAddress());

    }

    private String byteMacToString(byte[] mac) {
        if (mac == null)
            return "None";
        StringBuilder builtMac = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            builtMac.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return builtMac.toString();
    }

    public List<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.list(NetworkInterface.getNetworkInterfaces());
    }

    public void printNetworkInterfaces() throws SocketException, UnknownHostException {
        for (NetworkInterface netInterface : getNetworkInterfaces()) {
            printInterface(netInterface);
        }
    }

    private void printInterface (NetworkInterface netInterface) throws SocketException, UnknownHostException {
        System.out.printf("Display name: %s\n", netInterface.getDisplayName());
        System.out.printf("Name: %s\n", netInterface.getName());
        System.out.printf("MAC: %s\n", byteMacToString(netInterface.getHardwareAddress()));
        Enumeration<InetAddress> inetAddresses = netInterface.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.println();
    }
}
