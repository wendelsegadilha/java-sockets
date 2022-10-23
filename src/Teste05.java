import client.EchoClient;

import java.io.IOException;

public class Teste05 {
    public static void main(String[] args) throws IOException, InterruptedException {

        EchoClient client1 = new EchoClient();
        client1.startConnection("15.235.72.26", 5555);

        EchoClient client2 = new EchoClient();
        client2.startConnection("127.0.0.1", 5555);

        Thread t1 = new Thread( new ClientThreadPoll(client1));
        Thread t2 = new Thread(new ClientThreadPoll(client2));

        t1.start();
        t2.start();

    }
}
