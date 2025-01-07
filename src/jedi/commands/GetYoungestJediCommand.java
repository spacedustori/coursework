package jedi.commands;

import jedi.core.*;

public class GetYoungestJediCommand implements Command {
    private String planetName;
    private String rank;

    public GetYoungestJediCommand(String planetName, String rank) throws IllegalArgumentException {
        this.planetName = planetName;
        this.rank = rank;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            Rank rank = Rank.valueOf(this.rank.toUpperCase());
            System.out.println("The youngest jedi on the planet is "+galaxy.getYoungestJedi(planetName,rank));
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}