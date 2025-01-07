package jedi.commands;

import jedi.core.Galaxy;

public class PrintTwoPlanetsCommand implements Command {
    private String planetA;
    private String planetB;

    public PrintTwoPlanetsCommand(String planetA, String planetB) {
        this.planetA = planetA;
        this.planetB = planetB;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            System.out.println("Information on the two planets\n"+galaxy.print(planetA,planetB));
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}