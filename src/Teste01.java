import client.GreetClient;

import java.io.IOException;

public class Teste01 {

    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        System.out.println(response);
    }
}
