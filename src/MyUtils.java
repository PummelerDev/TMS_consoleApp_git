import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MyUtils {
    public static String getNumb(int choiseQuantity) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String sc = scanner.nextLine();
            if (sc.equals("exit")) {
                return sc;
            }
            if (StringUtils.isNumeric(sc)
                    && Integer.parseInt(sc) > 0
                    && Integer.parseInt(sc) <= choiseQuantity) {
                return sc;
            } else {
                System.out.println("Incorrect data! Try again.");
            }
        }
    }

    public static String getStringPath(String fileType) {
        while (true) {
            System.out.println("""
                    Enter "exit" to return.
                    Enter a path to directory:
                    """);
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            if (str.equals("exit")) {
                return str;
            }
            File file = new File(str);
            if (file.isFile() & str.toLowerCase().endsWith(fileType)) {
                return str;
            }
            if (file.isDirectory() && Objects.requireNonNull(file.listFiles()).length == 0) {
                System.out.println("Directory is empty.");
                continue;
            }
            if (file.isDirectory()) {
                Stream<File> stream = Arrays.stream(Objects.requireNonNull(file.listFiles()));
                List<File> files = stream.filter(File::isFile)
                        .filter(x -> x.getName().toLowerCase().endsWith(fileType)).toList();
                if (files.size() == 0) {
                    System.out.println("Directory has no " + fileType + " files.");
                    continue;
                }
                System.out.println("Choose a file: ");
                int i = 1;
                for (File item : files
                ) {
                    System.out.println(i++ + "  " + item.getName());
                }
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextInt()) {
                    int sc = scanner.nextInt();
                    if (sc > 0 & sc <= files.size()) {
                        return files.get(sc - 1).getPath();
                    }
                    System.out.println("Incorrect number! Try again.");
                }
            }
            System.out.println("Incorrect data! Try again.");
        }
    }

    public static int fromKeyboardInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("incorrect data");
        }
    }

    public static String fromKeyboardString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
            System.out.println("incorrect data");
        }
    }

    public static String fromKeyboardEmail() {
        String pattern = "([A-Za-z0-9][._%+-]?)+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String sc = scanner.nextLine();
            if (Pattern.matches(pattern, sc)) {
                return sc;
            }
            System.out.println("incorrect data");
        }
    }

    public static String fromKeyboardPhone() {
        String pattern = "(\\+[0-9]{3}\\([0-9]{2}\\)[0-9]{7})";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String sc = scanner.nextLine();
            if (Pattern.matches(pattern, sc)) {
                return sc;
            }
            System.out.println("incorrect data");
        }
    }

    public static String fromKeyboardWebsite() {
        String pattern =
                "^([a-zA-Z0-9_\\-]+(?:\\.[a-zA-Z0-9_\\-]+)*\\.[a-zA-Z]{2,4}(?:\\/[a-zA-Z0-9_]+)*(?:\\/[a-zA-Z0-9_]+\\.[a-zA-Z]{2,4}(?:\\?[a-zA-Z0-9_]+\\=[a-zA-Z0-9_]+)?)?(?:\\&[a-zA-Z0-9_]+\\=[a-zA-Z0-9_]+)*)$";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String sc = scanner.nextLine();
            if (Pattern.matches(pattern, sc)) {
                return sc;
            }
            System.out.println("incorrect data");
        }
    }
}
