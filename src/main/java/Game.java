import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Game {

    public List<String> gameStart(BufferedReader reader, PrintWriter writer, List<String> listOfCity) throws IOException {
        if (listOfCity.isEmpty()) {
            writer.println("Вы начинаете. Введите любой город");
            String answer = reader.readLine();
            listOfCity.add(answer);
            writer.println("OK");
        }
        return listOfCity;
    }

    public List<String> gameRun(BufferedReader reader, PrintWriter writer, List<String> listOfCity) throws IOException {
        if (!listOfCity.isEmpty()) {
            String lastName = (listOfCity.get(listOfCity.size()-1)).toLowerCase();
            String[] letters = lastName.split("");
            String lastLatter = letters[letters.length-1];
            writer.println("Игра продолжается. Последний город: " + lastName + ", Вам на - " + lastLatter);
            String answer = (reader.readLine()).toLowerCase();
            String[] lettersNew = answer.split("");
            String firstLatter = lettersNew[0];
            if (listOfCity.contains(answer) || !lastLatter.equals(firstLatter)) {
                writer.println("NOT OK");
            } else {
                writer.println("OK");
                listOfCity.add(answer);
            }



        }
      return listOfCity;
    }
}
