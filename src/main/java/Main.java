import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    private static String scan() {
        Scanner s = new Scanner(in);
        return s.nextLine();
    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("create first")) {
            return CommandType.CREATE_FIRST;
        }

        if (commandString.contains("create second")) {
            return CommandType.CREATE_SECOND;
        }

        if (commandString.contains("delete first")) {
            return CommandType.DELETE_FIRST;
        }

        if (commandString.contains("delete second")) {
            return CommandType.DELETE_SECOND;
        }

        if (commandString.contains("view all")) {
            return CommandType.VIEW_ALL;
        }

        if (commandString.contains("help")) {
            return CommandType.HELP;
        }

        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }

        return CommandType.UNDEFINED;
    }

    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        int i = 1;
        while (i != 0) {
            System.out.println("Введите команду:");
            String s = scan();
            CommandType commandType = getCommandType(s);
            if (commandType == CommandType.HELP) {
                System.out.println("""
                        create first
                        create second
                        delete first
                        delete second
                        view all
                        exit""");
            } else if (commandType == CommandType.CREATE_FIRST) {
                db.getSecond();
                System.out.println("Введите данные в формате (idHuman salary gender)");
                String scan = scan();
                String[] wordsArray = scan.split(" ");
                db.createFirst(wordsArray[0], wordsArray[1], wordsArray[2]);
            } else if (commandType == CommandType.CREATE_SECOND) {
                System.out.println("Введите данные в формате (firstName lastName)");
                String scan = scan();
                String[] wordsArray = scan.split(" ");
                db.createSecond(wordsArray[0], wordsArray[1]);
            } else if (commandType == CommandType.DELETE_FIRST) {
                System.out.println("Введите данные в формате (id)");
                String scan = scan();
                String[] wordsArray = scan.split(" ");
                db.deleteFirst(Integer.parseInt(wordsArray[0]));
            } else if (commandType == CommandType.DELETE_SECOND) {
                System.out.println("Удалять связанные данные из 1 таблицы?(yes,no)");
                s = scan();
                if (s.contains("no")) {
                    System.out.println("Введите данные в формате (id)");
                    String scan = scan();
                    String[] wordsArray = scan.split(" ");
                    db.deleteSecond(Integer.parseInt(wordsArray[0]));
                } else if (s.contains("yes")) {
                    System.out.println("Введите данные в формате (id)");
                    String scan = scan();
                    String[] wordsArray = scan.split(" ");
                    db.deleteSecond(Integer.parseInt(wordsArray[0]));
                    db.deleteFirst(Integer.parseInt(wordsArray[0]));
                }
            } else if (commandType == CommandType.VIEW_ALL) {
                db.getAll();
            } else if (commandType == CommandType.EXIT) {
                i = 0;
            } else {
                System.out.println("Incorrect command");
                i = 0;
            }
        }

    }
}
