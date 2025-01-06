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
    public void execute(Galaxy galaxy) throws JediMissingException,PlanetMissingException,CommandException {
        String color;
        if(galaxy.getContainingFile()!=null){
            if(defaultRank){
                color = galaxy.getMostUsedSaberColor(planetName);
            }
            else {
                color = galaxy.getMostUsedSaberColor(planetName,jediRank);
            }
            System.out.println("The most used saber color is "+color+".");
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}