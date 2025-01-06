package jedi.commands;

import jedi.core.*;

public class GetMostUsedSaberColorCommand implements Command {
    private String planetName;
    private Rank jediRank;
    private boolean defaultRank;

    public GetMostUsedSaberColorCommand(String planetName) {
        this.planetName = planetName;
        defaultRank = true;
    }

    public GetMostUsedSaberColorCommand(String planetName, String jediRank) {
        this.planetName = planetName;
        this.jediRank = Rank.valueOf(jediRank.toUpperCase());
        defaultRank = false;
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
