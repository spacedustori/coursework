import jedi.commands.*;
import jedi.core.Galaxy;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean end = false;
        Galaxy galaxy = new Galaxy("a.txt");

        System.out.println("Welcome to this app!");
        while (!end){
            System.out.println("What do you wish to do?");
            Scanner input = new Scanner(System.in);
            String commandInput = input.nextLine();
            String[] commandInfo = commandInput.split(" ");

            if (commandInfo[0].equals("exit")) {
                end = true;
            } else {
                CommandFactory factory = new CommandFactory(Arrays.stream(commandInfo).toList());
                try {
                    Command command = factory.create();
                    command.execute(galaxy);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}