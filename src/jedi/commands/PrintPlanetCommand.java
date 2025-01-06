package jedi.commands;

import jedi.core.Galaxy;

public class PrintPlanetCommand implements Command {
    private String planetName;

    public PrintPlanetCommand(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){

        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}
