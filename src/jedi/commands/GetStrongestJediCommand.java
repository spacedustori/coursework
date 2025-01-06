package jedi.commands;

import jedi.core.Galaxy;

public class GetStrongestJediCommand implements Command {
    private String planetName;

    public GetStrongestJediCommand(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            System.out.println("The strongest jedi on the planet is "+galaxy.getStrongestJedi(planetName));
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}