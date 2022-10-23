package client;

import java.io.IOException;

public class Teste04 {
    public static void main(String[] args) throws IOException, InterruptedException {

        EchoClient client1 = new EchoClient();
        client1.startConnection("15.235.72.26", 5555);

        while (true){
            Thread.sleep(1000);
            String message = client1.getMessage();
            if (message != null){
                System.out.println(message);
            }
        }
    }
}
