import jedi.commands.*;
import jedi.core.Galaxy;

import java.util.*;

public class JediApplication {
    public static void main(String[] args) {
        boolean end = false;
        Galaxy galaxy = new Galaxy(null);
        System.out.println("Welcome to this app!");
        while (!end){
            System.out.println("What do you wish to do?");
            Scanner input = new Scanner(System.in);
            String commandInput = input.nextLine();
            String[] commandInfo = commandInput.split(" <|> ");
            for (int i=0;i<commandInfo.length;i++){
                commandInfo[i] = commandInfo[i].replaceAll("[<>]","");
            }

            if (commandInfo[0].equals("exit")) {
                end = true;
            } else {
                try {
                    CommandFactory factory = new CommandFactory(Arrays.stream(commandInfo).toList());
                    Command command = factory.create();
                    command.execute(galaxy);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}