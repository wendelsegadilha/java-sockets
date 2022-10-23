import client.EchoClient;

import java.io.IOException;

public class Teste03 {

    public static void main(String[] args) throws IOException {

        EchoClient client1 = new EchoClient();
        EchoClient client2 = new EchoClient();

        client1.startConnection("127.0.0.1", 5555);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage(".");
        System.out.println( msg1);
        System.out.println(msg2);
        System.out.println(terminate);

        client2.startConnection("127.0.0.1", 5555);
        msg1 = client2.sendMessage("hello");
        msg2 = client2.sendMessage("world");
        terminate = client2.sendMessage(".");
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(terminate);

    }
}
