package jedi.commands;

import jedi.core.*;

public class CreateJediCommand implements Command {
    private String planetName;
    private String jediName;
    private Rank jediRank;
    private int jediAge;
    private String saberColor;
    private double jediStrength;

    public CreateJediCommand(String planetName,String jediName, String jediRank, String jediAge, String saberColor, String jediStrength) throws IllegalArgumentException {
        this.planetName = planetName;
        this.jediName = jediName;
        this.jediRank = Rank.valueOf(jediRank.toUpperCase());
        this.jediAge = Integer.parseInt(jediAge);
        this.saberColor = saberColor;
        this.jediStrength = Double.parseDouble(jediStrength);
    }

    @Override
    public void execute(Galaxy galaxy) throws CommandException {
        if(galaxy.getContainingFile()!=null){
            if(galaxy.createJedi(planetName,jediName,jediRank,jediAge,saberColor,jediStrength)){
                System.out.println(jediName + " has arrived on planet/moon "+planetName+"!");
            }else {
                System.out.println("This jedi is already somewhere else in the galaxy.");
            }
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}