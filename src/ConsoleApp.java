
import java.io.IOException;

public class ConsoleApp {

    public static void start() throws
            IOException {
        while (true) {
            System.out.println("""
                    Welcome to app!
                    Enter a number:
                    1 to parse JSON into the database.
                    2 to add info from keyboard
                    3 make a request
                    Enter "exit" to close the program.
                    """);
            String sc = MyUtils.getNumb(3);
            switch (sc) {
                case "1" -> {
                    System.out.println("JSON parser is running.");
                    Gson_parser.start();
                    System.out.println("JSON parser is closed.");
                }
                case "2" -> {
                    System.out.println("ManualEditing is running.");
                    ManualEditing.start();
                    System.out.println("ManualEditing is closed.");
                }
                case "3"->{
                    System.out.println("RequestApp is running.");
                    Request.start();
                    System.out.println("RequestApp is closed.");
                }
                case "exit" -> {
                    return;
                }
            }
        }
    }
}