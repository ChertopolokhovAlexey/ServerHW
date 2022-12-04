import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    public static void main(String[] args) {

        Game game = new Game();

        List<String> listOfCity = new ArrayList<>();

        try (ServerSocket server = new ServerSocket(ServerConfig.PORT)) { // запускаем сервер
            System.out.println("Сервер запущен.");

            while (true) {
                //принимаем подключение
                try (Socket client = server.accept();
                     // что бы общаться с клиентом
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    //игра
                    if (listOfCity.isEmpty()) {
                        listOfCity = game.gameStart(reader, writer, listOfCity);
                    } else {
                        listOfCity = game.gameRun(reader, writer, listOfCity);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("отвалилось");
    }
}
