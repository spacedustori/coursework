package jedi.commands;

import jedi.core.*;

public class GetMostUsedSaberColorCommand implements Command {
    private String planetName;
    private String jediRank;
    private boolean defaultRank;

    public GetMostUsedSaberColorCommand(String planetName) {
        this.planetName = planetName;
        defaultRank = true;
    }

    public GetMostUsedSaberColorCommand(String planetName, String jediRank) throws IllegalArgumentException {
        this.planetName = planetName;
        this.jediRank = jediRank;
        defaultRank = false;
    }

    @Override
    public void execute(Galaxy galaxy) throws JediMissingException,PlanetMissingException,CommandException {
        String color;
        if(galaxy.getContainingFile()!=null){
            if(defaultRank){
                color = galaxy.getMostUsedSaberColor(planetName);
            }
            else {
                Rank jediRank = Rank.valueOf(this.jediRank.toUpperCase());
                color = galaxy.getMostUsedSaberColor(planetName,jediRank);
            }
            System.out.println("The most used saber color is "+color+".");
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}