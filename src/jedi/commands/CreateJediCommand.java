package jedi.commands;

import jedi.core.*;

public class CreateJediCommand implements Command {
    private String planetName;
    private String jediName;
    private Rank jediRank;
    private int jediAge;
    private String saberColor;
    private double jediStrength;

    public CreateJediCommand(String jediName, String jediRank, String jediAge, String saberColor, String jediStrength) throws IllegalArgumentException {
        this.jediName = jediName;
        this.jediRank = Rank.valueOf(jediRank.toUpperCase());
        this.jediAge = Integer.parseInt(jediAge);
        this.saberColor = saberColor;
        this.jediStrength = Double.parseDouble(jediStrength);
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public void setJediRank(Rank jediRank) {
        this.jediRank = jediRank;
    }

    public void setJediAge(int jediAge) {
        this.jediAge = jediAge;
    }

    public void setSaberColor(String saberColor) {
        this.saberColor = saberColor;
    }

    public void setJediStrength(double jediStrength) {
        this.jediStrength = jediStrength;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            galaxy.createJedi(planetName,jediName,jediRank,jediAge,saberColor,jediStrength);
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}