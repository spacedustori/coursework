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
            galaxy.removeJedi(jediName,planetName);
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}