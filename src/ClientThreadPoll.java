import client.EchoClient;

import java.io.IOException;

public class ClientThreadPoll implements Runnable {

    EchoClient client = null;
    String message = null;

    public ClientThreadPoll(EchoClient client) {
        this.client = client;
    }

    public void setClient(EchoClient client) {
        this.client = client;
    }

    @Override
    public void run() {

        if (client != null) {

            while (true) {
                try {
                    message = client.getMessage();
                    if (message != null) {
                        System.out.println(Thread.currentThread().getName() + " : " + message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
