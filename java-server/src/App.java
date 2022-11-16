import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        App server = new App();
        server.start(5555);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket acceptSocket = serverSocket.accept();
            System.out.println("Cliente conectado do IP " + acceptSocket.getInetAddress().getHostAddress());
            new App.EchoClientHandler(acceptSocket).start();
        }

    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                if (clientSocket != null) {
                    InetAddress inetAddress = serverSocket.getInetAddress();
                    while (true) {
                        out.println(inetAddress.getLocalHost().getHostAddress() + " - " + format.format(new Date()) + " - TEMP=45;UMID=30");
                        Thread.sleep(5000);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace(); //teste commit 
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
