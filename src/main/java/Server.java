import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(ServerConfig.PORT)) {

            while (true) {
                // запускам сервер
                try (Socket client = server.accept();
                     // что бы общаться с клиентом
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Client from prt " + client.getPort());

                    writer.println("Hello from server");

                    System.out.println(reader.readLine());

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
