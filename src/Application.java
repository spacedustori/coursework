import jedi.commands.*;
import jedi.core.Galaxy;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean end = false;
        Galaxy galaxy = null;

        System.out.println("Welcome to this app!");
        while (!end){
            System.out.println("What do you wish to do?");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            String[] commandInfo = command.split(" ");
            switch (commandInfo[0]){
                case "help":
                    Command help = new HelpCommand();
                    help.execute(galaxy);
                    break;
                case "exit":
                    end = true;
            }
        }
    }
}