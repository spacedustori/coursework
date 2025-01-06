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

        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}
