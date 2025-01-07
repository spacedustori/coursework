package jedi.commands;

import jedi.core.Galaxy;

public class CloseCommand implements Command {
    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            galaxy.setContainingFile(null);
            galaxy.getPlanets().clear();
            System.out.println("File closed!");
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}