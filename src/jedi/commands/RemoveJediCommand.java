package jedi.commands;

import jedi.core.Galaxy;

public class RemoveJediCommand implements Command {
    private String jediName;
    private String planetName;

    public RemoveJediCommand(String jediName, String planetName) {
        this.jediName = jediName;
        this.planetName = planetName;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            if(galaxy.removeJedi(jediName,planetName)){
                System.out.println("The jedi has successfully been removed from planet "+planetName+"!");
            }
            else {
                System.out.println("This jedi isn't currently on "+planetName+". Try print_jedi to find out their current residence.");
            }
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}