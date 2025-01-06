package jedi.commands;

import jedi.core.Galaxy;

public class HelpCommand implements Command {

    @Override
    public void execute(Galaxy galaxy) {
        System.out.println("The following commands are supported:\n open <file>    opens file\n"+
                "close    closes currently opened file\nsave     saves the currently open file\n"+
                "saveas   <file> saves the currently open file in <file>\n" +
                "help     prints this information\n" +
                "exit     exists the program");
        if(galaxy!=null){
            System.out.println("[more commands]");
        }
    }
}
