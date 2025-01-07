package jedi.commands;

import jedi.core.Galaxy;

public class AddPlanetCommand implements Command {
    private String planetName;

    public AddPlanetCommand(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public void execute(Galaxy galaxy) throws CommandException {
        if(galaxy.getContainingFile()!=null){
            galaxy.addPlanet(planetName);
            System.out.println(planetName+" has been added to the current galaxy.");
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}