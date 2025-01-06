package jedi.commands;

import jedi.core.*;

public class GetYoungestJediCommand implements Command {
    private String planetName;
    private Rank rank;

    public GetYoungestJediCommand(String planetName, String rank) {
        this.planetName = planetName;
        this.rank = Rank.valueOf(rank.toUpperCase());
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