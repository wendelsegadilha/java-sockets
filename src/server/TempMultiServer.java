package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TempMultiServer {

    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        TempMultiServer server = new TempMultiServer();
        server.start(5555);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true)
            new TempMultiServer.EchoClientHandler(serverSocket.accept()).start();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                if (clientSocket != null){
                    while (true) {
                        out.println(format.format(new Date()) + " - TEMP=45;UMID=30");
                        Thread.sleep(5000);
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
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
