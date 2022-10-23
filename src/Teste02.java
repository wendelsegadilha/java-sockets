import client.EchoClient;

import java.io.IOException;

public class Teste02 {
    static EchoClient client;

    public static void main(String[] args) throws IOException {

        client = new EchoClient();
        client.startConnection("127.0.0.1", 4444);

        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        System.out.println(resp1);
        System.out.println(resp2);
        System.out.println(resp3);
        System.out.println(resp4);

        stop();

    }

    public static void stop() throws IOException {
        client.stopConnection();
    }
}
